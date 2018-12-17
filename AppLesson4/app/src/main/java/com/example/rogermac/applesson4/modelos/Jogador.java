package com.example.rogermac.applesson4.modelos;

public class Jogador {

    private String numero;
    private String nome;
    private String posicao;

    public Jogador(String numero, String nome, String posicao) {
        this.numero = numero;
        this.nome = nome;
        this.posicao = posicao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }
}
