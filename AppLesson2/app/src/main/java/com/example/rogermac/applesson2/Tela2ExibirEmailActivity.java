package com.example.rogermac.applesson2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Tela2ExibirEmailActivity extends AppCompatActivity {

    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2_exibir_email);

        // obter a intent que a iniciou
        Intent it = getIntent();

        // pegar pacotes(extras) enviados
        String pacote = it.getStringExtra("pacote1");


        // binding
        txtResultado = findViewById(R.id.txt_resultado);
        txtResultado.setText(pacote);


    }
}
