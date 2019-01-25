package com.example.rogermac.helloobjbox2019.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rogermac.helloobjbox2019.FormularioVeiculoActivity;
import com.example.rogermac.helloobjbox2019.ListagemVeiculoActivity;
import com.example.rogermac.helloobjbox2019.R;
import com.example.rogermac.helloobjbox2019.modelos.Montadora;
import com.example.rogermac.helloobjbox2019.modelos.Veiculo;

import io.objectbox.Box;

import static com.example.rogermac.helloobjbox2019.ListagemVeiculoActivity.*;

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

        Montadora montadora = Montadora.getMontadoraNull();
        if (!veiculo.getMontadora().isNull())
            montadora = veiculo.getMontadora().getTarget();

        produtoViewHolder.txtVeiculoMontadoraNome.setText(montadora.toString());

    }

    @Override
    public int getItemCount() {
        return Math.toIntExact(veiculoBox.count());
    }

    class ProdutoViewHolder extends RecyclerView.ViewHolder {

        TextView txtVeiculoNome, txtVeiculoAno, txtVeiculoMontadoraNome;

        ProdutoViewHolder(View view){
            super(view);

            txtVeiculoNome = view.findViewById(R.id.txt_veiculo_nome);
            txtVeiculoAno = view.findViewById(R.id.txt_veiculo_ano);
            txtVeiculoMontadoraNome = view.findViewById(R.id.txt_veiculo_montadora_nome);

            setupClickHandlers(view);

        }

        private void setupClickHandlers(View view) {

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int position = getAdapterPosition();
                    Veiculo veiculo = veiculoBox.getAll().get(position);
                    ///Toast.makeText(context, "Click em " + veiculo, Toast.LENGTH_SHORT).show();

                    final Intent intent = new Intent(context, FormularioVeiculoActivity.class);
                    intent.putExtra(ACTION, ACTION_TYPE.EDITAR);
                    intent.putExtra("veiculo_id", veiculo.getId());
                    context.startActivity(intent);

                }
            });

        }

    }

}
