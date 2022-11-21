package com.example.ciberluna.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ciberluna.Entidades.Contenido;
import com.example.ciberluna.R;

public class DetalleContenidoFragment extends Fragment {
    TextView contenidoDetalle;
    ImageView imagenDetalle;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.contenido_titulo_fragment,container, false);
        contenidoDetalle = view.findViewById(R.id.contenido_detalle);
        imagenDetalle = view.findViewById(R.id.imagen_detalle);
        //Crear objeto Bundler par recibir el objeto enviado por argumentos
        Bundle objetoContenido = getArguments();
        Contenido contenido = null;
        //Validación para verificar la existencia de argumentos enviados par mostrar
        if (objetoContenido!=null){
            contenido = (Contenido) objetoContenido.getSerializable("objeto");
            //Establecer los datos en las vistas
            contenidoDetalle.setText(contenido.getTitulo());
            imagenDetalle.setImageResource(contenido.getImagenid());
        }
        return view;
    }
}
