package ifpi.hello4662019.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ifpi.hello4662019.R;
import ifpi.hello4662019.modelos.Comida;

public class ComidasAdapter extends RecyclerView.Adapter<ComidasAdapter.ComidaViewHolder> {

    private Context context;
    private List<Comida> comidas;

    public ComidasAdapter(Context context, List<Comida> comidas) {
        this.context = context;
        this.comidas = comidas;
    }

    @NonNull
    @Override
    public ComidaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_comida, viewGroup, false);

        return new ComidaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComidaViewHolder comidaViewHolder, int posicao) {
        Comida comida = comidas.get(posicao);

        comidaViewHolder.txtComidaNome.setText(comida.getNome());
        comidaViewHolder.txtComidaIngredientes.setText(comida.getIngredientes());
        String valor = String.format("R$ %.2f", comida.getValor());
        comidaViewHolder.txtComidaValor.setText(valor);
    }

    @Override
    public int getItemCount() {
        return comidas.size();
    }





    class ComidaViewHolder extends RecyclerView.ViewHolder{
        TextView txtComidaNome;
        TextView txtComidaIngredientes;
        TextView txtComidaValor;
        Button btnAdicionar;

        ComidaViewHolder(@NonNull View itemView) {
            super(itemView);

            // Binding
            txtComidaNome = itemView.findViewById(R.id.txt_comida_nome);
            txtComidaIngredientes = itemView.findViewById(R.id.txt_comida_ingredientes);
            txtComidaValor = itemView.findViewById(R.id.txt_comida_valor);
            btnAdicionar = itemView.findViewById(R.id.btn_adicionar);


            // Configurar clicks
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int posicao = getAdapterPosition();
//
//                    Toast.makeText(context, "Clicou", Toast.LENGTH_SHORT).show();
//                }
//            });

            btnAdicionar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Comida comida = comidas.get(getAdapterPosition());
                    Snackbar.make(v, comida.getNome() + " adicionado ao pedido", Snackbar.LENGTH_LONG).show();
                }
            });


        }


    }
}
