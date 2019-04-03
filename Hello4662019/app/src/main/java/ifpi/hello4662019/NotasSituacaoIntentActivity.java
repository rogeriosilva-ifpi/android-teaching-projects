package ifpi.hello4662019;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NotasSituacaoIntentActivity extends AppCompatActivity {

    TextView txtSituacao;
    ImageView imgSituacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas_situacao_intent);

        // binding
        txtSituacao = findViewById(R.id.txt_situacao);
        imgSituacao = findViewById(R.id.img_situacao);

        // receber as encomendas
        Intent it = getIntent();
        double media = it.getDoubleExtra("pacote", 0.0);

        String situacao;
        String cor;

        if (media >= 7){
            situacao = "APROVADO";
            cor = "blue";
            imgSituacao.setImageResource(R.drawable.ic_ok);
        }else{
            situacao = "REPROVADO";
            cor = "red";
            imgSituacao.setImageResource(R.drawable.ic_not_ok);
        }

        txtSituacao.setText(situacao);
        txtSituacao.setTextColor(Color.parseColor(cor));


    }

    public void finalizar(View view) {
        finish();
    }
}
