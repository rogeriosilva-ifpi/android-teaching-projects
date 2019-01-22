package com.example.rogermac.perdidosrvbd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class FormularioObjetoActivity extends AppCompatActivity {
    
    EditText editNome, editData, editLocal, editTipo;
    Box<Objeto> box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_objeto);
        
        BoxStore store = ((App)getApplication()).getBoxStore();
        
        box = store.boxFor(Objeto.class);
        
        // binding
        editNome = findViewById(R.id.edit_objeto_nome);
        editLocal = findViewById(R.id.edit_objeto_local);
        editData = findViewById(R.id.edit_objeto_data);
        editTipo = findViewById(R.id.edit_objeto_tipo);
    }

    public void salvarObjeto(View view) {
        String nome = editNome.getText().toString();
        String data = editData.getText().toString();
        String local = editLocal.getText().toString();
        String tipo = editTipo.getText().toString();
        
        Objeto novo = new Objeto(nome, data, local, tipo);
        
        box.put(novo);

        Toast.makeText(this, "Novo objeto cadastrado!", Toast.LENGTH_SHORT).show();
        finish();
        
    }
}
