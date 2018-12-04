package com.example.rogermac.applesson2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Tela2DebugLogActivity extends AppCompatActivity {

    private static final String TAG = "Screen2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2_debug_log);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();

        String nome = intent.getStringExtra(Tela1DebugLogActivity.ENCOMENDA);

        Log.i(TAG, "Nome recebido: " + nome);
    }
}
