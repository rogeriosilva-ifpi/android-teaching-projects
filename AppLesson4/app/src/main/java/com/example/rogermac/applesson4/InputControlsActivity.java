package com.example.rogermac.applesson4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class InputControlsActivity extends AppCompatActivity {

    private enum TIPO_COMBUSTIVEL{
            GASOLINA, ALCOOL, FLEX, DIESEL
    }

    ToggleButton tgbtnAnunciante;
    TextView txtQuilometragem;
    SeekBar sbQuilometragem;
    private boolean trava, vidro, direcao, ar;
    private TIPO_COMBUSTIVEL tipoCombustivel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_controls);

        tgbtnAnunciante = findViewById(R.id.tgAnunciante);
        txtQuilometragem = findViewById(R.id.txtQuilometragem);
        sbQuilometragem = findViewById(R.id.seekBar);

        txtQuilometragem.setText("Quilometragem " + sbQuilometragem.getProgress());


        sbQuilometragem.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                txtQuilometragem.setText("Quilometragem " + sbQuilometragem.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void selecionarAnunciante(View view) {

        if (tgbtnAnunciante.isChecked()){
            Toast.makeText(this, "Anúncios de Particulares", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Anúncios Profissionais", Toast.LENGTH_SHORT).show();
        }


    }

    public void selecionarCartao(View view) {

        Switch swCartao = (Switch) view;

        if (swCartao.isChecked()){
            Toast.makeText(this, "Aceita Cartão", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Não Aceita Cartão", Toast.LENGTH_SHORT).show();
        }

    }

    public void selecionarAcessorios(View view) {

        CheckBox checkBox = (CheckBox) view;

        if (checkBox.getId() == R.id.cb_ar){
            ar = checkBox.isChecked();
        }else if (checkBox.getId() == R.id.cb_dh){
            direcao = checkBox.isChecked();
        }else if (checkBox.getId() == R.id.cb_te){
            trava = checkBox.isChecked();
        }else {
            vidro = checkBox.isChecked();
        }

        String msg = "AR: " + ar +
                " DH: " + direcao +
                " TE: " + trava +
                " VE: " + vidro;

        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void selecionarCombustivel(View view) {

        RadioButton radioButton = (RadioButton) view;

        switch (radioButton.getId()){
            case R.id.rb_gasolina:
                tipoCombustivel = TIPO_COMBUSTIVEL.GASOLINA;
                break;
            case R.id.rb_alcool:
                tipoCombustivel = TIPO_COMBUSTIVEL.ALCOOL;
                break;
            case R.id.rb_flex:
                tipoCombustivel = TIPO_COMBUSTIVEL.FLEX;
                break;
            case R.id.rb_diesel:
                tipoCombustivel = TIPO_COMBUSTIVEL.DIESEL;
                break;
        }

        String msg = "Combustível selecionado: " + tipoCombustivel;

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }
}
