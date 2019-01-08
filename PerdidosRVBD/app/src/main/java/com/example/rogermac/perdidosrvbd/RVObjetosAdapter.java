package com.example.rogermac.perdidosrvbd;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RVObjetosAdapter extends RecyclerView.Adapter<RVObjetosAdapter.ProdutoViewHolder> {

    private Context context;
    private List<Objeto> objetos;

    public RVObjetosAdapter(Context context, List<Objeto> objetos) {
        this.context = context;
        this.objetos = objetos;
    }

    @NonNull
    @Override
    public ProdutoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(this.context);

        View view = inflater.inflate(R.layout.item_rv_objetos, viewGroup, false);

        return new ProdutoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoViewHolder produtoViewHolder, int pos) {

        Objeto objeto = this.objetos.get(pos);

        produtoViewHolder.txtNome.setText(objeto.getNome());
        produtoViewHolder.txtId.setText(""+objeto.getId());

    }

    @Override
    public int getItemCount() {
        return this.objetos.size();
    }

    class ProdutoViewHolder extends RecyclerView.ViewHolder{

        TextView txtNome, txtId;

        public ProdutoViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNome = itemView.findViewById(R.id.txt_nome);
            txtId = itemView.findViewById(R.id.txt_id);
        }
    }
}
