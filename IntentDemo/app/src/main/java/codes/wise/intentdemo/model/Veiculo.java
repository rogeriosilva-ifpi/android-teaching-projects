package codes.wise.intentdemo.model;

/**
 * Created by rogermac on 07/02/17.
 */
public class Veiculo {

    private String nome;
    private String montadora;
    private String valor;

    public Veiculo(String nome, String montadora, String valor){
        this.nome = nome;
        this.montadora = montadora;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }
    //Devido à Reciclagem e evitando muitos findViewById
    public String getMontadora() {
        return montadora;
    }

    public String getValor() {
        return valor;
    }

}

