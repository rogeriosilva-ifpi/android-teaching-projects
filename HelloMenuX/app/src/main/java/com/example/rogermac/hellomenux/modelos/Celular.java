package com.example.rogermac.hellomenux.modelos;

/**
 * Created by rogermac on 25/01/18.
 */

public class Celular {

    private String modelo;
    private String marca;

    public Celular(String modelo, String marca) {
        this.modelo = modelo;
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
