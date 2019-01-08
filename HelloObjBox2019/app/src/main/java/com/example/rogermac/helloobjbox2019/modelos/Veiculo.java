package com.example.rogermac.helloobjbox2019.modelos;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Veiculo {

    @Id
    long id;

    private String nome;
    private String cor;
    private int ano;
    private String placa;

    Veiculo() {}

    public Veiculo(String nome, int ano) {
        this.nome = nome;
        this.ano = ano;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }

    public int getAno() {
        return ano;
    }

    public String getPlaca() {
        return placa;
    }
}
