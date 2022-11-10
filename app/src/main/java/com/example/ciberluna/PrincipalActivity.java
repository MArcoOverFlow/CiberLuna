package com.example.ciberluna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity {

    EditText txtUsuario,txtContraseña;
    //Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txtUsuario=(EditText) findViewById(R.id.editTextTextPersonName2);
        txtContraseña=(EditText) findViewById(R.id.editTextTextPassword);

    }

    public void guardar(View v) {
        if(validar()){
            Toast.makeText(this, "Ingreso datos", Toast.LENGTH_SHORT).show();
            acceder(v);
        }
    }

    private boolean validar(){
        boolean retorno=true;
        String c1= txtUsuario.getText().toString();
        String c2= txtContraseña.getText().toString();
        if(c1.isEmpty()){
            txtUsuario.setError("Este campo esta vacio");
            retorno=false;
        }
        if(c2.isEmpty()){
            txtContraseña.setError("Este campo esta vacio");
            retorno=false;
        }

        return retorno;

    }

    public void acceder(View view){
     Intent i=new Intent(this,InicioActivity.class);
     startActivity(i);
    }

}