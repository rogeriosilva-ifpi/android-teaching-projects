package com.example.rogermac.helloobjectbox.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rogermac.helloobjectbox.R;
import com.example.rogermac.helloobjectbox.modelo.Celular;

import java.util.List;

/**
 * Created by rogermac on 22/01/18.
 */

public class CelularRVAdapter extends RecyclerView.Adapter<CelularRVAdapter.ViewHolder> {


    private Context context;
    private List<Celular> celulares;

    public CelularRVAdapter(Context context, List<Celular> dataset) {
        this.context = context;
        this.celulares = dataset;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvCelularModelo;
        private TextView tvCelularMarca;

        public ViewHolder(View itemView) {
            super(itemView);

            tvCelularModelo = itemView.findViewById(R.id.tv_celular_modelo);
            tvCelularMarca = itemView.findViewById(R.id.tv_celular_marca);
        }

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_celular_rv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Celular celular = this.celulares.get(position);

        holder.tvCelularModelo.setText(celular.getModelo());
        holder.tvCelularMarca.setText(celular.getMarca());


    }

    @Override
    public int getItemCount() {
        return this.celulares.size();
    }
}
