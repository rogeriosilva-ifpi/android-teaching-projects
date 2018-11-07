package com.example.rogermac.appcount466;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class IncrementActivity extends AppCompatActivity {

    TextView txtNumero2;
    EditText editIncremento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_increment);

        // binding
        txtNumero2 = findViewById(R.id.numero2);
        editIncremento = findViewById(R.id.incremento);
    }

    public void mostrarToast(View view) {
        String numero = txtNumero2.getText().toString();
        Toast.makeText(this, "Número: " + numero, Toast.LENGTH_SHORT).show();

    }

    public void incrementarNumero(View view) {
        // pegar incremento
        int incremento = Integer.parseInt(editIncremento.getText().toString());


        String numero = txtNumero2.getText().toString();
        int numeroInteiro = Integer.parseInt(numero);
        numeroInteiro = numeroInteiro + incremento;

        txtNumero2.setText(String.valueOf(numeroInteiro));
    }

    public void decrementarNumero(View view) {
        // pegar incremento
        int incremento = Integer.parseInt(editIncremento.getText().toString());

        // pegar valor atual
        String numero = txtNumero2.getText().toString();
        int numeroInteiro = Integer.parseInt(numero);

        // Modificar o valor
        numeroInteiro = numeroInteiro - incremento;

        // Atualizar a tela
        txtNumero2.setText(String.valueOf(numeroInteiro));
    }
}
