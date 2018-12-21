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
import com.example.rogermac.appcountads.models.Jogo;

import java.util.ArrayList;
import java.util.List;

public class ListaJogosActivity extends AppCompatActivity {

    RecyclerView rvJogos;

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

        // COnfiurando a RecyclerVIew

        rvJogos = findViewById(R.id.rv_jogos);

        JogosAdapter adapter = new JogosAdapter(getJogos(), this);
        rvJogos.setAdapter(adapter);

        rvJogos.setLayoutManager(new LinearLayoutManager(this));
    }

    public List<Jogo> getJogos(){

        List<Jogo> jogos = new ArrayList<>();

        for (int i = 0; i < 10000; i++){
            jogos.add(new Jogo("FIFA", 2000, 256));
            jogos.add(new Jogo("POKEMON", 1997, 135));
            jogos.add(new Jogo("GTA V", 2015, 350));
            jogos.add(new Jogo("FIFA", 2000, 256));
            jogos.add(new Jogo("POKEMON", 1997, 135));
            jogos.add(new Jogo("GTA V", 2015, 350));
        }

        return jogos;
    }

}
