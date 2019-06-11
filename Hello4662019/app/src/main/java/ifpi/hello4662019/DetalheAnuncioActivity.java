package ifpi.hello4662019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalheAnuncioActivity extends AppCompatActivity {

    private TextView txtAnuncioTitulo, txtAnuncioValor, txtAnuncioDescricao, txtAnuncioDataPublicacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_anuncio);

        // binding
        txtAnuncioTitulo = findViewById(R.id.txt_anuncio_detalhe_titulo);
        txtAnuncioValor = findViewById(R.id.txt_anuncio_detalhe_valor);
        txtAnuncioDescricao = findViewById(R.id.txt_anuncio_detalhe_descricao);
        txtAnuncioDataPublicacao = findViewById(R.id.txt_anuncio_detalhe_data_publicacao);

        // Pegar as informacoes que foram enviadas da listagem
        Intent it = getIntent();

        String titulo = it.getStringExtra("ANUNCIO_TITULO");
        double valor = it.getDoubleExtra("ANUNCIO_VALOR", 0.0);
        String descricao = it.getStringExtra("ANUNCIO_DESCRICAO");
        String data = it.getStringExtra("ANUNCIO_PUBLICACAO");

        // atualizar as views com os valores recebidos
        txtAnuncioTitulo.setText(titulo);
        txtAnuncioValor.setText("R$ " + valor);
        txtAnuncioDescricao.setText(descricao);
        txtAnuncioDataPublicacao.setText("Publicado em " + data);
    }
}
