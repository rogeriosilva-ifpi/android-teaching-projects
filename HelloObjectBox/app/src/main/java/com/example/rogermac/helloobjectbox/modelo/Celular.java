package com.example.rogermac.helloobjectbox.modelo;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by rogermac on 22/01/18.
 */

@Entity
public class Celular {

    @Id
    private long id;
    private String modelo;
    private String marca;

    public Celular() {
    }

    public Celular(String modelo, String marca) {
        this.modelo = modelo;
        this.marca = marca;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
