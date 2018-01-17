package codes.wise.helloandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contador = 0;

    }

    public void mostrarToast(View view) {
        Toast mensagem = Toast.makeText(this, "Boa Tarde", Toast.LENGTH_LONG);
        mensagem.show();
    }

    public void aumentarNumero(View view) {

        TextView textoView = (TextView) findViewById(R.id.txt_numero);

        int numero = Integer.parseInt(textoView.getText().toString());



        contador++;

        textoView.setText(String.valueOf(contador));

    }
}











