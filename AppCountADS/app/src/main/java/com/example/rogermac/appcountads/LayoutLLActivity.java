package com.example.rogermac.appcountads;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LayoutLLActivity extends AppCompatActivity {

    EditText editUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_ll);

        editUsername = findViewById(R.id.edit_username);
    }

    public void irParaSignup(View view) {

        String username = editUsername.getText().toString();

        Intent intent = new Intent(this, SignupActivity.class);
        intent.putExtra("pacote", username);

        startActivity(intent);

    }
}
