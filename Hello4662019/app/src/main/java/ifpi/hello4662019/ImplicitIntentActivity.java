package ifpi.hello4662019;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ImplicitIntentActivity extends AppCompatActivity {

    EditText editTelefone, editSite, editMapa, editMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        editTelefone = findViewById(R.id.edit_telefone);
        editSite = findViewById(R.id.edit_site);
        editMapa = findViewById(R.id.edit_mapa);
        editMensagem = findViewById(R.id.edit_mensagem);
    }

    public void ligar(View view) {

        String numeroDigitado = editTelefone.getText().toString();

        Uri uri = Uri.parse("tel:"+numeroDigitado);
        Intent itLigar = new Intent(Intent.ACTION_DIAL, uri);

        startActivity(itLigar);

    }

    public void abrirSite(View view) {

        String site =  editSite.getText().toString();

        Uri uri = Uri.parse("http://"+site);
        Intent itSite = new Intent(Intent.ACTION_VIEW, uri);

        startActivity(itSite);

    }

    public void mapa(View view) {
        String local = editMapa.getText().toString();

        Uri uri = Uri.parse("geo:0,0?q="+local);
        Intent itMapa = new Intent(Intent.ACTION_VIEW, uri);

        startActivity(itMapa);

    }

    public void compartilhar(View view) {

        String msg = editMensagem.getText().toString();

        Intent itShare = new Intent();
        itShare.setAction(Intent.ACTION_SEND);
        itShare.putExtra(Intent.EXTRA_TEXT, msg);
        itShare.setType("text/plain");

        startActivity(itShare);

    }
}
