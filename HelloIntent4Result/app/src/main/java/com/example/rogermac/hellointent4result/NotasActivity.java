package com.example.rogermac.hellointent4result;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NotasActivity extends AppCompatActivity {

    private EditText editNota1;
    private EditText editNota2;
    private TextView txtLabelMedia;
    private TextView txtMediaRetornada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);

        // binding
        editNota1 = findViewById(R.id.edit_nota1);
        editNota2 = findViewById(R.id.edit_nota2);
        txtLabelMedia = findViewById(R.id.txt_label_media);
        txtMediaRetornada = findViewById(R.id.txt_media_retornada);

    }

    public void calcular(View view) {

        double nota1 = Double.parseDouble(editNota1.getText().toString());
        double nota2 = Double.parseDouble(editNota2.getText().toString());

        // Passar notas para TEla de Pesos
        Intent intent = new Intent(this, PesosActivity.class);
        intent.putExtra("nota1", nota1);
        intent.putExtra("nota2", nota2);

        //startActivity(intent);
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Foi a minha intent que finalizou?
        if (requestCode == 100){

            // Deu certo?
            if (resultCode == RESULT_OK){
                double mediaRetornada = data.getDoubleExtra("media", 0.0);
                exibirMediaRetornada(mediaRetornada);
            }else{
                Toast.makeText(this, "Não foi possível calcular a média. Try Again!", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private void exibirMediaRetornada(double mediaRetornada) {
        txtMediaRetornada.setText(String.format("%.2f", mediaRetornada));

        // Tornar as views visiveis
        txtLabelMedia.setVisibility(View.VISIBLE);
        txtMediaRetornada.setVisibility(View.VISIBLE);
    }
}
