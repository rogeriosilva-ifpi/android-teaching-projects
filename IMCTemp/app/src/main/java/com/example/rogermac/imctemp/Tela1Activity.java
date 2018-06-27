package com.example.rogermac.imctemp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Tela1Activity extends AppCompatActivity {

    EditText editNome;
    EditText editPeso;
    EditText editAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        //bindig

        editNome = findViewById(R.id.edit_nome);
        editPeso = findViewById(R.id.edit_peso);
        editAltura = findViewById(R.id.edit_altura);

    }

    public void calcularIMC(View view) {

        // obter dados da tela
        String nome = editNome.getText().toString();
        double peso = Double.parseDouble(editPeso.getText().toString());
        double altura = Double.parseDouble(editAltura.getText().toString());

        // Calcular o IMC
        double imc = peso / (altura * altura);


        Intent intent = new Intent(this, Tela2Activity.class);
        intent.putExtra("pacote_nome", nome);
        intent.putExtra("pacote_imc", imc);

        startActivity(intent);
    }
}
