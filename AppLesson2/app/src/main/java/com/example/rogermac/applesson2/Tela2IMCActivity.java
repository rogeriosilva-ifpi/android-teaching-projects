package com.example.rogermac.applesson2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Tela2IMCActivity extends AppCompatActivity {
    TextView txtPeso;
    EditText editAltura;
    double pesoRecebido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2_imc);
        txtPeso = findViewById(R.id.txt_peso);
        editAltura = findViewById(R.id.edit_altura);

        Intent it = getIntent();
        pesoRecebido = it.getDoubleExtra("pacote", 0.0);

        txtPeso.setText(pesoRecebido + " Kg");
    }

    public void calcular(View view) {
        // 1 - Pegar altura
        double altura = Double.parseDouble(editAltura.getText().toString());

        // 2 - Calcular o IMC usando o peso e altura
        double imc = pesoRecebido / (altura * altura);

        // 3 - Criar intent de devolucao e anexar o IMC
        Intent it = new Intent();
        it.putExtra("pacote_devolucao", imc);

        // 4 - Sinalizar que deu OK e finalizar
        setResult(RESULT_OK, it);
        finish();
    }
}






