package com.example.rogermac.helloobjbox2019.playground;

public abstract class Animal<T> {

    private String nome;

    public abstract String comunica();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public final String toString() {
        return "Animal{" +
                "nome='" + nome + '\'' +
                "diz='" +this.comunica() + '\'' +
                '}';
    }

    public T coringa(T simbolo){
        return simbolo;
    }
}
