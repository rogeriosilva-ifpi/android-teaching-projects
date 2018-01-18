package com.example.rogermac.contadoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editIncremento;
    private TextView txtDisplay;
    private int valorAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //binding
        editIncremento = findViewById(R.id.edit_incremento);
        txtDisplay = findViewById(R.id.txt_display);

        setValorAtual(0);
    }

    private int obterValorDigitado() {
        String entrada = editIncremento.getText().toString();
        int decremento = 0;
        if (!entrada.trim().isEmpty()){
             decremento = Integer.valueOf(entrada);
        }else {
            Toast.makeText(this, R.string.digite_incremento, Toast.LENGTH_LONG).show();
        }

        return (decremento >= 0 && decremento <= 10) ? decremento : 0;
    }

    public void diminuir(View view) {
        setValorAtual(valorAtual - obterValorDigitado());
    }

    public void aumentar(View view) {
        setValorAtual(valorAtual + obterValorDigitado());
    }

    public void setValorAtual(int novoValor) {
        if (novoValor >= 0 &&  novoValor <= 100){
            this.valorAtual = novoValor;
            txtDisplay.setText(String.valueOf(this.valorAtual));
        }
    }
}
