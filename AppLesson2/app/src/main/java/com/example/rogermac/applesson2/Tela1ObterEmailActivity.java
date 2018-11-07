package com.example.rogermac.applesson2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Tela1ObterEmailActivity extends AppCompatActivity {

    EditText editEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1_obter_email);

        // binding
        editEmail = findViewById(R.id.edit_email);
    }

    public void abrirSegundaTela(View view) {

        String email = editEmail.getText().toString();

        Intent it = new Intent(this, Tela2ExibirEmailActivity.class);
        it.putExtra("pacote1", email);
        startActivity(it);
    }
}
