package com.example.ciberluna.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ciberluna.Entidades.Contenido;
import com.example.ciberluna.R;

import java.util.ArrayList;

public class AdapterContenido extends RecyclerView.Adapter<AdapterContenido.ViewHolder> implements View.OnClickListener{

    LayoutInflater inflater;
    ArrayList<Contenido> model;

    //listener
    private View.OnClickListener listener;

    public AdapterContenido(Context context, ArrayList <Contenido> model){
        this.inflater=LayoutInflater.from(context);
        this.model = model;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lista_main, parent,false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String titulo = model.get(position).getTitulo();
        String descripcion = model.get(position).getDescripcion();
        int imagen = model.get(position).getImagenid();
        holder.titulo.setText(titulo);
        holder.descripcion.setText(descripcion);
        holder.imagen.setImageResource(imagen);
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titulo, descripcion;
        ImageView imagen;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.titulo_contenido);
            descripcion = itemView.findViewById(R.id.descripcion);
            imagen=itemView.findViewById(R.id.imagen_main);
        }
    }
}
