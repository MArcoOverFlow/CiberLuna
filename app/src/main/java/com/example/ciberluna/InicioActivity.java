package com.example.ciberluna;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.ciberluna.Entidades.Contenido;
import com.example.ciberluna.Fragment.DetalleContenidoFragment;
import com.example.ciberluna.Fragment.FragmentAgenda;
import com.example.ciberluna.Fragment.FragmentDatos;
import com.example.ciberluna.Fragment.FragmentSolicitud;
import com.example.ciberluna.Fragment.MainFragment;
import com.google.android.material.navigation.NavigationView;

public class InicioActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, iComunicaFragment{

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;

    //variables para cargar el fragment principal
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    //Variable detalle contenido del fragment
    DetalleContenidoFragment detalleContenidoFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        //Establecer evento OnCreate al navigationView
        navigationView.setNavigationItemSelectedListener(this);

        actionBarDrawerToggle=new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();
        //Cargar fragmet principal
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, new MainFragment());
        fragmentTransaction.commit();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if(menuItem.getItemId() == R.id.home){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, new MainFragment());
            fragmentTransaction.commit();
        }
        if(menuItem.getItemId() == R.id.Agenda){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, new FragmentAgenda());
            fragmentTransaction.commit();
        }
        if(menuItem.getItemId() == R.id.solicitud){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, new FragmentSolicitud());
            fragmentTransaction.commit();
        }
        if(menuItem.getItemId() == R.id.datos){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, new FragmentDatos());
            fragmentTransaction.commit();
        }
        return false;
    }

    @Override
    public void enviarContenido(Contenido contenido) {
        //realizar envio
        detalleContenidoFragment = new DetalleContenidoFragment();
        //Objeto Bundle para transportar información
        Bundle bundleEnvio = new Bundle();
        //Enviar el objeto que esta llegando con Serializable
        bundleEnvio.putSerializable("objeto", contenido);
        detalleContenidoFragment.setArguments(bundleEnvio);
        //abrir fragment
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, detalleContenidoFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}