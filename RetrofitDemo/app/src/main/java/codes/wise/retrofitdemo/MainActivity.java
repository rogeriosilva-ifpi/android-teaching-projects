package codes.wise.retrofitdemo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import codes.wise.retrofitdemo.infra.APIService;
import codes.wise.retrofitdemo.infra.Retrofitable;
import codes.wise.retrofitdemo.models.Disciplina;

public class MainActivity extends AppCompatActivity implements Retrofitable{

    @BindView(R.id.lv_disciplinas)
    protected ListView lvDisciplina;

    @BindView(R.id.tv_status)
    protected TextView tvStatus;

    private APIService apiService;

    private Disciplina disciplinaClicada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        lvDisciplina.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {

                disciplinaClicada = (Disciplina)adapterView.getItemAtPosition(pos);
                dialogFormDisciplina();

            }
        });


        lvDisciplina.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pos, long id) {
                final Disciplina disciplina = (Disciplina) adapterView.getItemAtPosition(pos);

                PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);
                getMenuInflater().inflate(R.menu.popup_lista_disciplinas, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        if (menuItem.getItemId() == R.id.item_remover){
                            apiService.deleteDisciplina(MainActivity.this, disciplina);
                        }

                        return false;
                    }
                });

                popupMenu.show();

                return true;
            }
        });


        apiService = new APIService();

    }

    @Override
    protected void onResume() {
        super.onResume();

        apiService.getDisciplinas(this);

    }

    @OnClick(R.id.fab_nova_disciplina)
    public void dialogFormDisciplina(){
        final View view = getLayoutInflater().inflate(R.layout.dialog_form_disciplina, null);
        final EditText edDisciplinaNome = (EditText) view.findViewById(R.id.ed_disciplina_nome);
        if (disciplinaClicada != null)
            edDisciplinaNome.setText(disciplinaClicada.getNome());

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view)
                .setTitle("Formulario Disciplina")
                .setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String nome = edDisciplinaNome.getText().toString();

                        if (disciplinaClicada == null){
                            apiService.postDisciplina(MainActivity.this, new Disciplina(nome));
                        }else{
                            disciplinaClicada.setNome(nome);
                            apiService.putDisciplina(MainActivity.this, disciplinaClicada);
                        }

                        disciplinaClicada = null;

                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        disciplinaClicada = null;
                    }
                })
                .show();

    }

    @Override
    public void onRetrofitResponse(int status, List dados) {

        if (status == 200){
            ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dados);
            lvDisciplina.setAdapter(adapter);

            tvStatus.setText("200 - OK");
            Toast.makeText(this, "Atualizado", Toast.LENGTH_SHORT).show();
        }else{
            tvStatus.setText(status + " - Not OK");
        }

    }

    @Override
    public void onRetrofitFailure(Throwable t) {
        tvStatus.setText(t.getMessage() + " - Not OK");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.actionbar_activity_main, menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.item_refresh){
            apiService.getDisciplinas(this);
        }

        return super.onOptionsItemSelected(item);
    }
}







