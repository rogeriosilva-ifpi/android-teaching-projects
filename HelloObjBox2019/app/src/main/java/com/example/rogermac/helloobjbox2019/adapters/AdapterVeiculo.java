package com.example.rogermac.helloobjbox2019.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class AdapterVeiculo extends RecyclerView.Adapter<AdapterVeiculo.VeiculoViewHolder> {


    @NonNull
    @Override
    public VeiculoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull VeiculoViewHolder veiculoViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class VeiculoViewHolder extends RecyclerView.ViewHolder{

        public VeiculoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
