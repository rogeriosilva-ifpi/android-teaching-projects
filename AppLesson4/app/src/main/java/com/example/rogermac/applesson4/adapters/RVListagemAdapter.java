package com.example.rogermac.applesson4.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.rogermac.applesson4.R;
import com.example.rogermac.applesson4.modelos.Jogador;

import java.util.List;

public class RVListagemAdapter
        extends RecyclerView.Adapter<RVListagemAdapter.PalavraViewHolder>{

    private List<Jogador> jogadores;
    private LayoutInflater inflater;
    protected Context context;

    public RVListagemAdapter(Context context, List<Jogador> jogadores){

        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.jogadores = jogadores;

    }

    @NonNull
    @Override
    public PalavraViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_da_listagem, parent, false);

        return new PalavraViewHolder(view, this);
    }


    @Override
    public void onBindViewHolder(@NonNull PalavraViewHolder holder, int position) {

        final Jogador jogadorAtual = this.jogadores.get(position);
        holder.txtNumero.setText(jogadorAtual.getNumero());
        holder.txtNome.setText(jogadorAtual.getNome());
        holder.txtPosicao.setText(jogadorAtual.getPosicao());

        // Configurar Clicks
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Clicou: " + jogadorAtual.getNome(), Snackbar.LENGTH_LONG).show();
            }
        });


        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                PopupMenu pop = new PopupMenu(RVListagemAdapter.this.context, view);
                pop.getMenu().add("Substituir");
                pop.getMenu().add("Cartão Amarelo");
                pop.getMenu().add("Cartão Vermelho");

                pop.show();

                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.jogadores.size();
    }

    class PalavraViewHolder extends RecyclerView.ViewHolder{

        TextView txtNumero, txtNome, txtPosicao;
        RVListagemAdapter adapter;


        public PalavraViewHolder(View itemView, RVListagemAdapter adapter){
            super(itemView);
            this.txtNome = itemView.findViewById(R.id.txt_nome);
            this.txtNumero = itemView.findViewById(R.id.txt_numero);
            this.txtPosicao= itemView.findViewById(R.id.txt_posicao);
            this.adapter = adapter;
        }

    }
}
