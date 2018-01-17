package codes.wise.demorecyclerview.models;

/**
 * Created by rogermac on 21/03/17.
 */

public class Aluno {

    private String nome;
    private String email;
    private Situacao situacao;

    public Aluno(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.situacao = Situacao.MATRICULADO;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }


}
