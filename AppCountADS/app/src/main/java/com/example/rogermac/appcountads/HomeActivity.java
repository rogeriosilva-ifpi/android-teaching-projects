package com.example.rogermac.appcountads;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    EditText editNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //binding
        editNome = this.findViewById(R.id.edit_nome);

    }

    public void saudar(View view){

        String nome = editNome.getText().toString();

        Toast t = Toast.makeText(this, "Olá " + nome, Toast.LENGTH_SHORT);
        t.show();
    }
}
