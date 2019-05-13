package com.example.rogermac.helloobjbox2019.modelos;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.Observable;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

@Entity
public class Veiculo extends BaseObservable {

    @Id
    long id;

    private String nome;
    private String cor;
    private int ano;
    private String placa;

    private ToOne<Montadora> montadora;

    public Veiculo() {}

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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setAnoString(String ano){
        try{
            this.setAno(Integer.parseInt(ano));
        }catch (NumberFormatException e){
            this.setAno(0);
        }
    }

    @Bindable
    public String getAnoString(){
        return String.valueOf(this.getAno());
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public ToOne<Montadora> getMontadora() {
        return montadora;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "nome='" + nome + '\'' +
                '}';
    }

    public void setMontadora(Montadora montadoraSelecionada) {
        this.getMontadora().setTarget(montadoraSelecionada);
    }
}
