package ifpi.hello4662019;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ContadorActivity extends AppCompatActivity {

    private TextView txtNumero;
    private EditText editIncremento;
    private int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador);

        txtNumero = findViewById(R.id.txt_numero);
        editIncremento = findViewById(R.id.edit_incremento);

        contador = 0;
        editIncremento.setText("1");

        atualizeATela();

    }

    public void exibirToast(View view) {
        Toast.makeText(this, "Valor atual --> " + contador, Toast.LENGTH_SHORT).show();
    }

    public void aumentarContador(View view) {

        int incremento = Integer.parseInt(editIncremento.getText().toString());

        contador += incremento;
        atualizeATela();
    }

    public void atualizeATela(){
        txtNumero.setText(""+contador);

        if (contador % 2 == 0){
            txtNumero.setBackgroundColor(Color.rgb(80, 180, 0 ));
        }else {
            txtNumero.setBackgroundColor(Color.rgb(255,255,0));
        }
    }
}
