package com.example.rogermac.applesson2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Tela1DOJOActivity extends AppCompatActivity {
    EditText editVelocidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1_dojo);

        editVelocidade = findViewById(R.id.edit_velocidade);
    }

    public void abrir(View view) {
        Intent it = new Intent(this, Tela2calActivity.class);
        double velocidade = Double.parseDouble(editVelocidade.getText().toString());
        it.putExtra("velocidade", velocidade);
        startActivity(it);


    }
}
