package com.example.rogermac.applesson4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rogermac.applesson4.modelos.Produto;
import com.example.rogermac.applesson4.adapters.RVProdutosAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListaProdutosActivity extends AppCompatActivity {

    private RecyclerView rvProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos);

        // bind da RV
        rvProdutos = findViewById(R.id.rv_produtos);

        // criar um adapter
        RVProdutosAdapter adapter =
                new RVProdutosAdapter(this, getProdutos());

        // settar o adapter na RV
        rvProdutos.setAdapter(adapter);

        // definir a organizacao dos itens
        rvProdutos.setLayoutManager(new LinearLayoutManager(this ));

    }


    private List<Produto> getProdutos(){

        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Misto Quente"));
        produtos.add(new Produto("Suco de Camomila"));
        produtos.add(new Produto("Suco de Laranja"));
        produtos.add(new Produto("Suco de Limão"));
        produtos.add(new Produto("Misto Quente"));
        produtos.add(new Produto("Suco de Camomila"));
        produtos.add(new Produto("Suco de Laranja"));
        produtos.add(new Produto("Suco de Limão"));
        produtos.add(new Produto("Misto Quente"));
        produtos.add(new Produto("Suco de Camomila"));
        produtos.add(new Produto("Suco de Laranja"));
        produtos.add(new Produto("Suco de Limão"));

        return produtos;
    }
}
