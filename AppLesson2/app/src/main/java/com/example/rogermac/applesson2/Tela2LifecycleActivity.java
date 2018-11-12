package com.example.rogermac.applesson2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Tela2LifecycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2_lifecycle);

        Log.i("LIFE1", "onCreate");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LIFE1", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("LIFE1", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LIFE1", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LIFE1", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LIFE1", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LIFE1", "onDestroy");
    }

    public void abrirTela2(View view) {
        final Intent intent = new Intent(this, Tela3LifecycleActivity.class);
        intent.putExtra("lanche", "banana+ovo");
        startActivity(intent);
    }
}
