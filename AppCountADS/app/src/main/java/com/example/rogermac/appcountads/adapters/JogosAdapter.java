package com.example.rogermac.appcountads.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rogermac.appcountads.R;
import com.example.rogermac.appcountads.models.Jogo;

import java.util.List;

public class JogosAdapter extends RecyclerView.Adapter<JogosAdapter.JogoViewHolder> {


    private List<Jogo> jogos;
    private Context context;

    public JogosAdapter(List<Jogo> jogos, Context context){

        this.jogos = jogos;
        this.context = context;
    }


    @NonNull
    @Override
    public JogoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_jogo, parent, false);

        return new JogoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JogoViewHolder holder, int position) {
        Jogo jogoAtual = this.jogos.get(position);

        holder.txtJogoNome.setText(jogoAtual.getNome());
        holder.txtJogoAno.setText(""+jogoAtual.getAnoLancamento());
        holder.txtJogoPreco.setText("R$ " + jogoAtual.getValor());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Jogo: " + jogoAtual.getNome(), Snackbar.LENGTH_LONG).show();
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Snackbar.make(view, "Segurou: " + jogoAtual.getNome(), Snackbar.LENGTH_LONG).show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.jogos.size();
    }

    public class JogoViewHolder extends RecyclerView.ViewHolder {

        TextView txtJogoNome, txtJogoAno, txtJogoPreco;

        public JogoViewHolder(View itemView) {
            super(itemView);

            txtJogoNome = itemView.findViewById(R.id.txt_jogo_nome);
            txtJogoAno = itemView.findViewById(R.id.txt_jogo_ano);
            txtJogoPreco = itemView.findViewById(R.id.txt_jogo_preco);
        }
    }
}
