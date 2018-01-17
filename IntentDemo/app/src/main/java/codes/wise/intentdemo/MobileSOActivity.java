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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import codes.wise.intentdemo.adapter.VeiculoArrayListAdapter;
import codes.wise.intentdemo.model.Sistema;

public class MobileSOActivity extends AppCompatActivity {

    private Sistema so_selecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_so);

        //Lista de dados a ser enviado para a ListView
        final List<Sistema> sistemas = new ArrayList<>();
        Sistema droid = new Sistema("Android", 7, "Google");
        sistemas.add(droid);
        sistemas.add(new Sistema("iOS", 10, "Apple"));
        sistemas.add(new Sistema("Windows", 10, "MS"));
        sistemas.add(new Sistema("Ubuntu", 2016, "UF"));

        //Criandoo Adapter para conectar os dados à ListView
        ArrayAdapter<Sistema> adapter1 =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sistemas);

        //Associando o Adapter à ListView
        final ListView listSO = (ListView) findViewById(R.id.listSO);
        listSO.setAdapter(adapter1);

        //Registrar Listener(escutador) de click.
        listSO.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                Sistema so = sistemas.get(pos);
                Toast.makeText(MobileSOActivity.this, "Clicou: " + so.getNome(), Toast.LENGTH_LONG).show();
            }
        });

        //Registrar Listener para click longo.
        listSO.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pos, long l) {
                so_selecionado = (Sistema) adapterView.getItemAtPosition(pos);
                //Snackbar.make(listSO, "Clicou long em " + so.getNome(), Snackbar.LENGTH_LONG).show();
                return false; //true fica sendo o dono do click.
            }
        });

        //Registrar para Menu de Contexto
        registerForContextMenu(listSO);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        final MenuItem historio = menu.add("Histório");
        final MenuItem fabricante = menu.add("Fabricante");
        final MenuItem preco = menu.add("Preço");
        final MenuItem detalhes = menu.add("Outros detalhes");

        historio.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Toast.makeText(MobileSOActivity.this, "Histórico do SO..." + so_selecionado.getNome(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        fabricante.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                String nomeFabricante = so_selecionado.getFabricante();
                Toast.makeText(MobileSOActivity.this, "Fabricado por " + nomeFabricante, Toast.LENGTH_LONG).show();
                return false;
            }
        });


        super.onCreateContextMenu(menu, v, menuInfo);
    }
}









