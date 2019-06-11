package ifpi.hello4662019.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ifpi.hello4662019.DetalheAnuncioActivity;
import ifpi.hello4662019.R;
import ifpi.hello4662019.modelos.Anuncio;

public class ListagemAnunciosAdapter extends RecyclerView.Adapter<ListagemAnunciosAdapter.AnuncioViewHolder>{

    private List<Anuncio> anuncios;
    private Context context;

    public ListagemAnunciosAdapter(List<Anuncio> anuncios, Context context) {
        this.anuncios = anuncios;
        this.context = context;
    }

    @NonNull
    @Override
    public AnuncioViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_anuncio, viewGroup, false);

        return new AnuncioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnuncioViewHolder anuncioViewHolder, int i) {
        Anuncio anuncio = this.anuncios.get(i);
        anuncioViewHolder.txtTitulo.setText(anuncio.getTitulo());
        anuncioViewHolder.txtValor.setText("R$ " + anuncio.getValor());
        String dataBairro = anuncio.getDataPublicacao()+" - "+anuncio.getBairro();
        anuncioViewHolder.txtDataBairro.setText(dataBairro);
    }

    @Override
    public int getItemCount() {
        return this.anuncios.size();
    }

    class AnuncioViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txtTitulo, txtValor, txtDataBairro;

        public AnuncioViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitulo = itemView.findViewById(R.id.txt_anuncio_detalhe_titulo);
            txtValor = itemView.findViewById(R.id.txt_anuncio_valor);
            txtDataBairro = itemView.findViewById(R.id.txt_anuncio_data_bairro);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            int posicao = getAdapterPosition();
            Anuncio anuncio = anuncios.get(posicao);


            Intent telaDetalhes = new Intent(context, DetalheAnuncioActivity.class);
            telaDetalhes.putExtra("ANUNCIO_TITULO", anuncio.getTitulo());
            telaDetalhes.putExtra("ANUNCIO_VALOR", anuncio.getValor());
            telaDetalhes.putExtra("ANUNCIO_DESCRICAO", anuncio.getDescricao());
            telaDetalhes.putExtra("ANUNCIO_PUBLICACAO", anuncio.getDataPublicacao());
            context.startActivity(telaDetalhes);
        }
    }

}
