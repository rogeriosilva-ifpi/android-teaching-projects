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

    private EditText editFilmeNome, editFilmeGenero, editFilmeAno;
    private Box<Filme> boxFilme;
    Filme filme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_filme);

        //binding
        editFilmeNome = findViewById(R.id.edit_filme_nome);
        editFilmeGenero = findViewById(R.id.edit_filme_genero);
        editFilmeAno = findViewById(R.id.edit_filme_ano);

        BoxStore store = ((App)getApplication()).getBoxStore();

        boxFilme = store.boxFor(Filme.class);

        // Verificar se edicao ou se eh novo
        long id = getIntent().getLongExtra("filme_id", -1);

        if (id == -1){
            // Novo Filme
            filme = new Filme();
        }else {
            // Editando
            filme = boxFilme.get(id);
            editFilmeNome.setText(filme.getNome());
            editFilmeGenero.setText(filme.getGenero());
            editFilmeAno.setText(filme.getAno()+"");
        }

    }

    public void salvarFilme(View view) {

        String nome = editFilmeNome.getText().toString();
        String genero = editFilmeGenero.getText().toString();
        int ano = Integer.parseInt(editFilmeAno.getText().toString());


        filme.setNome(nome);
        filme.setGenero(genero);
        filme.setAno(ano);

        boxFilme.put(filme);

        Toast.makeText(this, "Filme salvo!", Toast.LENGTH_SHORT).show();

        finish();

    }
}
