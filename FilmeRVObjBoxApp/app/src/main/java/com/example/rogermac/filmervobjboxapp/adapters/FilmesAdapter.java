package com.example.rogermac.filmervobjboxapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rogermac.filmervobjboxapp.R;
import com.example.rogermac.filmervobjboxapp.modelos.Filme;

import java.util.List;

public class FilmesAdapter extends RecyclerView.Adapter<FilmesAdapter.FilmeViewHolder> {

    private final Context context;
    private final List<Filme> filmes;

    public FilmesAdapter(Context context, List<Filme> filmes){
        this.context = context;
        this.filmes = filmes;
    }

    @NonNull
    @Override
    public FilmeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FilmeViewHolder filmeViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class FilmeViewHolder extends RecyclerView.ViewHolder{

        TextView txtFilmeNome;

        public FilmeViewHolder(@NonNull View itemView) {
            super(itemView);
            // binding

            txtFilmeNome = itemView.findViewById(R.id.txt_filme_nome);
        }
    }


}
