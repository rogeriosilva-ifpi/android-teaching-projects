package com.example.rogermac.hellomenux.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.rogermac.hellomenux.R;

/**
 * Created by rogermac on 25/01/18.
 */

public class CelularRVAdapter extends RecyclerView.Adapter<CelularRVAdapter.ViewHolder>{

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









