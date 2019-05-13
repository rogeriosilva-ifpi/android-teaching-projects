package ifpi.hello4662019;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class CicloVida1Activity extends AppCompatActivity {

    EditText editNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_vida1);

        editNome = findViewById(R.id.edit_nome);

        Log.d("ERICK", "CREATE");
    }

    // ### INSTANCE STATE

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d("ERICK", "SAVE");

        outState.putString("nome_digitado", editNome.getText().toString());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("ERICK", "RESTORE");

        if (savedInstanceState != null){
            String nomeSalvo = savedInstanceState.getString("nome_digitado");

            if (nomeSalvo != null){
                editNome.setText(nomeSalvo);
            }

        }

    }

    // ### CICLO DE VIDA CALLBACKS METHODS ###

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ERICK", "START");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ERICK", "RESTART");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ERICK", "RESUME");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ERICK", "PAUSE");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ERICK", "STOP");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ERICK", "DESTROY");
    }

    public void finalizar(View view) {
        finish();
    }

    public void tela2(View view) {
        Intent intent = new Intent(this, CicloVida2Activity.class);
        startActivity(intent);
    }
}
