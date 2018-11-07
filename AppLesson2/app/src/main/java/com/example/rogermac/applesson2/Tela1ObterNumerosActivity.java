package com.example.rogermac.applesson2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Tela1ObterNumerosActivity extends AppCompatActivity {

    EditText editNumero1, editNumero2;
    TextView txtMedia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1_obter_numeros);

        //binding
        editNumero1 = findViewById(R.id.edit_numero1);
        editNumero2 = findViewById(R.id.edit_numero2);
        txtMedia = findViewById(R.id.txt_media);
    }

    public void iniciarCalculo(View view) {

        int num1 = Integer.parseInt(editNumero1.getText().toString());
        int num2 = Integer.parseInt(editNumero2.getText().toString());


        Intent tela2 = new Intent(this, Tela2CalcularMediaActivity.class);

        // anexar os pacotes
        tela2.putExtra("n1", num1);
        tela2.putExtra("n2", num2);

        startActivityForResult(tela2, 1001);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1001){
            if (resultCode == RESULT_OK){
                double pacote_recebido = data.getDoubleExtra("pacote_retorno", 0);
                txtMedia.setText(pacote_recebido+"");
            }
        }

    }
}
