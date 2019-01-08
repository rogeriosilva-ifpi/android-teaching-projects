package com.example.rogermac.perdidosrvbd;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class ListaObjetosActivity extends AppCompatActivity {

    RecyclerView rvObjetos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_objetos);

        // binding
        rvObjetos = findViewById(R.id.rv_objetos);

        // Produtos FAKE
        BoxStore store = MyObjectBox.builder().androidContext(getApplication()).build();

        Box<Objeto> boxObjetos = store.boxFor(Objeto.class);

        // Criar o Adapter
        RVObjetosAdapter adapter =
                new RVObjetosAdapter(this, boxObjetos.getAll());

        // associar o adpatar a RV
        rvObjetos.setAdapter(adapter);

        // Definir a organizacao
        rvObjetos.setLayoutManager(new LinearLayoutManager(this));
    }
}
