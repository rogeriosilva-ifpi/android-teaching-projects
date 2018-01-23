package com.example.rogermac.helloobjectbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.rogermac.helloobjectbox.dal.App;
import com.example.rogermac.helloobjectbox.modelo.Celular;

import io.objectbox.Box;

public class FormularioCelularActivity extends AppCompatActivity {
    private EditText editModelo, editMarca;

    private Box<Celular> celularBox;
    private Celular celular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_celular);

        // obter Box de celulares
        celularBox = ((App) getApplication()).getBoxStore().boxFor(Celular.class);

        //iniciar a Instancia de Celular, com celular vazio
        celular = new Celular();

        //Se for edição IdCelular será diferente de -1
        Intent intent = getIntent();
        long id = intent.getLongExtra("idCelular", -1);

        //binding
        editModelo = findViewById(R.id.edit_modelo);
        editMarca = findViewById(R.id.edit_marca);

        // Se for editar, então obtem o celular do IdRecebido
        // E preenche o formulario com os valores
        if (id != -1){
            celular = celularBox.get(id);
            editModelo.setText(celular.getModelo());
            editMarca.setText(celular.getMarca());
        }


    }

    public void salvarCelular(View view) {

        // obter os valores digitados
        String modelo = editModelo.getText().toString();
        String marca = editMarca.getText().toString();

        // preenche os atributos de celular
        celular.setMarca(marca);
        celular.setModelo(modelo);

        // salva ou atualiza
        celularBox.put(celular);

        // encerra o formulario
        finish();

    }
}
