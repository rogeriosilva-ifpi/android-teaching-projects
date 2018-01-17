package codes.wise.appcursossugarorm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import codes.wise.appcursossugarorm.modelos.Curso;

public class FormularioActivity extends AppCompatActivity {

    private EditText edCursoNome;
    private EditText edCursoCH;
    private EditText edCursoInstrutor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        //Binding
        edCursoNome = (EditText) findViewById(R.id.ed_curso_nome);
        edCursoCH = (EditText) findViewById(R.id.ed_curso_ch);
        edCursoInstrutor = (EditText) findViewById(R.id.ed_curso_instrutor);

    }

    public void salvarCurso(View view) {
        //Salvar no Banco de Dados
        String nome = edCursoNome.getText().toString();
        int ch = Integer.valueOf(edCursoCH.getText().toString());
        String instrutor = edCursoInstrutor.getText().toString();

        Curso curso = new Curso(nome, ch, instrutor);
        //Manda o SugarORM salvar
        curso.save();

        Toast.makeText(this, "Curso Salvo.", Toast.LENGTH_SHORT).show();

        //Encerrar a tela(Activity)
        finish();

    }

}
