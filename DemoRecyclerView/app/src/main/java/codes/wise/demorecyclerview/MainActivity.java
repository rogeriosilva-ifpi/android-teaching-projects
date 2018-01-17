package codes.wise.demorecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import codes.wise.demorecyclerview.adapters.AlunoRecyclerViewAdapter;
import codes.wise.demorecyclerview.models.Aluno;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvAlunos = (RecyclerView)findViewById(R.id.rv_alunos);

        List<Aluno> alunos = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            alunos.add(new Aluno("Denise Silva", "denise@gmail.com"));
            alunos.add(new Aluno("Mayane Silva", "mayane@gmail.com"));
        }

        AlunoRecyclerViewAdapter adapter = new AlunoRecyclerViewAdapter(this, alunos);
        rvAlunos.setAdapter(adapter);

        rvAlunos.setLayoutManager(new LinearLayoutManager(this));
    }
}
