package com.example.rogermac.appcountads.models;

public class Jogo {

    private String nome;
    private int anoLancamento;
    private double valor;


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
