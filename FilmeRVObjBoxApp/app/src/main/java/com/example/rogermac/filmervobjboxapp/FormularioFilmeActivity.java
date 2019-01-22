package com.example.rogermac.filmervobjboxapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rogermac.filmervobjboxapp.modelos.Filme;
import com.example.rogermac.filmervobjboxapp.persistencia.App;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class FormularioFilmeActivity extends AppCompatActivity {

    private EditText editFilmeNome;
    private Box<Filme> boxFilme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_filme);

        //binding
        editFilmeNome = findViewById(R.id.edit_filme_nome);

        BoxStore store = ((App)getApplication()).getBoxStore();

        boxFilme = store.boxFor(Filme.class);

    }

    public void salvarFilme(View view) {

        String nome = editFilmeNome.getText().toString();

        Filme filme = new Filme();
        filme.setNome(nome);

        boxFilme.put(filme);

        Toast.makeText(this, "Filme salvo!", Toast.LENGTH_SHORT).show();

        finish();

    }
}
