package com.example.rogermac.hellorecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rogermac.hellorecyclerview.adapters.CelularRVAdapter;
import com.example.rogermac.hellorecyclerview.modelos.Celular;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvCelulares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Binding
        rvCelulares = findViewById(R.id.rv_celulares);

        // Obtenho a lista de dados (dataset)
        List<Celular> celulares = Celular.getCelulares();

        // Crio a instancia do Adapter e associo com a RV
        CelularRVAdapter adapter = new CelularRVAdapter(this, celulares);
        rvCelulares.setAdapter(adapter);

        // Informar o Gerenciador de Layout da RV
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvCelulares.setLayoutManager(layoutManager);

    }
}
