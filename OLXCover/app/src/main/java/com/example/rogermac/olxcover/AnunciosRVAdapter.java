package com.example.rogermac.olxcover;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.List;

import io.objectbox.Box;

/**
 * Created by rogermac on 15/02/18.
 */

public class AnunciosRVAdapter extends RecyclerView.Adapter<AnunciosRVAdapter.ViewHolder> {


    private List<Anuncio> anuncios;
    private Context context;
    private Box<Anuncio> box;

    public AnunciosRVAdapter(List<Anuncio> anuncios, Context context, Box<Anuncio> box){

        this.anuncios = anuncios;
        this.context = context;
        this.box = box;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final LayoutInflater inflater = LayoutInflater.from(context);

        View linha = inflater.inflate(R.layout.rv_item_anuncio, parent, false);

        return new ViewHolder(linha);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Anuncio anuncio = this.anuncios.get(position);

        holder.tvTitulo.setText(anuncio.getTitulo());
        holder.tvPreco.setText("R$ " + anuncio.getValor());
        holder.tvLocalizacao.setText(anuncio.getLocalizacao());

        holder.itemView.setOnClickListener( view -> {

            final Intent intent = new Intent(context, FormularioAnuncioActivity.class);
            intent.putExtra("anuncioId", anuncio.getId());
            context.startActivity(intent);
        }
        );

        holder.itemView.setOnLongClickListener( view -> {
            PopupMenu popupMenu = new PopupMenu(context, view);
            popupMenu.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener( menuItem -> {
                if (menuItem.getItemId() == R.id.op_remover){

                    AlertDialog.Builder builder = new AlertDialog.Builder(context);

                    builder.setTitle("Confirmacao");
                    builder.setMessage("Desejar mesmo remover o anúncio: " + anuncio.getTitulo());
                    builder.setPositiveButton("SIM", (dialogInterface, i) -> {
                        this.anuncios.remove(anuncio);
                        box.remove(anuncio);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, this.getItemCount());
                    });
                    builder.setNegativeButton("NÃO", null);
                    builder.show();

                }
                return false;
            });

            popupMenu.show();
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return this.anuncios.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvTitulo;
        private TextView tvPreco;
        private TextView tvLocalizacao;

        public ViewHolder(View itemView) {
            super(itemView);

            tvTitulo = itemView.findViewById(R.id.tv_titulo);
            tvPreco = itemView.findViewById(R.id.tv_preco);
            tvLocalizacao = itemView.findViewById(R.id.tv_localizacao);
        }
    }

}
