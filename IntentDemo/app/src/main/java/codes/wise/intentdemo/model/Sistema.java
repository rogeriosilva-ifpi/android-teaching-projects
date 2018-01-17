package codes.wise.intentdemo.model;

/**
 * Created by rogermac on 07/02/17.
 */

public class Sistema {

    private String nome;
    private int versao;
    private String fabricante;

    public Sistema(String nome, int versao, String fab){
        this.nome = nome;
        this.versao = versao;
        this.fabricante = fab;
    }

    public String getNome() {
        return nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    @Override
    public String toString() {
        return this.nome + " v." + this.versao;
    }
}
