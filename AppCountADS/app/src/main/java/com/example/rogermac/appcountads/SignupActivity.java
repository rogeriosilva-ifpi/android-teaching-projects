package com.example.rogermac.appcountads;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Intent intent = getIntent();

        String pacote = intent.getStringExtra("pacote");

        ((EditText)findViewById(R.id.edit_username)).setText(pacote);

    }
}
