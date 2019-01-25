package com.example.rogermac.filmervobjboxapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.rogermac.filmervobjboxapp.adapters.FilmesAdapter;
import com.example.rogermac.filmervobjboxapp.modelos.Filme;
import com.example.rogermac.filmervobjboxapp.persistencia.App;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class FilmesActivity extends AppCompatActivity {

    RecyclerView rvFilmes;
    private Box<Filme> boxFilme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filmes);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // abra o formulário
                Intent intent = new Intent(FilmesActivity.this, FormularioFilmeActivity.class);
                startActivity(intent);
            }
        });

        BoxStore store = ((App)getApplication()).getBoxStore();

        boxFilme = store.boxFor(Filme.class);

        rvFilmes = findViewById(R.id.rv_filmes);



    }

    @Override
    protected void onResume() {
        super.onResume();
        FilmesAdapter adapter = new FilmesAdapter(this, boxFilme.getAll());

        rvFilmes.setAdapter(adapter);

        rvFilmes.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_filmes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void ExcluirFilmeDoBD(long id){
        boxFilme.remove(id);
    }
}
