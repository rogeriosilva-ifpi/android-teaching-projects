package codes.wise.intentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int REQ_CODE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void chamarTela2(View view) {

        EditText caixa = (EditText)findViewById(R.id.caixa);
        String texto = caixa.getText().toString();

        Intent intent = new Intent(this, SegundaActivity.class);
        intent.putExtra("pacote", texto);
        //startActivity(intent);

        startActivityForResult(intent, 17);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 17){
            if (resultCode == RESULT_OK){
                String retorno = data.getStringExtra("retorno");
                TextView txtRetorno = (TextView) findViewById(R.id.labelResultado);
                txtRetorno.setText(retorno);
            }
        }
    }
}
