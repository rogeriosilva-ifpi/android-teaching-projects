package com.example.rogermac.helloobjbox2019;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
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
import com.example.rogermac.helloobjbox2019.databinding.ActivityFormularioVeiculoBinding;

import com.example.rogermac.helloobjbox2019.modelos.Montadora;
import com.example.rogermac.helloobjbox2019.modelos.Veiculo;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import static com.example.rogermac.helloobjbox2019.ListagemVeiculoActivity.*;

public class FormularioVeiculoActivity extends AppCompatActivity {

    private Spinner spMontadora;

    private Box<Veiculo> boxVeiculo;
    private Box<Montadora> boxMontadora;
    BoxStore store;

    ACTION_TYPE actionType;
    ActivityFormularioVeiculoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_formulario_veiculo);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_formulario_veiculo);

        store = ((App)getApplication()).getBoxStore();

        boxVeiculo = store.boxFor(Veiculo.class);
        boxMontadora = store.boxFor(Montadora.class);

        //povoarMontadora();

        actionType = (ACTION_TYPE) getIntent().getExtras().get(ACTION);

        setupUi();

    }

    private void setupUi() {

        // binding
        spMontadora = findViewById(R.id.sp_montadoras);

        final List<Montadora> montadoras = boxMontadora.getAll();

        final ArrayAdapter<Montadora> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, montadoras);

        spMontadora.setAdapter(adapter);

        // configurar o click no Spinner
        spMontadora.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Montadora montadoraSelecionada = (Montadora) adapterView.getItemAtPosition(position);
                binding.getVeiculo().setMontadora(montadoraSelecionada);
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
                binding.setVeiculo(new Veiculo());
                break;
            case EDITAR:
                // TODO: Preencher formulário
                getSupportActionBar().setTitle("Editando Veiculo");
                binding.setVeiculo(boxVeiculo.get(getIntent().getLongExtra("veiculo_id", -1)));

                // Selecionar montadora
                spMontadora.setSelection(adapter.getPosition(binding.getVeiculo().getMontadora().getTarget()));

                break;
            default:
                Toast.makeText(this, "Operacao inválida!", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }

    }

    public void salvarVeiculo(View view) {

        boxVeiculo.put(binding.getVeiculo());
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
