package com.example.rogermac.appcount466;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DobroActivity extends AppCompatActivity {

    EditText editNumero;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dobro);

        //binding
        editNumero = findViewById(R.id.numero);
        txtResultado = findViewById(R.id.resultado);
    }

    public void dobro(View view) {
        int valorDigitado = Integer.parseInt(editNumero.getText().toString());

        // mostrar no TextView o dobro
        String dobroEmTexto = String.valueOf(valorDigitado * 2);
        txtResultado.setText(dobroEmTexto);
    }
}
