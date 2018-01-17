package com.example.rogermac.inputcontrols;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private static final String TAG = "FormCelular";
    private Celular celular;

    private EditText editMarca;
    private EditText editModelo;
    private ToggleButton btnTgProcessador;
    private Spinner spArmazenamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        celular = new Celular();

        //binding manual
        editMarca = (EditText) findViewById(R.id.edit_marca);
        editModelo = (EditText) findViewById(R.id.edit_modelo);
        btnTgProcessador = (ToggleButton) findViewById(R.id.btn_tg_processador);
        spArmazenamento = (Spinner) findViewById(R.id.sp_armazenamento_interno);

        spArmazenamento.setOnItemSelectedListener(this);
    }

    public void salvarCelularClick(View view) {
        String marca = editMarca.getText().toString();
        String modelo = editModelo.getText().toString();
        boolean marcado = btnTgProcessador.isChecked();

        //Atualizar o objeto celular
        celular.setMarca(marca);
        celular.setModelo(modelo);
        if (marcado){
            celular.setProcessador(64);
        }else {
            celular.setProcessador(32);
        }

        Log.d(TAG, "Celular: " + celular);
        //Pronto para ser enviado para outra Activity via Intent
        Intent intent = new Intent(this, MostraCelularActivity.class);
        intent.putExtra("celular", celular);
        startActivity(intent);
    }

    public void opcionaisCheckboxClick(View view) {

        CheckBox cbClicado = (CheckBox) view;
        boolean marcado = cbClicado.isChecked();

        if (cbClicado.getId() == R.id.cb_camera_frontal)
            celular.setCameraFrontal(marcado);

        if (cbClicado.getId() == R.id.cb_flash_frontal)
            celular.setFlashFrontal(marcado);

        if (cbClicado.getId() == R.id.cb_leitor_digital)
            celular.setLeitorDigital(marcado);
    }


    public void dualsimClick(View view) {

        Switch swDualsim = (Switch)view;
        boolean marcado = swDualsim.isChecked();

        celular.setDualChip(marcado);

    }

    public void memoriaRadioClick(View view) {

        RadioButton rbMemoriaClicado = (RadioButton) view;
        boolean marcado = rbMemoriaClicado.isChecked();

        if (marcado){
           celular.setMemoriaRAM(rbMemoriaClicado.getText().toString());
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        String itemSelecionado = (String) adapterView.getItemAtPosition(position);
        celular.setArmazenamentoInterno(itemSelecionado);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //Vazio.
    }
}
