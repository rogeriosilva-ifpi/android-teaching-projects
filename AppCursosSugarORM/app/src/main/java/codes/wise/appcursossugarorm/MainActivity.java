package codes.wise.appcursossugarorm;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;
import java.util.jar.Manifest;

import codes.wise.appcursossugarorm.modelos.Curso;

public class MainActivity extends AppCompatActivity {

    private ListView lvCursos;

    private Curso cursoSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Binding
        lvCursos = (ListView) findViewById(R.id.lv_cursos);

        //Click longo na lista.
        lvCursos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pos, long l) {

                cursoSelecionado = (Curso) adapterView.getItemAtPosition(pos);

                return false;
            }
        });

        //Register for ContextMenu
        registerForContextMenu(lvCursos);

    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarCursos();
    }

    private void carregarCursos(){
        //Pegar todos os curso via SugarORM
        List<Curso> cursos = Curso.listAll(Curso.class);


        //Criar e associar o Adapter com os dados.
        ArrayAdapter<Curso> adapter = new ArrayAdapter<Curso>(this, android.R.layout.simple_list_item_1, cursos);
        lvCursos.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_actionbar, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.item_novo_curso:
                Intent intent = new Intent(this, FormularioActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem remover = menu.add("Remover");

        remover.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("Cursos...")
                        .setMessage("Desejar mesmo remover " + cursoSelecionado.getNome() + "? ")
                        .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                cursoSelecionado.delete();
                                carregarCursos();
                                Toast.makeText(MainActivity.this, "Removido.", Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("NÃO", null)
                        .show();

                return false;
            }
        });
    }
}
