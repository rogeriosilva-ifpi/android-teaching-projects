package codes.wise.retrofitdemo.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by rogermac on 30/03/17.
 */

public class Disciplina {

    private long id;
    private String nome;
    private List<String> turmas;

    public Disciplina(){
        this.turmas = new ArrayList<>();
    }

    public Disciplina(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getTurmas() {
        return Collections.unmodifiableList(turmas);
    }

    public void setTurmas(List<String> turmas) {
        this.turmas = turmas;
    }

    @Override
    public String toString() {
        return this.id + " - " + this.getNome();
    }
}
