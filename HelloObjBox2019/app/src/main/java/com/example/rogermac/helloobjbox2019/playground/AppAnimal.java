package com.example.rogermac.helloobjbox2019.playground;

import java.util.ArrayList;
import java.util.List;

public class AppAnimal {


    public static void main(String[] args) {

        final Animal animal = new Cachorro();
        final Animal animal2 = new Gato();

        animal.setNome("Rabito");
        animal2.setNome("Bechano");
        ((Gato)animal2).pular();

        Object obj = animal.coringa("Obg");

        System.out.println(obj);

        System.out.println(animal);
        System.out.println(animal2);



    }
}
