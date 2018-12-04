package com.example.rogermac.appcountads;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Intent4ResultActivity extends AppCompatActivity {

    public static final String PACOTE = "pacote";
    public static final int REQUEST_CODE = 1001;

    private EditText editNome;
    private TextView txtPeso;
    String nome = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent4_result);

        editNome = findViewById(R.id.edit_nome);
        txtPeso = findViewById(R.id.txt_peso);
    }


    public void prosseguir(View view) {

        nome = editNome.getText().toString();

        final Intent intent = new Intent(this, Intent4ResultTela2Activity.class);
        intent.putExtra(PACOTE, nome);

        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE){
            if (resultCode == RESULT_OK){
                double peso = data.getDoubleExtra(Intent4ResultTela2Activity.ENCOMENDA, 0.0);
                txtPeso.setText(nome + "\nPesa: " + peso + " Kg");
                txtPeso.setVisibility(View.VISIBLE);
                editNome.getText().clear();
            }
        }

    }
}
