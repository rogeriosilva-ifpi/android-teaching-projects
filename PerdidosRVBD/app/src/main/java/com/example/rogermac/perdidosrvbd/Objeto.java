package com.example.rogermac.perdidosrvbd;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Objeto {

    @Id
    protected long id;
    private String nome;
    private String data;
    private String local;
    private String tipo;

    public Objeto() {
    }

    public Objeto(String nome, String data, String local, String tipo) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public String getLocal() {
        return local;
    }

    public String getTipo() {
        return tipo;
    }

    public long getId() {
        return id;
    }
}
