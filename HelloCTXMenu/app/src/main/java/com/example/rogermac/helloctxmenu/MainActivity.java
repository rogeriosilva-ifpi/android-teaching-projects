package com.example.rogermac.helloctxmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView happyTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        happyTxt = findViewById(R.id.txt_happy);

        registerForContextMenu(happyTxt);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.opcao_editar){
            happyTxt.setText("Editado...");
        }

        if (item.getItemId() == R.id.opcao_compartilhar){
            happyTxt.setText("Compartilhado...");
        }

        if (item.getItemId() == R.id.opcao_restaurar){
            happyTxt.setText("Feliz Julho 2018");
        }

        return super.onContextItemSelected(item);
    }
}
