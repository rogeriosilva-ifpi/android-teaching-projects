package com.example.rogermac.hellopopupmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cliquePerfil(View view) {
        // criar um popup
        PopupMenu popup = new PopupMenu(this, view);

        // inflar as opcoes
        popup.getMenuInflater()
                .inflate(R.menu.perfil_popup, popup.getMenu());

        // configurar click nos itens
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                
                if (menuItem.getItemId() == R.id.pop_view){
                    Toast.makeText(MainActivity.this, "Visualizar", Toast.LENGTH_SHORT).show();
                }else if (menuItem.getItemId() == R.id.pop_edit){
                    Toast.makeText(MainActivity.this, "Editar", Toast.LENGTH_SHORT).show();
                }
                
                return false;
            }
            
        });

        // exibir o popup
        popup.show();
    }
}
