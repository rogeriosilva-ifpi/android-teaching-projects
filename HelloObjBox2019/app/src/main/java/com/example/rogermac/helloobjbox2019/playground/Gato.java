package com.example.rogermac.helloobjbox2019.playground;

public class Gato<T extends Animal> extends Animal<Integer> {

    @Override
    public String comunica() {
        return "Miaaaaumm...";
    }

    public void pular(){
        System.out.println(getNome() + " pulou");
    }

    public void brigar(T inimigo){
        System.out.println("Gato bringando com " + inimigo);
    }
}
