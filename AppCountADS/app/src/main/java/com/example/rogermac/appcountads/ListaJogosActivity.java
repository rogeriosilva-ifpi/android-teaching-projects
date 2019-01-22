package com.example.rogermac.appcountads;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.rogermac.appcountads.adapters.JogosAdapter;
import com.example.rogermac.appcountads.dal.App;
import com.example.rogermac.appcountads.models.Jogo;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.Box;

public class ListaJogosActivity extends AppCompatActivity {

    RecyclerView rvJogos;

    // objectbox
    Box<Jogo> boxJogos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_jogos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // inicializar box de jogos
        boxJogos = ((App)getApplication()).getBoxStore().boxFor(Jogo.class);

        // povoar bd - comentar a linha apos primeira execução
        //addJogos();

        // COnfiurando a RecyclerVIew

        rvJogos = findViewById(R.id.rv_jogos);

        JogosAdapter adapter = new JogosAdapter(boxJogos.getAll(), this);
        rvJogos.setAdapter(adapter);

        rvJogos.setLayoutManager(new LinearLayoutManager(this));
    }

    public void addJogos(){

        boxJogos.put(new Jogo("FIFA ", 2000, 256));
        boxJogos.put(new Jogo("POKEMON", 1997, 135));
        boxJogos.put(new Jogo("GTA V", 2015, 350));
        boxJogos.put(new Jogo("FIFA", 2000, 256));
        boxJogos.put(new Jogo("POKEMON", 1997, 135));
        boxJogos.put(new Jogo("GTA V", 2015, 350));

    }


}
