package com.example.rogermac.helloobjbox2019;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.rogermac.helloobjbox2019.modelos.Montadora;
import com.example.rogermac.helloobjbox2019.modelos.Veiculo;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import static com.example.rogermac.helloobjbox2019.ListagemVeiculoActivity.*;

public class FormularioVeiculoActivity extends AppCompatActivity {

    private EditText editVeiculoNome, editVeiculoAno;
    private Spinner spMontadora;

    private Box<Veiculo> boxVeiculo;
    private Box<Montadora> boxMontadora;
    BoxStore store;

    Montadora montadoraSelecionada;
    Veiculo veiculo;
    Intent intent;
    ACTION_TYPE actionType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_veiculo);

        store = ((App)getApplication()).getBoxStore();

        boxVeiculo = store.boxFor(Veiculo.class);
        boxMontadora = store.boxFor(Montadora.class);

        //povoarMontadora();

        intent = getIntent();
        actionType = (ACTION_TYPE) intent.getExtras().get(ACTION);

        setupUi();


    }

    private void setupUi() {

        // binding
        editVeiculoNome = findViewById(R.id.txt_veiculo_nome);
        editVeiculoAno = findViewById(R.id.txt_veiculo_ano);
        spMontadora = findViewById(R.id.sp_montadoras);

        final List<Montadora> montadoras = boxMontadora.getAll();

        final ArrayAdapter<Montadora> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, montadoras);

        spMontadora.setAdapter(adapter);

        // configurar o click no Spinner
        spMontadora.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                montadoraSelecionada = (Montadora) adapterView.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        // Check if is NOVO or EDICAO
        switch (actionType){
            case NOVO:
                // TODO
                getSupportActionBar().setTitle("Novo Veículo");
                break;
            case EDITAR:
                // TODO: Preencher formulário
                getSupportActionBar().setTitle("Editando Veiculo");
                veiculo = boxVeiculo.get(intent.getLongExtra("veiculo_id", -1));
                editVeiculoNome.setText(veiculo.getNome());
                editVeiculoAno.setText(""+ veiculo.getAno());
                // Selecionar montadora
                spMontadora.setSelection(adapter.getPosition(veiculo.getMontadora().getTarget()));

                break;
            default:
                Toast.makeText(this, "Operacao inválida!", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }


    }

    public void salvarVeiculo(View view) {

        String nome = editVeiculoNome.getText().toString();
        int ano = Integer.parseInt(editVeiculoAno.getText().toString());

        if (actionType == ACTION_TYPE.NOVO)
            veiculo = new Veiculo(nome, ano);
        else{
            veiculo.setNome(nome);
            veiculo.setAno(ano);
        }
        veiculo.getMontadora().setTarget(montadoraSelecionada);

        boxVeiculo.put(veiculo);

        Toast.makeText(this, "Veiculo Salvo!", Toast.LENGTH_SHORT).show();

        finish();

    }

    private void povoarMontadora() {

        String[] montadoras = {"Fiat", "Honda", "Ford", "Toyota", "GM", "Hyundai", "WV"};

        for (String nome: montadoras) {
            boxMontadora.put(new Montadora(nome));
        }

    }


}
