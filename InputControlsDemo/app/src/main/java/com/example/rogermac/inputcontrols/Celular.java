package com.example.rogermac.inputcontrols;

import java.io.Serializable;

public class Celular implements Serializable{

    private String marca;
    private String modelo;
    private int processador;
    private boolean cameraFrontal;
    private boolean flashFrontal;
    private boolean leitorDigital;
    private boolean dualChip;
    private String armazenamentoInterno;
    private String memoriaRAM;

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

    public int getProcessador() {
        return processador;
    }

    public void setProcessador(int processador) {
        this.processador = processador;
    }

    public boolean isCameraFrontal() {
        return cameraFrontal;
    }

    public void setCameraFrontal(boolean cameraFrontal) {
        this.cameraFrontal = cameraFrontal;
    }

    public boolean isFlashFrontal() {
        return flashFrontal;
    }

    public void setFlashFrontal(boolean flashFrontal) {
        this.flashFrontal = flashFrontal;
    }

    public boolean isLeitorDigital() {
        return leitorDigital;
    }

    public void setLeitorDigital(boolean leitorDigital) {
        this.leitorDigital = leitorDigital;
    }

    public boolean isDualChip() {
        return dualChip;
    }

    public void setDualChip(boolean dualChip) {
        this.dualChip = dualChip;
    }

    public String getArmazenamentoInterno() {
        return armazenamentoInterno;
    }

    public void setArmazenamentoInterno(String armazenamentoInterno) {
        this.armazenamentoInterno = armazenamentoInterno;
    }

    public String getMemoriaRAM() {
        return memoriaRAM;
    }

    public void setMemoriaRAM(String memoriaRAM) {
        this.memoriaRAM = memoriaRAM;
    }

    @Override
    public String toString() {
        return "Celular{" +
                "\nmarca=" + marca  +
                "\nmodelo=" + modelo  +
                "\nprocessador=" + processador+ "bits" +
                "\nCamera Frontal=" + cameraFrontal +
                "\nFlash Frontal=" + flashFrontal +
                "\nLeitor de Digital=" + leitorDigital +
                "\nDualsim="+ dualChip +
                "\nMemória RAM=" + memoriaRAM +
                "\nArmazenamento Int.=" + armazenamentoInterno +
                '}';
    }
}
