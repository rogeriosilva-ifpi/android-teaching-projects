package codes.wise.demorecyclerview.adapters;


import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import codes.wise.demorecyclerview.R;
import codes.wise.demorecyclerview.models.Aluno;

public class AlunoRecyclerViewAdapter extends RecyclerView.Adapter<AlunoRecyclerViewAdapter.ViewHolder>{

    private final Context context;
    private final List<Aluno> alunos;

    public AlunoRecyclerViewAdapter(Context context, List<Aluno> alunos) {
        this.context = context;
        this.alunos = alunos;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvAlunoNome;

        public TextView tvAlunoEmail;
        public ViewHolder(View itemView) {

            super(itemView);

            tvAlunoNome = (TextView)itemView.findViewById(R.id.tv_aluno_nome);
            tvAlunoEmail = (TextView)itemView.findViewById(R.id.tv_aluno_email);

        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item, parent, false);

        ViewHolder  viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Aluno aluno = alunos.get(position);

        holder.tvAlunoNome.setText(aluno.getNome());
        holder.tvAlunoEmail.setText(aluno.getEmail());

        setupClick(holder, aluno);

        setupLongClick(holder, aluno);

    }

    private void setupLongClick(ViewHolder holder, final Aluno aluno) {
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                final Snackbar snack = Snackbar.make(view, "Aluno: " + aluno.getNome(), Snackbar.LENGTH_INDEFINITE);

                snack.setAction("Ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snack.dismiss();
                    }
                });

                snack.show();

                return true;
            }
        });
    }

    private void setupClick(ViewHolder holder, final Aluno aluno) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Aluno: " + aluno.getNome(), Snackbar.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return alunos.size();
    }



}
