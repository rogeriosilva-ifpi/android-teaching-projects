package ifpi.hello4662019;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import ifpi.hello4662019.adapters.ListagemAnunciosAdapter;
import ifpi.hello4662019.modelos.Anuncio;

public class ListagemAnunciosActivity extends AppCompatActivity {

    private RecyclerView rvAnuncios;
    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_anuncios);

        rvAnuncios = findViewById(R.id.rv_anuncios);
        // obter uma instancia do firebase
        firestore = FirebaseFirestore.getInstance();
    }

    @Override
    protected void onResume() {
        super.onResume();

        obterAnunciosDoFirestore();

    }

    public void atualizar(View view){
        obterAnunciosDoFirestore();
    }

    private void atualizarRecyclerView(List<Anuncio> anuncios){
        ListagemAnunciosAdapter adapter =
                new ListagemAnunciosAdapter(anuncios, this);

        rvAnuncios.setAdapter(adapter);

        rvAnuncios.setLayoutManager(new LinearLayoutManager(this));
    }

    private void obterAnunciosDoFirestore(){

        final List<Anuncio> anuncios = new ArrayList<>();

        firestore.collection("anuncios")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (DocumentSnapshot documento:task.getResult()) {
                                Anuncio anuncio = documento.toObject(Anuncio.class);
                                anuncios.add(anuncio);
                            }
                            // Terminou de pegar todos os documentos(anuncios)
                            atualizarRecyclerView(anuncios);
                        }
                    }
                });
    }
}








