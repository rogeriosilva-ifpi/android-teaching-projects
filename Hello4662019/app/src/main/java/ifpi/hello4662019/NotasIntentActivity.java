package ifpi.hello4662019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NotasIntentActivity extends AppCompatActivity {

    EditText editNota1, editNota2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas_intent);

        // conectar
        editNota1 = findViewById(R.id.edit_nota1);
        editNota2 = findViewById(R.id.edit_nota2);

    }

    public void abrirSituacao(View view) {

        double nota1 = Double.parseDouble(editNota1.getText().toString());
        double nota2 = Double.parseDouble(editNota2.getText().toString());

        double media = (nota1 + nota2) / 2;

        Intent it = new Intent(this, NotasSituacaoIntentActivity.class);
        // anexar um pacote (extra)
        it.putExtra("pacote", media);

        startActivity(it);
    }

    public void limpar(View view) {
        editNota1.setText("");
        editNota2.setText("");
        editNota1.requestFocus();
    }
}









