package ifpi.hello4662019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class CicloVida2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_vida2);
        Log.d("ERICK 2", "CREATE");
    }

    // ### CICLO DE VIDA CALLBACKS METHODS ###

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ERICK 2", "START");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ERICK 2", "RESTART");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ERICK 2", "RESUME");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ERICK 2", "PAUSE");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ERICK 2", "STOP");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ERICK 2", "DESTROY");
    }

    public void finalizar(View view) {
        finish();
    }
}
