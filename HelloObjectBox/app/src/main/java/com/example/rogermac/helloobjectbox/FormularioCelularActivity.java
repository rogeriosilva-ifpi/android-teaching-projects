package com.example.rogermac.helloobjectbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.rogermac.helloobjectbox.dal.App;
import com.example.rogermac.helloobjectbox.modelo.Celular;

import io.objectbox.Box;

public class FormularioCelularActivity extends AppCompatActivity {
    private EditText editModelo, editMarca;

    Box<Celular> celularBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        celularBox = ((App) getApplication()).getBoxStore().boxFor(Celular.class);

        //binding
        editModelo = findViewById(R.id.edit_modelo);
        editMarca = findViewById(R.id.edit_marca);
    }

    public void salvarCelular(View view) {

        String modelo = editModelo.getText().toString();
        String marca = editMarca.getText().toString();

        Celular celular = new Celular(modelo, marca);

        celularBox.put(celular);

        //ir para a lista
        verLista(view);

    }

    public void verLista(View view) {
        //ir para a lista
        Intent intent = new Intent(this, ListaCelularActivity.class);
        startActivity(intent);
    }
}
