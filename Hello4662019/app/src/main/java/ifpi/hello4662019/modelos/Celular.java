package ifpi.hello4662019.modelos;

import java.util.ArrayList;
import java.util.List;

public class Celular {

    private String marca;
    private String modelo;
    private String memoria;
    private String processador;
    private double valor;

    public Celular(String marca, String modelo, double valor) {
        this.marca = marca;
        this.modelo = modelo;
        this.valor = valor;
    }

    public Celular(String marca, String modelo, String memoria, String processador, double valor) {
        this.marca = marca;
        this.modelo = modelo;
        this.memoria = memoria;
        this.processador = processador;
        this.valor = valor;
    }

    public static List<Celular> getCelulares(){
        List<Celular> celulares = new ArrayList<>();

        celulares.add(new Celular("Apple", "IPhone XR", 9000));
        celulares.add(new Celular("Apple", "IPhone 8", 3000));
        celulares.add(new Celular("Samsung", "A5", 300));
        celulares.add(new Celular("Apple", "IPhone 5C", 900));
        celulares.add(new Celular("Samsung", "J4", 600));
        celulares.add(new Celular("Samsung", "S10", 6000));
        celulares.add(new Celular("Apple", "IPhone 4S", 400));
        celulares.add(new Celular("Samsung", "A7", 1000));

        return  celulares;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
