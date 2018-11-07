package com.example.rogermac.appcount466;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtNumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumero = findViewById(R.id.numero);
    }

    public void acerola(View view) {
        String numero = txtNumero.getText().toString();
        String mensagem = "Numero: " + numero;
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }

    public void aumentar(View view) {
        int numero = Integer.parseInt(txtNumero.getText().toString());
        numero = numero + 1;
        txtNumero.setText(String.valueOf(numero));
    }
}
