package com.example.rogermac.appcountads.models;


import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Jogo {

    @Id
    public long id;

    private String nome;
    private int anoLancamento;
    private double valor;

    Jogo() {} //for object box

    public Jogo(String nome, int anoLancamento, double valor) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public double getValor() {
        return valor;
    }
}
