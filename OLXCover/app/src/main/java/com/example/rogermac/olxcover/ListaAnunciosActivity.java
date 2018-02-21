package com.example.rogermac.olxcover;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.query.Query;
import io.objectbox.query.QueryBuilder;

public class ListaAnunciosActivity extends AppCompatActivity {

    private RecyclerView rvAnuncios;
    private Box<Anuncio> anuncioBox;
    private Box<Usuario> usuarioBox;
    private AnunciosRVAdapter adapter;
    SharedPreferences preferences;
    private Usuario usuarioLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_anuncios);

        BoxStore store = ((App)getApplication()).getBoxStore();
        anuncioBox = store.boxFor(Anuncio.class);
        usuarioBox = store.boxFor(Usuario.class);

        usuarioLogado = obterUsuarioLogado();

        setupViews();
        handlerIntent(getIntent());
        //reloadData(anuncioBox.getAll());

        if (!logado()){
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        QueryBuilder<Anuncio> builder = anuncioBox.query();
        builder.equal(Anuncio_.donoId, usuarioLogado.getId());

        List<Anuncio> anunciosDoUsuario = builder.build().find();

        reloadData(anunciosDoUsuario);
    }

    private boolean logado() {
        preferences = getSharedPreferences("olxcover.file", MODE_PRIVATE);
        long usuarioId = preferences.getLong("usuarioId", -1);
        return usuarioId == -1 ? false : true;
    }

    private void reloadData(List<Anuncio> data){
        List<Anuncio> anuncios = data;
        adapter = new AnunciosRVAdapter(anuncios, this, anuncioBox);

        rvAnuncios.setAdapter(adapter);
        rvAnuncios.setLayoutManager(new LinearLayoutManager(this));
        rvAnuncios.setHasFixedSize(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_actionbar, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        menu.findItem(R.id.search).setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem menuItem) {
                Toast.makeText(ListaAnunciosActivity.this, "1", Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                Toast.makeText(ListaAnunciosActivity.this, "2", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        searchView.setOnCloseListener(() -> {
            Toast.makeText(this, "fechou", Toast.LENGTH_SHORT).show();
            adapter.setAnuncios(anuncioBox.getAll());
            adapter.notifyDataSetChanged();
            return true;
        });


        return true;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handlerIntent(intent);
    }

    private void handlerIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())){
            String query = intent.getStringExtra(SearchManager.QUERY);

            final QueryBuilder<Anuncio> queryBuilder = anuncioBox.query();
            queryBuilder.contains(Anuncio_.titulo, query);

            Query<Anuncio> queryAnuncio = queryBuilder.build();
            List<Anuncio> anuncios = queryAnuncio.find();

            adapter.setAnuncios(anuncios);
            adapter.notifyDataSetChanged();

            Toast.makeText(this, "Resultados: " + anuncios.size(), Toast.LENGTH_SHORT).show();
        }

    }

    private void setupViews(){
        rvAnuncios = findViewById(R.id.rv_anuncios);
    }

    public void novoAnuncio(View view) {
        startActivity(new Intent(this, FormularioAnuncioActivity.class));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.item_sair){
            logout();
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        preferences.edit().clear();
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    private Usuario obterUsuarioLogado() {
        final SharedPreferences preferences = getSharedPreferences("olxcover.file", MODE_PRIVATE);
        final long id = preferences.getLong("usuarioId", -1);
        return usuarioBox.get(id);
    }
}
