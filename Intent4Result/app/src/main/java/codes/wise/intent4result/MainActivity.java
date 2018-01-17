package codes.wise.intent4result;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public final int REQUEST_CODE = 100;
    public final String TAG = "ROGERIO_IFPI";
    String nome;

    private EditText editNome;
    private TextView txtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "OnCreate");

        //Binding
        editNome = (EditText) findViewById(R.id.editNome);
        txtNome = (TextView) findViewById(R.id.txtNome);

        // Verificando se ha estado salvo (Bundle)
        if (savedInstanceState != null){
            Log.d(TAG, "Estado recebido.");
            String encomenda = savedInstanceState.getString("pacote");

            if (encomenda != null){
                Log.d(TAG, "Pacote: "+encomenda);
                nome = encomenda;
                txtNome.setText("Boa tarde "+nome);
            }else{
                Log.d(TAG, "Pacote não recebido");
            }
        }else {
            Log.d(TAG, "Estado não recebido");
            Log.d(TAG, "Tentar pegar nas Preferencias");

            // Pegar Objeto Preferencias
            SharedPreferences prefs = getPreferences(MODE_PRIVATE);

            // Pegar dados nas PReferencias
            String encomendaPref = prefs.getString("pacote", "");
            nome = encomendaPref;
            if (!encomendaPref.equals("")){
                txtNome.setText("Boa tarde "+encomendaPref);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
        //Salvar o nome das Preferencias
        //1. Obter o objeto de preferencias
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        //2. Como é escrita, precisa-se do Editor
        SharedPreferences.Editor editor = prefs.edit();

        //3. Escrever os dados que deseja guardar p/ a etern.
        editor.putString("pacote", nome);

        //4. Confirmar as alteracoes
        editor.commit();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //Ao perceber que a Activity serah destruida, ele salva
        // o estado(outState). Voce podera incluir dados nele.
        Log.d(TAG, "SaveInstance");

        //Incluindo coisas no Estado a ser salvo
        outState.putString("pacote", nome);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Uma das formas de obter o um estado previamente salvo
        Log.d(TAG, "RestoreInstance");
    }

    public void abrirTela2(View view) {
        Intent itTela2 = new Intent(this, SegundaActivity.class);
        startActivityForResult(itTela2, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_CODE){
            if (resultCode == RESULT_OK){
                // Deu certo
                String mensagem = data.getStringExtra("msg");
                Toast toast = Toast.makeText(this, mensagem, Toast.LENGTH_LONG);
                toast.show();
            }else {
                // Deu errado
            }
        }
    }

    public void clickSaudacao(View view) {

        nome = editNome.getText().toString();
        editNome.getText().clear();

        txtNome.setText("Boa tarde "+nome);

    }
}








