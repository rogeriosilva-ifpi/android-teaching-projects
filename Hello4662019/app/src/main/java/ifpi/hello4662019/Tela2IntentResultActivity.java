package ifpi.hello4662019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Tela2IntentResultActivity extends AppCompatActivity {

    public static final String TELEFONE_EXTRA = "telefone";
    EditText editTelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2_intent_result);

        editTelefone = findViewById(R.id.edit_telefone);
    }

    public void finalizar(View view) {
        String telefone = editTelefone.getText().toString();

        // criar uma intent nova para retorno de dados
        Intent intent = new Intent();
        // anexa os pacotes de devolucao
        intent.putExtra(TELEFONE_EXTRA, telefone);
        // sinalizar se deu certo
        setResult(RESULT_OK, intent);
        // encerra
        finish();
    }

    public void cancelar(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }
}
