package com.example.rogermac.hellomenux;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.rogermac.hellomenux.modelos.Celular;

import java.util.ArrayList;
import java.util.List;

public class ListagemActivity extends AppCompatActivity {

    List<Celular> celulares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem);
    }

    @Override
    protected void onResume() {
        super.onResume();
        celulares = getListaCelulares();
    }

    private List<Celular> getListaCelulares(){

        List<Celular> dados = new ArrayList<>();
        dados.add(new Celular("Moto G4", "Lenovo"));
        dados.add(new Celular("Moto G5", "Lenovo"));
        dados.add(new Celular("Moto G6", "Lenovo"));
        dados.add(new Celular("Moto G7", "Lenovo"));
        dados.add(new Celular("K10", "LG"));
        dados.add(new Celular("K11", "LG"));
        dados.add(new Celular("J7", "Samsung"));

        return dados;
    }
}
