package ifpi.hello4662019;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Tela1IntentResultActivity extends AppCompatActivity {

    public static final int OBTER_TELEFONE_CODE = 180;
    TextView txtTelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1_intent_result);

        txtTelefone = findViewById(R.id.txt_telefone_retornado);
    }

    public void obterTelefone(View view) {
        Intent intent = new Intent(this, Tela2IntentResultActivity.class);
        startActivityForResult(intent, OBTER_TELEFONE_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == OBTER_TELEFONE_CODE){ // que eh a minha intent
            if (resultCode == RESULT_OK){ // que deu certo
                // vou pegar minha encomenda
                String encomenda = data.getStringExtra(Tela2IntentResultActivity.TELEFONE_EXTRA);
                txtTelefone.setText(encomenda);
            }else{
                txtTelefone.setText("Sem telefone");
            }

        }

    }
}
