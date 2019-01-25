package com.example.rogermac.filmervobjboxapp.adapters;

import android.animation.LayoutTransition;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rogermac.filmervobjboxapp.FilmesActivity;
import com.example.rogermac.filmervobjboxapp.FormularioFilmeActivity;
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

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_filme, viewGroup, false);

        FilmeViewHolder holder = new FilmeViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FilmeViewHolder filmeViewHolder, final int posicao) {

        final Filme filme = this.filmes.get(posicao);

        filmeViewHolder.txtFilmeNome.setText(filme.getNome());
        filmeViewHolder.txtFilmeGenero.setText(filme.getGenero());
        filmeViewHolder.txtFilmeAno.setText(filme.getAno()+"");

//        if (posicao % 2 == 0)
//            filmeViewHolder.layout.setBackgroundColor(Color.GREEN);

        // Gerenciar clicks
        filmeViewHolder.imgEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FormularioFilmeActivity.class);
                intent.putExtra("filme_id", filme.getId());
                context.startActivity(intent);
            }
        });

        filmeViewHolder.imgExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setTitle("Exclusão");
                builder.setMessage("Confirmar remoção do filme " + filme.getNome() + "?");
                builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        filmes.remove(filme);
                        ((FilmesActivity)context).ExcluirFilmeDoBD(filme.getId());
                        notifyItemRangeRemoved(0, posicao);
                        notifyDataSetChanged();
                        Toast.makeText(context, filme.getNome() + " removido.", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("NÃO", null);

                builder.create().show();


            }
        });

    }

    @Override
    public int getItemCount() {
        return this.filmes.size();
    }

    class FilmeViewHolder extends RecyclerView.ViewHolder{

        TextView txtFilmeNome, txtFilmeGenero, txtFilmeAno;
        ImageButton imgEditar, imgExcluir;
        LinearLayout layout;

        public FilmeViewHolder(@NonNull View itemView) {
            super(itemView);
            // binding

            txtFilmeNome = itemView.findViewById(R.id.txt_filme_nome);
            txtFilmeGenero = itemView.findViewById(R.id.txt_filme_genero);
            txtFilmeAno = itemView.findViewById(R.id.txt_filme_ano);
            layout = itemView.findViewById(R.id.layout);
            imgEditar = itemView.findViewById(R.id.icone_editar);
            imgExcluir = itemView.findViewById(R.id.icone_excluir);
        }
    }


}
