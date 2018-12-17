package com.example.rogermac.applesson4;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.rogermac.applesson4.adapters.RVListagemAdapter;
import com.example.rogermac.applesson4.modelos.Jogador;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView rvListagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
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

        List<Jogador> jogadores = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            jogadores.add(new Jogador("1", "Tafarel", "Goleiro"));
            jogadores.add(new Jogador("2", "Cafú", "Zagueiro"));
            jogadores.add(new Jogador("11", "Tafarel", "Atacante"));
            jogadores.add(new Jogador("7", "Tafarel", "Atacante"));
            jogadores.add(new Jogador("5", "Branco", "Meio campo"));
        }

        // binding
        rvListagem = findViewById(R.id.rv_listagem);

        // Criar instancia do Adapter e associar com a RecyclerView
        RVListagemAdapter adapter = new RVListagemAdapter(this, jogadores);
        rvListagem.setAdapter(adapter);

        // Definir a orgnização dos itens
        rvListagem.setLayoutManager(new LinearLayoutManager(this));
    }

}
