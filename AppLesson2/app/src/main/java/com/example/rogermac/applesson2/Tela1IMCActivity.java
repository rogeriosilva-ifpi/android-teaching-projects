package com.example.rogermac.applesson2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Tela1IMCActivity extends AppCompatActivity {

    private final int ACTIVITY_CALCULAR_IMC = 21;

    EditText editPeso;
    TextView txtImcRecebido, txtClassificacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1_imc);
        editPeso = findViewById(R.id.edit_peso);
        txtImcRecebido = findViewById(R.id.txt_imc_recebido);
        txtClassificacao = findViewById(R.id.txt_classificacao);

        txtImcRecebido.setVisibility(View.INVISIBLE);
        txtClassificacao.setVisibility(View.INVISIBLE);
    }

    public void continuar(View view) {
        double peso = Double.parseDouble(editPeso.getText().toString());

        Intent it = new Intent(this, Tela2IMCActivity.class);
        it.putExtra("pacote", peso);
        startActivityForResult(it, ACTIVITY_CALCULAR_IMC);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ACTIVITY_CALCULAR_IMC){
            if (resultCode == RESULT_OK){
                double imc = data.getDoubleExtra("pacote_devolucao", 0.0);
                txtImcRecebido.setText(String.format("%.1f", imc));

                /*
                <18,5 - MAGREZA
                <25 - SAUDÁVEL
                <30 - SOBREPESO
                <35 - OBESIDADE I
                <40 - OBESIDADE II
                40+ - OBESIDADE III
                 */
                if (imc < 18.5){
                    txtClassificacao.setText("MAGREZA");
                }else if (imc < 25){
                    txtClassificacao.setText("SAUDÁVEL");
                }else if (imc < 30){
                    txtClassificacao.setText("SOBREPESO");
                }else if (imc < 35){
                    txtClassificacao.setText("OBESIDADE I");
                }else if (imc < 40){
                    txtClassificacao.setText("OBESIDADE II");
                }else {
                    txtClassificacao.setText("OBESIDADE III");
                }


                txtImcRecebido.setVisibility(View.VISIBLE);
                txtClassificacao.setVisibility(View.VISIBLE);

            }
        }
    }
}
