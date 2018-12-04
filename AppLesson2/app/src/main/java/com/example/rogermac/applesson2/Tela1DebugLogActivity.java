package com.example.rogermac.applesson2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Tela1DebugLogActivity extends AppCompatActivity {

    public static final String TAG = "Screen1";
    public static final String ENCOMENDA = "packet";

    @BindView(R.id.edit_nome)
    protected EditText editNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1_debug_log);

        ButterKnife.bind(this);

        Log.d(TAG, "Tela Criada");
        Log.i(TAG, "Tudo Ok");
        Log.e(TAG, "VEix deu errado");

//        editNome = findViewById(R.id.edit_nome);

    }

    public void prosseguir(View view) {

        String nome = editNome.getText().toString();

        Intent intent = new Intent(this, Tela2DebugLogActivity.class);
        intent.putExtra(ENCOMENDA, nome);

        startActivity(intent);

    }
}
