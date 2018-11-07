package com.example.rogermac.hellointent4result;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PesosActivity extends AppCompatActivity {

    private TextView txtNota1;
    private TextView txtNota2;
    private EditText editPeso1;
    private EditText editPeso2;
    double nota1, nota2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesos);

        // receber os dados
        Intent intent = getIntent();
        nota1 = intent.getDoubleExtra("nota1", 0.0);
        nota2 = intent.getDoubleExtra("nota2", 0.0);

        // binding
        txtNota1 = findViewById(R.id.txt_nota1);
        txtNota2 = findViewById(R.id.txt_nota2);
        editPeso1 = findViewById(R.id.edit_peso_nota1);
        editPeso2 = findViewById(R.id.edit_peso_nota2);

        //mostrar notas recebidas
        txtNota1.setText("Nota 1: " + nota1);
        txtNota2.setText("Nota 2: " + nota2);

    }

    public void calcular(View view) {

        int peso1 = Integer.parseInt(editPeso1.getText().toString());
        int peso2 = Integer.parseInt(editPeso2.getText().toString());

        double mediaPonderada = ((nota1 * peso1) + (nota2 * peso2)) / (peso1 + peso2);

        //Toast.makeText(this, "Média: " + mediaPonderada, Toast.LENGTH_SHORT).show();

        // Criar intent de Resultado e Finalizar
        Intent intentRetorno = new Intent();

        // Add dados de retorno
        intentRetorno.putExtra("media", mediaPonderada);

        // Setar resultado
        setResult(RESULT_OK, intentRetorno);

        // Encerrar
        finish();
    }
}
