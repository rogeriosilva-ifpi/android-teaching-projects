package com.example.rogermac.hellorecyclerview.modelos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rogermac on 15/01/18.
 */

public class Celular {

    private String fabricante;
    private String modelo;
    private double valor;

    public Celular(String fabricante, String modelo, double valor) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.valor = valor;
    }

    public static List<Celular> getCelulares(){
        List<Celular> celulares = new ArrayList<>();

        Celular iphone = new Celular("Apple", "IPhone X", 7999);
        celulares.add(iphone);
        celulares.add(iphone);

        Celular s8 = new Celular("Samsung", "S8", 2999);
        celulares.add(s8);
        celulares.add(s8);

        Celular motox = new Celular("Lenovo", "Moto X", 1899);
        celulares.add(motox);
        celulares.add(motox);

        Celular k10 = new Celular("LG", "K10", 999);
        celulares.add(k10);
        celulares.add(k10);

        Celular brasil = new Celular("Positivo", "Brasil", 399);
        celulares.add(brasil);
        celulares.add(brasil);

        return celulares;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public double getValor() {
        return valor;
    }
}







