package ifpi.hello4662019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class IMCActivity extends AppCompatActivity {

    EditText editAltura, editPeso;
    TextView textResultado;
    Button btnIMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        // Bind: conectar às views do layout
        editAltura = findViewById(R.id.edit_altura);
        editPeso = findViewById(R.id.edit_peso);
        textResultado = findViewById(R.id.txt_resultado);
        btnIMC = findViewById(R.id.btn_imc);
    }

    public void calcularIMC(View view) {

        if (btnIMC.getText().toString().equalsIgnoreCase("LIMPAR DADOS")){
            textResultado.setVisibility(View.INVISIBLE);
            editAltura.getText().clear();
            editPeso.getText().clear();
            editAltura.requestFocus();

            btnIMC.setText("CALCULAR MEU IMC");
        }else{

            if ((editAltura.getText().toString().equalsIgnoreCase("")) ||
                    (editPeso.getText().toString().equalsIgnoreCase(""))){
                Toast.makeText(this, "Digite Peso e Altura", Toast.LENGTH_SHORT).show();
                return;
            }

            double altura = Double.parseDouble(editAltura.getText().toString());
            double peso = Double.parseDouble(editPeso.getText().toString());

            double imc = peso / (altura * altura);

            String classificacao = "";

            if (imc < 18){
                classificacao = "ABAIXO DO PESO";
            }else if(imc > 30){
                classificacao = "OBESIDADE";
            }else {
                classificacao = "NORMAL";
            }

            String resultado = "Altura: %.2f\nPeso: %.1f\nIMC: %.1f\nSIT.: " + classificacao;

            resultado = String.format(resultado, altura, peso, imc);

            textResultado.setText(resultado);
            textResultado.setVisibility(View.VISIBLE);
            btnIMC.setText("LIMPAR DADOS");
        }



    }

    public void abrirContador(View view) {

        Intent intent = new Intent(this, ContadorActivity.class);
        startActivity(intent);

    }
}






