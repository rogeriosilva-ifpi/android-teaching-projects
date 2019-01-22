package com.example.rogermac.helloobjbox2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.rogermac.helloobjbox2019.adapters.RVVeiculosAdapter;
import com.example.rogermac.helloobjbox2019.modelos.Veiculo;

import io.objectbox.Box;

public class ListagemVeiculoActivity extends AppCompatActivity {

    Box<Veiculo> boxVeiculo;
    RecyclerView rvVeiculos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_veiculo);

        boxVeiculo = ((App)getApplication()).getBoxStore().boxFor(Veiculo.class);


    }

    @Override
    protected void onResume() {
        super.onResume();

        carregarVeiculos();

    }

    private void carregarVeiculos() {
        rvVeiculos = findViewById(R.id.rv_veiculos);

        RVVeiculosAdapter adapter = new RVVeiculosAdapter(boxVeiculo, this);

        rvVeiculos.setAdapter(adapter);

        rvVeiculos.setLayoutManager(new LinearLayoutManager(this));
    }

    public void novoVeiculo(View view) {

        final Intent intent = new Intent(this, FormularioVeiculoActivity.class);
        startActivity(intent);

    }

}
