package com.example.rogermac.applesson4.adapters;

import android.animation.LayoutTransition;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rogermac.applesson4.R;

import java.util.List;

public class RVProdutosAdapter
        extends RecyclerView.Adapter<RVProdutosAdapter.ProdutoViewHolder> {


    private Context context;
    private List<Produto> produtos;

    public RVProdutosAdapter(Context context, List<Produto> produtos){

        this.context = context;
        this.produtos = produtos;
    }


    @NonNull
    @Override
    public ProdutoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_produto, parent, false);

        return new ProdutoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoViewHolder holder, int position) {

        Produto produtoAtual = this.produtos.get(position);

        holder.txtProdutoNome.setText(produtoAtual.getNome());

    }

    @Override
    public int getItemCount() {
        return this.produtos.size();
    }


    public class ProdutoViewHolder extends RecyclerView.ViewHolder{

        TextView txtProdutoNome;

        public ProdutoViewHolder(View itemView) {
            super(itemView);

            txtProdutoNome = itemView.findViewById(R.id.txt_produto_nome);
        }

    }
}
