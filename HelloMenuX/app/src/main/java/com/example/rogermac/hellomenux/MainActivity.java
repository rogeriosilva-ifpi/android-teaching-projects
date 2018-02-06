package com.example.rogermac.hellomenux;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId() == R.id.btn_eu_quero){
            getMenuInflater().inflate(R.menu.contextual_menu, menu);
        }else {
            getMenuInflater().inflate(R.menu.contextual_menu2, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.item_ctx_editar){
            Toast.makeText(this, R.string.editar, Toast.LENGTH_SHORT).show();
        }

        return super.onContextItemSelected(item);
    }

    private void setupViews(){

        Button btnEuQuero = findViewById(R.id.btn_eu_quero);
        Button btnNaoEuQuero = findViewById(R.id.btn_nao_eu_quero);
        registerForContextMenu(btnEuQuero);
        registerForContextMenu(btnNaoEuQuero);

    }


    public void querSurpresa(View view) {
        final PopupMenu popup = new PopupMenu(this, view);

        popup.getMenuInflater().inflate(R.menu.popup, popup.getMenu());

        popup.setOnMenuItemClickListener((item) -> {
                if (item.getItemId() == R.id.popup_pop){
                    Toast.makeText(this, "Pop 110", Toast.LENGTH_SHORT).show();
                }
            return false;
        });

        popup.show();
    }

    public void listagem(View view) {
        startActivity(new Intent(this, ListagemActivity.class));
    }
}









