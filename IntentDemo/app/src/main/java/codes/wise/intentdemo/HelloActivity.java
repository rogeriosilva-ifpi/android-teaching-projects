package codes.wise.intentdemo;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import codes.wise.intentdemo.adapter.VeiculoArrayListAdapter;
import codes.wise.intentdemo.model.Veiculo;

public class HelloActivity extends AppCompatActivity {

    private ListView mLstCarros;
    private Veiculo veiculoSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        mLstCarros = (ListView) findViewById(R.id.lstCarros);

        //Usando ArrayAdapter com simple..
        final List<String> carros = new ArrayList<>();
        carros.add("Celta");
        carros.add("Marea");
        carros.add("Parati");

//        final ArrayAdapter<String> adapter =
//                new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, carros);
//        mLstCarros.setAdapter(adapter);

        //Definindo acao ao clicar no item da lista.
        mLstCarros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //Snackbar.make(mLstCarros, "Item: " + carros.get(i), Snackbar.LENGTH_LONG).show();
                veiculoSelecionado = (Veiculo) adapterView.getItemAtPosition(position);
                Snackbar.make(mLstCarros, "Item: " + veiculoSelecionado.getNome(), Snackbar.LENGTH_LONG).show();
            }
        });

        mLstCarros.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                veiculoSelecionado = (Veiculo) adapterView.getItemAtPosition(position);
                return false;
            }
        });

        //Custom adaptar
        final List<Veiculo> veiculos = new ArrayList<>();
        for(int i = 0; i < 1000; i++){
            veiculos.add(new Veiculo("Hilux", "Toyota", "R$ 165.000"));
            veiculos.add(new Veiculo("S10", "GM ", "R$ 125.000"));
            veiculos.add(new Veiculo("Amarok", "VW", "R$ 185.000"));
            veiculos.add(new Veiculo("Amarok II", "VW", "R$ 285.000"));
        }

        VeiculoArrayListAdapter adapter1 =
                new VeiculoArrayListAdapter(this, R.layout.item_lista, veiculos);

        mLstCarros.setAdapter(adapter1);

        //Habilitar a ListView(Carros) para Menu De Contexto
        registerForContextMenu(mLstCarros);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //Adicionar item no menu de contexto
        MenuItem detalhes = menu.add("Ver detalhes");

        detalhes.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Snackbar.make(mLstCarros, "Mais detalhes de " + veiculoSelecionado.getNome(), Snackbar.LENGTH_LONG).show();
                return false;
            }
        });

        super.onCreateContextMenu(menu, v, menuInfo);
    }
}
