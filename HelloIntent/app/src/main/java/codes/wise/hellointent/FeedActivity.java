package codes.wise.hellointent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class FeedActivity extends AppCompatActivity {

    private TextView txtBoasVindas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        Intent intent = getIntent();
        String pacote = intent.getStringExtra("usuario");

        txtBoasVindas = (TextView) findViewById(R.id.txtBoasVindas);

        txtBoasVindas.setText("Seja bem-vindo "+pacote);

    }

    public void acaoLigar(View view) {
        Uri uri = Uri.parse("tel:86994593247");
        Intent itLigar = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(itLigar);
    }

    public void acaoSite(View view){
        Uri uri = Uri.parse("http://www.globo.com");
        Intent itSite = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(itSite);

    }
}










