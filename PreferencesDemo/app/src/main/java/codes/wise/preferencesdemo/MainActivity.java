package codes.wise.preferencesdemo;

import android.app.ActionBar;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edUsuarioNome;
    private EditText edUsuarioEmail;
    private EditText edUsuarioIdade;
    private TextView tvUsuarioNome, tvUsuarioEmail, tvUsuarioIdade;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Binding...
        edUsuarioNome = (EditText) findViewById(R.id.ed_usuario_nome);
        edUsuarioEmail = (EditText) findViewById(R.id.ed_usuario_email);
        edUsuarioIdade = (EditText) findViewById(R.id.ed_usuario_idade);

        tvUsuarioNome = (TextView) findViewById(R.id.tv_usuario_nome);
        tvUsuarioEmail = (TextView) findViewById(R.id.tv_usuario_email);
        tvUsuarioIdade = (TextView) findViewById(R.id.tv_usuario_idade);

        preferences = getSharedPreferences("codes.wise.prefapp.configuracoes", Context.MODE_PRIVATE);

        mostrarPreferencias();

    }

    public void mostrarPreferencias(){

        String nome = preferences.getString("usuario_nome", "N/A");
        String email = preferences.getString("usuario_email", "N/A");
        int idade = preferences.getInt("usuario_idade", 0);

        tvUsuarioNome.setText(nome);
        tvUsuarioEmail.setText(email);
        tvUsuarioIdade.setText(String.valueOf(idade));
    }

    public void limparFormulario(){
        edUsuarioNome.getText().clear();
        edUsuarioEmail.getText().clear();
        edUsuarioIdade.getText().clear();
    }

    public void salvarPreferencias(View view) {
        //Salvar em Preferencias
        String nome = edUsuarioNome.getText().toString();
        String email = edUsuarioEmail.getText().toString();

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("usuario_nome", nome);
        editor.putString("usuario_email", email);

        try {
            int idade = Integer.valueOf(edUsuarioIdade.getText().toString());
            editor.putInt("usuario_idade", idade);
        }catch (NumberFormatException e){
            editor.putInt("usuario_idade", -1);
        }

        editor.commit();
        limparFormulario();
        mostrarPreferencias();

        Toast.makeText(this, "Salvo.", Toast.LENGTH_SHORT).show();

    }

    public void loadPreferencias(View view) {

        String nome = preferences.getString("usuario_nome", "N/A");
        String email = preferences.getString("usuario_email", "N/A");
        int idade = preferences.getInt("usuario_idade", 0);

        edUsuarioNome.setText(nome);
        edUsuarioEmail.setText(email);
        edUsuarioIdade.setText(String.valueOf(idade));
    }

    public void limparPreferencias(View view) {

        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();

        Toast.makeText(this, "Clear", Toast.LENGTH_SHORT).show();

        mostrarPreferencias();
        limparFormulario();
    }

    public void limparEmail(View view) {

        SharedPreferences.Editor editor = preferences.edit();
        editor.remove("usuario_email");
        editor.commit();

        Toast.makeText(this, "Removed", Toast.LENGTH_SHORT).show();

        mostrarPreferencias();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.action_bar_menu, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.item1).getActionView();

        searchView.setQueryHint("Pesquise aqui");


        return super.onCreateOptionsMenu(menu);
    }
}










