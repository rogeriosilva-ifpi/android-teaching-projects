package com.example.rogermac.helloobjectbox.modelo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.rogermac.helloobjectbox.MainActivity;
import com.example.rogermac.helloobjectbox.R;
import com.example.rogermac.helloobjectbox.adapters.CelularRVAdapter;
import com.example.rogermac.helloobjectbox.dal.App;

import java.util.List;

import io.objectbox.Box;

public class SegundaActivity extends AppCompatActivity {

    Box<Celular> celularBox;
    RecyclerView rvCelulares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        celularBox = ((App) getApplication()).getBoxStore().boxFor(Celular.class);

        //binding
        rvCelulares = findViewById(R.id.rv_celulares);

    }

    @Override
    protected void onResume() {
        super.onResume();

        List<Celular> celulares = celularBox.getAll();
        CelularRVAdapter adapter = new CelularRVAdapter(this, celulares);

        rvCelulares.setAdapter(adapter);
        rvCelulares.setLayoutManager(new LinearLayoutManager(this));
        rvCelulares.hasFixedSize();
    }

    public void novoCelular(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}
