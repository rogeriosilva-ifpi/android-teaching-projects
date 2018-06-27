package com.example.rogermac.imctemp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Tela2Activity extends AppCompatActivity {
    TextView txtNome;
    TextView txtImc;
    TextView txtSituacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        //binding
        txtNome = findViewById(R.id.txt_nome);
        txtImc = findViewById(R.id.txt_imc);
        txtSituacao = findViewById(R.id.txt_situacao);

        //receber as encomendas
        Intent minhaIntent = getIntent();
        String nome = minhaIntent.getStringExtra("pacote_nome");
        double imc = minhaIntent.getDoubleExtra("pacote_imc", 0.0);

        //calcular a situacao
        String situacao = "";
        if (imc < 18.5){
            situacao = "Abaixo do Peso";
        }else if (imc <= 24.9){
            situacao = "Peso Normal";
        }else if (imc <= 29.9){
            situacao = "Sobrepeso";
        }else if (imc <= 34.9){
            situacao = "Obesidade I";
        }else if (imc <= 39.9){
            situacao = "Obesidade II";
        }else{
            situacao = "Obesidade III";
        }

        //Atualizar a tela
        txtNome.setText(nome);
        txtImc.setText(String.format("%.1f", imc));
        txtSituacao.setText(situacao);
    }
}
