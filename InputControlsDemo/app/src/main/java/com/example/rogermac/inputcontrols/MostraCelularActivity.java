package com.example.rogermac.inputcontrols;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MostraCelularActivity extends AppCompatActivity {

    private static final String TAG = "MostraCelular";

    private TextView txtMarcaModelo;
    private TextView txtMemoriaInternaProcessador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_celular);

        Intent intent = getIntent();
        Celular celular = (Celular) intent.getSerializableExtra("celular");

        //binding
        txtMarcaModelo = (TextView) findViewById(R.id.txt_marca_modelo);
        txtMemoriaInternaProcessador = (TextView) findViewById(R.id.txt_memoria_processador);

        //Atualizer as propriedades
        txtMarcaModelo.setText(celular.getMarca() + " - " + celular.getModelo());
        txtMemoriaInternaProcessador.setText(celular.getArmazenamentoInterno()+" com Proc. " + celular.getProcessador() + "bits");

    }
}
