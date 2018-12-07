package com.example.rogermac.applesson4;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    private TextView txtVasco, txtFlamengo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        txtVasco = findViewById(R.id.txt_vasco);
        txtFlamengo = findViewById(R.id.txt_flamengo);

        registerForContextMenu(txtVasco);
        registerForContextMenu(txtFlamengo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

//        if (item.getItemId() == R.id.option_configuracoes){
//            // TODO
//        }
//
//        if (item.getItemId() == R.id.option_favorito){
//            // TODO
//        }


        switch (item.getItemId()){
            case R.id.option_configuracoes:
                Toast.makeText(this, "Mostrar Configuracoes", Toast.LENGTH_SHORT).show();
                break;
            case R.id.option_favorito:
                Toast.makeText(this, "Mostrar Favoritos", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcao_resgatar_vasco:
                txtVasco.setVisibility(View.VISIBLE);
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    //    public void abrir_configuracoes(MenuItem item) {
//        Toast.makeText(this, "Mostrar Configuracoes", Toast.LENGTH_SHORT).show();
//    }
//
//    public void abrir_favoritos(MenuItem item) {
//        Toast.makeText(this, "Mostrar Favoritos", Toast.LENGTH_SHORT).show();
//    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuInflater inflater = getMenuInflater();

        if (v.getId() == R.id.txt_vasco){
            inflater.inflate(R.menu.menu_vasco, menu);
        }

        if (v.getId() == R.id.txt_flamengo){
            inflater.inflate(R.menu.menu_flamengo, menu);
        }

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.option_colorir){
            txtVasco.setTextColor(Color.RED);
        }

        if (item.getItemId() == R.id.option_apagar_time){
            txtVasco.setVisibility(View.GONE);
        }
        
        if (item.getItemId() == R.id.option_cheirinho){
            Toast.makeText(this, "Hummm...", Toast.LENGTH_SHORT).show();
        }

        return super.onContextItemSelected(item);
    }
}
