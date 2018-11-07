package com.example.rogermac.appcount466;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CalculadoraActivity extends AppCompatActivity {

    EditText editNumero1, editNumero2;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        // binding
        editNumero1 = findViewById(R.id.numero1);
        editNumero2 = findViewById(R.id.numero2);
        txtResultado = findViewById(R.id.resultado);
    }

    public void somar(View view) {

        // 1) Obter os dois numeros
        int numero1 = Integer.parseInt(editNumero1.getText().toString());
        int numero2 = Integer.parseInt(editNumero2.getText().toString());

        // 2) Realizar a soma
        int soma = numero1 + numero2;

        // 3) Mostrar o resultado
        txtResultado.setText(String.valueOf(soma));

    }

    public void subtrair(View view) {
        // 1) Obter os dois numeros
        int numero1 = Integer.parseInt(editNumero1.getText().toString());
        int numero2 = Integer.parseInt(editNumero2.getText().toString());

        // 2) Realizar a soma
        int soma = numero1 - numero2;

        // 3) Mostrar o resultado
        txtResultado.setText(String.valueOf(soma));

    }
}







