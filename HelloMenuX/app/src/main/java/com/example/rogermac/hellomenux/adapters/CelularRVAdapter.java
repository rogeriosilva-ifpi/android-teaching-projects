package com.example.rogermac.hellomenux.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rogermac.hellomenux.R;
import com.example.rogermac.hellomenux.modelos.Celular;

import java.util.List;

/**
 * Created by rogermac on 25/01/18.
 */

public class CelularRVAdapter extends RecyclerView.Adapter<CelularRVAdapter.ViewHolder>{

    private List<Celular> celulares;
    private Context context;

    public CelularRVAdapter(List<Celular> celulares, Context context){

        this.celulares = celulares;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_celular, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Celular celular = this.celulares.get(position);

        holder.txtCelularNome.setText(celular.getModelo());
        holder.txtCelularMarca.setText(celular.getMarca());

        setupClicks(holder, celular);


    }

    private void setupClicks(ViewHolder holder, Celular celular) {

        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(context, "CLicou " + celular.getModelo(), Toast.LENGTH_SHORT).show();
        });

        holder.itemView.setOnLongClickListener(v -> {

            final PopupMenu popup = new PopupMenu(context, v);
            popup.getMenuInflater().inflate(R.menu.popup_celular, popup.getMenu());

            //clicklistener

            popup.show();

            return true;
        });

    }

    @Override
    public int getItemCount() {
        return this.celulares.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView txtCelularNome;
        public TextView txtCelularMarca;

        public ViewHolder(View itemView) {
            super(itemView);

            //binding
            txtCelularNome = itemView.findViewById(R.id.txt_celular_nome);
            txtCelularMarca = itemView.findViewById(R.id.txt_celular_marca);
        }
        //Deve ser o espelho da linha
        //2 txtviews
    }


}









