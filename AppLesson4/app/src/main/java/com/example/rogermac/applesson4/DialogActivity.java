package com.example.rogermac.applesson4;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {

    private Button btnAlertDialog;
    private TextView txtNomeDigitado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        btnAlertDialog = findViewById(R.id.btn_alertDialog);
        txtNomeDigitado = findViewById(R.id.txt_nome_digitado);

        btnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Construtor de AlertDialog
                AlertDialog.Builder builder =
                        new AlertDialog.Builder(DialogActivity.this);

                // configuracoes
                builder.setTitle("AppLesson R1");
                builder.setMessage("Olá eu sou uma Dialog!");

                // configurar botao POSITIVO
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DialogActivity.this, "Clicou em OK", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DialogActivity.this, "Clicou em CANCELAR", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNeutralButton("NADA", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DialogActivity.this, "Clicou em NADA.", Toast.LENGTH_SHORT).show();
                    }
                });


                builder.create().show();

//                // Efetivamente construir uma AlertDialog
//                AlertDialog dialog = builder.create();
//
//                // exibir a AlertDialog criada.
//                dialog.show();

            }
        });

    }

    public void obterNome(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final View viewDialog = getLayoutInflater().inflate(R.layout.dialog_novo_nome, null);

        builder.setView(viewDialog);
        builder.setTitle("Digite seu nome");
        //builder.setMessage("Aqui terá um Layout customizado.");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                EditText editNome = viewDialog.findViewById(R.id.edit_nome);
                String nome = editNome.getText().toString();
                txtNomeDigitado.setText(nome);
            }
        });


        builder.setNegativeButton("CANCELAR", null);

        builder.create().show();

    }
}









