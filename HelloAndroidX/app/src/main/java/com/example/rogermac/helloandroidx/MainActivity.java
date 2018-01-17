package com.example.rogermac.helloandroidx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editNome;
    private TextView txtSaudacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //binding
        editNome = findViewById(R.id.txt_nome);
        txtSaudacao = findViewById(R.id.tv_saudacao);
    }

    public void enviar(View view) {


        String nome = editNome.getText().toString();
        if(nome.trim().equals("")){
            Toast.makeText(this,
                    "Digite um nome",
                    Toast.LENGTH_SHORT).show();
        }else {
            String mensagem = "Ola " + nome;

            if (nome.equalsIgnoreCase("ANTONIO")){
                Intent intent = new Intent(this, SegundaActivity.class);
                intent.putExtra("pacote", mensagem);
                startActivity(intent);
            }else {
                txtSaudacao.setText(mensagem);
            }

        }
    }
}
