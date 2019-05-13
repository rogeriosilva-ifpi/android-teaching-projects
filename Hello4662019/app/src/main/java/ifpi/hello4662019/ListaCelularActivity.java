package ifpi.hello4662019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import ifpi.hello4662019.adapters.CelularAdapter;
import ifpi.hello4662019.modelos.Celular;

public class ListaCelularActivity extends AppCompatActivity {

    RecyclerView rvCelulares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_celular);

        rvCelulares = findViewById(R.id.rv_celulares);
    }

    @Override
    protected void onResume() {
        super.onResume();
        obterCelulares();
    }

    private void obterCelulares() {
        List<Celular> celulars = Celular.getCelulares();

        CelularAdapter adapter = new CelularAdapter(celulars, this);
        rvCelulares.setAdapter(adapter);

        rvCelulares.setLayoutManager(new LinearLayoutManager(this));


    }
}
