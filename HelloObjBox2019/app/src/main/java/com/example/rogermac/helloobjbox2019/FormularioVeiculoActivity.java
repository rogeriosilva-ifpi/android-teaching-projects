package com.example.rogermac.helloobjbox2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rogermac.helloobjbox2019.modelos.Veiculo;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class FormularioVeiculoActivity extends AppCompatActivity {

    private EditText txtVeiculoNome, txtVeiculoAno;

    private Box<Veiculo> boxVeiculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_veiculo);

        // binding
        txtVeiculoNome = findViewById(R.id.txt_veiculo_nome);
        txtVeiculoAno = findViewById(R.id.txt_veiculo_ano);

        BoxStore store = ((App)getApplication()).getBoxStore();

        boxVeiculo = store.boxFor(Veiculo.class);

    }

    public void salvarVeiculo(View view) {

        String nome = txtVeiculoNome.getText().toString();
        int ano = Integer.parseInt(txtVeiculoAno.getText().toString());

        Veiculo veiculo = new Veiculo(nome, ano);

        boxVeiculo.put(veiculo);

        Toast.makeText(this, "Veiculo Salvo!", Toast.LENGTH_SHORT).show();

        finish();

    }
}
