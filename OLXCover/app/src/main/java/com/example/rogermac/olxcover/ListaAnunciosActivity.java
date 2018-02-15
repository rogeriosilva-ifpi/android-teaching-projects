package com.example.rogermac.olxcover;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class ListaAnunciosActivity extends AppCompatActivity {

    private RecyclerView rvAnuncios;
    private Box<Anuncio> anuncioBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_anuncios);

        BoxStore store = ((App)getApplication()).getBoxStore();
        anuncioBox = store.boxFor(Anuncio.class);

        setupViews();
    }

    @Override
    protected void onResume() {
        List<Anuncio> anuncios = anuncioBox.getAll();
        AnunciosRVAdapter adapter = new AnunciosRVAdapter(anuncios, this, anuncioBox);

        rvAnuncios.setAdapter(adapter);
        rvAnuncios.setLayoutManager(new LinearLayoutManager(this));
        rvAnuncios.setHasFixedSize(true);

        super.onResume();
    }

    private void setupViews(){
        rvAnuncios = findViewById(R.id.rv_anuncios);
    }

    public void novoAnuncio(View view) {
        startActivity(new Intent(this, FormularioAnuncioActivity.class));
    }
}
