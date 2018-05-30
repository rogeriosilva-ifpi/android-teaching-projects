package com.example.rogermac.capital;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class Tela2Activity extends AppCompatActivity {

    TextView nomeCapital;
    Map<String, String> paises = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        //binding
        nomeCapital = findViewById(R.id.nome_capital);

        paises.put("Japao", "Tóquio");
        paises.put("Peru", "Lima");
        paises.put("Brasil", "Brasília");
        paises.put("Russia", "Moscou");

        Intent intent = getIntent();
        String pacote = intent.getStringExtra("pacote");
        String capital = paises.get(pacote);

        if (capital == null)
            capital = "NECTD";

        nomeCapital.setText(capital);

    }

    public void fechar(View view) {
        finish();
    }
}
