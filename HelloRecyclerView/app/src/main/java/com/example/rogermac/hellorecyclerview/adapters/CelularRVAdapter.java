package com.example.rogermac.hellorecyclerview.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rogermac.hellorecyclerview.R;
import com.example.rogermac.hellorecyclerview.modelos.Celular;

import java.util.List;

/**
 * Created by rogermac on 15/01/18.
 */

public class CelularRVAdapter extends RecyclerView.Adapter<CelularRVAdapter.ViewHolder>{

    private List<Celular> celulares;
    private Context context;

    public CelularRVAdapter(Context ctx, List<Celular> celulares){
        this.context = ctx;
        this.celulares = celulares;
    }

    // ViewHolder: representa uma linha na lista(recyclerview)
    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtCelularModelo;
        private TextView txtCelularFabricante;
        private TextView txtCelularValor;

        public ViewHolder(View itemView){
            super(itemView);

            // binding das views deste item
            txtCelularModelo = itemView.findViewById(R.id.txt_celular_modelo);
            txtCelularFabricante = itemView.findViewById(R.id.txt_celular_fabricante);
            txtCelularValor = itemView.findViewById(R.id.txt_celular_valor);

        }

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Obter um inflador de layout
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Criar um View a partir de um XML
        View view = inflater.inflate(R.layout.rv_item_celular, parent, false);

        //Criar um nova instância de ViewHolder
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Pegar o celular da posicao
        Celular celular = celulares.get(position);

        holder.txtCelularModelo.setText(celular.getModelo());
        holder.txtCelularFabricante.setText(celular.getFabricante());
        holder.txtCelularValor.setText("R$ " + celular.getValor());

        configurarClicks(holder.itemView, celular, position);

    }

    public void configurarClicks(View itemView, Celular celular, int posicao){

        //Click
        itemView.setOnClickListener((view) -> {
            Toast.makeText(context,
                    "Celular: " + celular.getModelo(),
                    Toast.LENGTH_SHORT).show();
        });

        // Long Click
        itemView.setOnLongClickListener((view) -> {

            PopupMenu popupMenu = new PopupMenu(context, view);
            popupMenu.getMenuInflater().inflate(R.menu.popup_opcoes, popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener((item) -> {

                switch (item.getItemId()){
                    case R.id.opcao_editar:
                        editarCelular(celular, posicao);
                        break;
                    case R.id.opcao_remover:
                        removerCelular(celular, posicao);
                        break;
                }

                return true;
            });

            popupMenu.show();

            return true;
        });

    }

    public void editarCelular(Celular celular, int posicao){

        Toast.makeText(context, "Editando...", Toast.LENGTH_SHORT).show();

    }

    public void removerCelular(Celular celular, int posicao){
        this.celulares.remove(celular);
        notifyItemRemoved(posicao);
        notifyItemRangeChanged(posicao, getItemCount());
    }

    @Override
    public int getItemCount() {
        return this.celulares.size();
    }



}
