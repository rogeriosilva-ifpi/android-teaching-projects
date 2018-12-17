package com.example.rogermac.appcountads;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.rogermac.appcountads.listeners.MeuEscutadorDeClick;

public class MenuActivity extends AppCompatActivity {

    private Button btnClickAqui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnClickAqui = findViewById(R.id.btn_click_aqui);

        //MeuEscutadorDeClick escutador = new MeuEscutadorDeClick();

//        btnClickAqui.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("DARSHAN", "OOOOOO");
//            }
//        });

        btnClickAqui.setOnClickListener(v -> {
            AlertDialog dialog;

            AlertDialog.Builder construtor = new AlertDialog.Builder(this);
            // Configurar as Dialogs a serem criadas
            construtor.setTitle("Bloquear");
            //construtor.setView(R.layout.dialog);
            construtor.setMessage("Deseja realmente bloqueá-lo?");
            construtor.setPositiveButton("SIM", (dialogInterface, i) -> {
                Toast.makeText(MenuActivity.this, "Bloqueado com sucesso!", Toast.LENGTH_SHORT).show();
            });
            construtor.setNegativeButton("NÃO", (dialogInterface, i) -> {
                Toast.makeText(MenuActivity.this, "Fraco!", Toast.LENGTH_SHORT).show();
            });
            construtor.setNeutralButton("AGENDAR", null);

            dialog = construtor.create();
            dialog.show();

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_principal, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.opcao_favorito:
                Toast.makeText(this, "Favorito", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcao_configuracao:
                Toast.makeText(this, "Configuracao", Toast.LENGTH_LONG).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }


}











