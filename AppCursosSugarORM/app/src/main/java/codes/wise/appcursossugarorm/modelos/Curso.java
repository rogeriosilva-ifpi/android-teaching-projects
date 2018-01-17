package codes.wise.appcursossugarorm.modelos;

import com.orm.SugarRecord;

/**
 * Created by rogermac on 02/03/17.
 */

public class Curso extends SugarRecord{

    private String nome;
    private int ch;
    private String ementa;
    private String instrutor;
    private double valor;

    public Curso(){

    }

    public Curso(String nome, int ch, String instrutor){
        this.nome = nome;
        this.ch = ch;
        this.instrutor = instrutor;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "ID = " + getId() + '\'' +
                ", nome='" + nome + '\'' +
                ", ch=" + ch +
                ", instrutor='" + instrutor + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCh() {
        return ch;
    }

    public void setCh(int ch) {
        this.ch = ch;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public String getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(String instrutor) {
        this.instrutor = instrutor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
