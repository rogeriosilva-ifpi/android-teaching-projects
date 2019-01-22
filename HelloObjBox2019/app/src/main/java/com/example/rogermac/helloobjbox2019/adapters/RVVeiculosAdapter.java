package com.example.rogermac.helloobjbox2019.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rogermac.helloobjbox2019.R;
import com.example.rogermac.helloobjbox2019.modelos.Veiculo;

import java.util.List;

import io.objectbox.Box;

public class RVVeiculosAdapter extends RecyclerView.Adapter<RVVeiculosAdapter.ProdutoViewHolder> {


    private Box<Veiculo> veiculoBox;
    private Context context;

    public RVVeiculosAdapter(Box<Veiculo> veiculoBox, Context context) {
        this.veiculoBox = veiculoBox;
        this.context = context;
    }

    @NonNull
    @Override
    public ProdutoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_veiculo, viewGroup, false);

        return new ProdutoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoViewHolder produtoViewHolder, int posicao) {

        Veiculo veiculo = veiculoBox.getAll().get(posicao);

        // preencher a linha com os dados do veiculo atual
        produtoViewHolder.txtVeiculoNome.setText(veiculo.getNome());
        produtoViewHolder.txtVeiculoAno.setText(""+veiculo.getAno());

    }

    @Override
    public int getItemCount() {
        return Math.toIntExact(veiculoBox.count());
    }

    class ProdutoViewHolder extends RecyclerView.ViewHolder {

        TextView txtVeiculoNome, txtVeiculoAno;

        ProdutoViewHolder(View view){
            super(view);

            txtVeiculoNome = view.findViewById(R.id.txt_veiculo_nome);
            txtVeiculoAno = view.findViewById(R.id.txt_veiculo_ano);
        }

    }

}
