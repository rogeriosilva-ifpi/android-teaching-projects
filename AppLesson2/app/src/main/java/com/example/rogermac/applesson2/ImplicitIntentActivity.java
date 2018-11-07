package com.example.rogermac.applesson2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ImplicitIntentActivity extends AppCompatActivity {

    EditText editSite;
    EditText editTelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        // binding
        editSite = findViewById(R.id.edit_site);
        editTelefone = findViewById(R.id.edit_telefone);
    }


    public void verSite(View view){
        //Obter valor da cx de texto (site)
        String site = editSite.getText().toString();

        // criar URI com valor digitado
        Uri uri = Uri.parse("http://"+site);

        // Criar e iniciar a Intent implicita do tipo Action_view
        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(it);
    }

    public void discar(View view){

        String telefone = editTelefone.getText().toString();

        Uri uri = Uri.parse("tel:"+telefone);
        Intent it = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(it);

    }
}
