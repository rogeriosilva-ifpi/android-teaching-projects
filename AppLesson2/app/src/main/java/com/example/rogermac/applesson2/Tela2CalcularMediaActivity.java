package com.example.rogermac.applesson2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Tela2CalcularMediaActivity extends AppCompatActivity {

    TextView txtNum1, txtNum2;
    double media;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2_calcular_media);

        //pegar minhas intent (q me iniciou)
        Intent intent = getIntent();

        int pacote1 = intent.getIntExtra("n1", 0);
        int pacote2 = intent.getIntExtra("n2", 0);

        // binding
        txtNum1 = findViewById(R.id.txt_numero1);
        txtNum2 = findViewById(R.id.txt_numero2);

        media = (pacote1 + pacote2) / 2.0;

        // atualizar seu valores
        txtNum1.setText(pacote1+"");
        txtNum2.setText(pacote2+"");

    }

    public void calcularEFinalizar(View view) {

        Intent intent = new Intent();
        intent.putExtra("pacote_retorno", media);
        setResult(RESULT_OK, intent);
        finish();

    }
}
