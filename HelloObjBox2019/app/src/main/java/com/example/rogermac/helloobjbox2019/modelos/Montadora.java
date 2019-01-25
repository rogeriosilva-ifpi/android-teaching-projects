package com.example.rogermac.helloobjbox2019.modelos;

import android.util.Log;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Montadora{

    @Id
    private long id;
    private String nome;
    private String pais;

    Montadora(){}

    public Montadora(String nome) {
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return this.getNome();
    }

    public static Montadora getMontadoraNull(){
        return new Montadora("Não informada");
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Montadora)) return false;

        return this.id == ((Montadora)obj).getId();
    }
}