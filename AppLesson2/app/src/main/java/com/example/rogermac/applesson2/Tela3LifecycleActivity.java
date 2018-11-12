package com.example.rogermac.applesson2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Tela3LifecycleActivity extends AppCompatActivity {

    TextView txtLanche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3_lifecycle);
        Log.i("LIFE2", "onCreate");

        txtLanche = findViewById(R.id.txt_lanche);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LIFE2", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("LIFE2", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LIFE2", "onResume");

        final Intent intent = getIntent();
        String lanche = intent.getStringExtra("lanche");

        txtLanche.setText(lanche);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LIFE2", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LIFE2", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LIFE2", "onDestroy");
    }
}
