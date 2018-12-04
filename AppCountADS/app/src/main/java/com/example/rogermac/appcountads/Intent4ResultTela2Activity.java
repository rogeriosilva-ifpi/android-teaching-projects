package com.example.rogermac.appcountads;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Intent4ResultTela2Activity extends AppCompatActivity {

    public static final String ENCOMENDA = "encomenda";
    private TextView txtNome;
    private EditText editPeso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent4_result_tela2);

        final Intent intent = getIntent();

        String nome = intent.getStringExtra(Intent4ResultActivity.PACOTE);

        txtNome = findViewById(R.id.txt_nome);
        editPeso = findViewById(R.id.edit_peso);

        txtNome.setText(nome);

    }

    public void finalizar(View view) {

        double peso = Double.parseDouble(editPeso.getText().toString());

        Intent intent = new Intent();

        intent.putExtra(ENCOMENDA, peso);

        setResult(RESULT_OK, intent);

        finish();
    }
}
