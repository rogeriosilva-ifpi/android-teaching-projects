package com.example.rogermac.helloandroidx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    private TextView txtOla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        txtOla = findViewById(R.id.txt_ola);

        Intent intent = getIntent();
        String pacote = intent.getStringExtra("pacote");

        txtOla.setText(pacote);
    }
}
