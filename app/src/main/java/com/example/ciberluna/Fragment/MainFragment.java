package com.example.ciberluna.Fragment;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ciberluna.Adaptadores.AdapterContenido;
import com.example.ciberluna.Entidades.Contenido;
import com.example.ciberluna.R;
import com.example.ciberluna.iComunicaFragment;

import java.util.ArrayList;

public class MainFragment extends Fragment{

    AdapterContenido adapterContenido;
    RecyclerView recyclerViewContenido;
    ArrayList<Contenido> listaContenido;

    //Referencias para comunicar Fragments
    Activity actividad;
    iComunicaFragment interfaceComunicaFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.main_fragment,container, false);
        recyclerViewContenido = view.findViewById(R.id.recyclerView);
        listaContenido = new ArrayList<>();
        //Cargar la lista
        cargarLista();

        //mostrar data
        mostrarData();

        return view;
    }
    public void cargarLista(){
        listaContenido.add(new Contenido("Mantenimiento a moviles","Preventivo y Correctivo", R.drawable.reparacion));
        listaContenido.add(new Contenido("Mejora del rendimiento","en telefónos moviles", R.drawable.rendimiento_movil));
        listaContenido.add(new Contenido("Mantenimiento a coputadoras","Preventivo y Correctivo", R.drawable.mantenimimiento));
        listaContenido.add(new Contenido("Mejora del rendimiento","en Computadoras", R.drawable.rendimiento_pc));
        listaContenido.add(new Contenido("Reparación de problemas","en hardware y componentes", R.drawable.problemas));
        listaContenido.add(new Contenido("Instalar y Actualizar","paquetería de Office", R.drawable.office));
    }
    public void mostrarData(){
        recyclerViewContenido.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterContenido = new AdapterContenido(getContext(),listaContenido);
        recyclerViewContenido.setAdapter(adapterContenido);

        adapterContenido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titulo = listaContenido.get(recyclerViewContenido.getChildAdapterPosition(view)).getTitulo();
                Toast.makeText(getContext(), "Entrando a "+titulo, Toast.LENGTH_SHORT).show();
                interfaceComunicaFragment.enviarContenido(listaContenido.get(recyclerViewContenido.getChildAdapterPosition(view)));
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
      if (context instanceof  Activity) {
          this.actividad = (Activity) context;
          interfaceComunicaFragment = (iComunicaFragment) this.actividad;
      }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
