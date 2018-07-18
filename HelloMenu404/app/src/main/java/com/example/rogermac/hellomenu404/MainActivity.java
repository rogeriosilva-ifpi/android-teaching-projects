package com.example.rogermac.hellomenu404;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.opcao_salvar:
                Toast.makeText(this, "Salvando...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcao_favorito:
                Toast.makeText(this, "Favoritando..", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcao_configuracao:
                Toast.makeText(this, "Configuracoes", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcao_toast:
                Toast.makeText(this, "Mensagem", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
