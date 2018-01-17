package codes.wise.intent4result;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SegundaActivity extends AppCompatActivity {

    public final String TAG = "MARIA_IFPI";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        Log.d(TAG, "onCreate");

        EditText edit2 = (EditText)findViewById(R.id.edit2);
        edit2.requestFocus();

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
        Log.d(TAG, "SaveInstance");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "RestoreInstance");
    }

    public void voltarTela1(View view) {

        View v = this.getCurrentFocus();
        Log.d(TAG, ""+v.getId());

        // passo 1: criar intent de Resultado
        Intent itResultado = new Intent();
        // passo 2: incluir Extras de retorno
        itResultado.putExtra("msg", "Feliz Natal!");
        // passo 3: sinalizar OK o CANCELED
        setResult(RESULT_OK, itResultado);
        // passo 4: Encerrar esta activity
        finish();
    }
}
