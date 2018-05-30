package com.example.rogermac.capital;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class Tela1Activity extends AppCompatActivity {

    EditText editPais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        //binding
        editPais = findViewById(R.id.edit_pais);
    }

    @Override
    protected void onResume() {
        super.onResume();
        editPais.getText().clear();
    }

    public void pesquisar(View view) {
        String pais = editPais.getText().toString();

        // Criar e configurar a Intent
        Intent intent = new Intent(this, Tela2Activity.class);
        intent.putExtra("pacote", pais);

        // Executar a intent
        startActivity(intent);
    }


}
