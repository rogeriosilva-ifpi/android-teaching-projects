package com.example.rogermac.count;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Elementos da View
    EditText editIncremento;
    TextView txtNumero;

    // Variáveis normais
    int valor = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Binding - Conectar com Views do Layout
        editIncremento = findViewById(R.id.edit_incremento);
        txtNumero = findViewById(R.id.txt_numero);

        // Inicializar Views
        txtNumero.setText(String.valueOf(valor));
    }

    public void aumentar(View view) {
        // Pegar o valor do Incremento
        String incremento = editIncremento.getText().toString();
        int incrementoInteiro = Integer.valueOf(incremento);

        // Atualizar o valor exibido
        valor = valor + incrementoInteiro;
        txtNumero.setText(String.valueOf(valor));

    }

    public void diminuir(View view) {
        // Pegar o valor do Incremento
        String incremento = editIncremento.getText().toString();
        int incrementoInteiro = Integer.valueOf(incremento);

        // Atualizar o valor exibido
        valor = valor - incrementoInteiro;
        txtNumero.setText(String.valueOf(valor));
    }

    public void resetar(View view) {
        valor = 10;
        txtNumero.setText(String.valueOf(valor));
    }
}
