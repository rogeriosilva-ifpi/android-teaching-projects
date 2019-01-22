package com.example.rogermac.filmervobjboxapp.modelos;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Filme {

    @Id
    private long id;
    private String nome;
    private int ano;
    private String genero;

    public Filme(){

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

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
