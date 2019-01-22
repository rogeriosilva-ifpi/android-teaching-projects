package com.example.rogermac.perdidosrvbd;

import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class ListaObjetosActivity extends AppCompatActivity {

    RecyclerView rvObjetos;
    Box<Objeto> boxObjetos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_objetos);

        // binding
        rvObjetos = findViewById(R.id.rv_objetos);



    }

    @Override
    protected void onResume() {
        super.onResume();

        recarregarDados();

    }

    public void recarregarDados(){
        // Produtos FAKE
        //BoxStore store = MyObjectBox.builder().androidContext(getApplication()).build();

        BoxStore store  = ((App)getApplication()).getBoxStore();

        boxObjetos = store.boxFor(Objeto.class);

        // Criar o Adapter
        RVObjetosAdapter adapter =
                new RVObjetosAdapter(this, boxObjetos.getAll());

        // associar o adpatar a RV
        rvObjetos.setAdapter(adapter);

        // Definir a organizacao
        rvObjetos.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_objetos, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.item_novo_objeto){
            Intent intent = new Intent(this, FormularioObjetoActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
