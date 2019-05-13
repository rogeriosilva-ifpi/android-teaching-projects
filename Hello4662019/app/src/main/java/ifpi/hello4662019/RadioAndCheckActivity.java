package ifpi.hello4662019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class RadioAndCheckActivity extends AppCompatActivity {

    RadioButton rbImoveis, rbVeiculos;
    Spinner spinnerTartarugas;
    CheckBox cbAr, cbVidro, cbSom;
    LinearLayout llAcessorios;
    RatingBar ratingAvaliacao;
    String selecionado;
    boolean ar, vidro, som, dualsim, temGreve;
    String tartarugaSelecionado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_and_check);

        rbImoveis = findViewById(R.id.rb_imoveis);
        rbVeiculos = findViewById(R.id.rb_veiculos);
        cbAr = findViewById(R.id.cb_ar);
        cbVidro = findViewById(R.id.cb_vidro);
        cbSom = findViewById(R.id.cb_som);
        llAcessorios = findViewById(R.id.ll_acessorios);
        spinnerTartarugas = findViewById(R.id.spinner_tartarugas);
        ratingAvaliacao = findViewById(R.id.rating_avaliacao);
        
        // configurar o click em item do spinner
        spinnerTartarugas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                tartarugaSelecionado = (String)parent.getItemAtPosition(position);
                Toast.makeText(RadioAndCheckActivity.this, "Selecionou: " + selecionado, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        rbImoveis.setChecked(true);
        selecionado = "Imóveis";
        llAcessorios.setVisibility(View.GONE);
    }

    public void filtro(View view){

        switch (view.getId()){
            case R.id.rb_imoveis:
                selecionado = "Imóveis";
                llAcessorios.setVisibility(View.GONE);
                break;
            case R.id.rb_veiculos:
                selecionado = "Veículos";
                llAcessorios.setVisibility(View.VISIBLE);
                break;
        }

    }

    public void dualsim(View view){

        Switch swDualSim = (Switch) view;

        dualsim = swDualSim.isChecked();

    }


    public void greve(View view){
        ToggleButton toggleButton = (ToggleButton) view;
        temGreve = toggleButton.isChecked();
    }


    public void prosseguir(View view){

        float nota = ratingAvaliacao.getRating();


        Toast.makeText(this, "Selecionado: " + selecionado+
                        "\n\n AR: " + ar+
                "\n Vidro: "+vidro + "\nSom: " + som +
                "\n\nSelecionado: " + tartarugaSelecionado +
                "\nDual SIM: " + dualsim +
                "\n Tem greve?: " + temGreve +
                "\n Avaliação: " + nota,
                Toast.LENGTH_LONG).show();
    }
    
    public void selecionarAcessorio(View view){

        CheckBox checkBox = (CheckBox) view;

        if (checkBox.getId() == R.id.cb_ar){
            ar = checkBox.isChecked();
        }

        if (checkBox.getId() == R.id.cb_vidro){
            vidro = checkBox.isChecked();
        }

        if (checkBox.getId() == R.id.cb_som){
            som = checkBox.isChecked();
        }

    }
}







