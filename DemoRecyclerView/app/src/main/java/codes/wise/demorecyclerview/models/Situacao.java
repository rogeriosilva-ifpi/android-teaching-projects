package codes.wise.demorecyclerview.models;

/**
 * Created by rogermac on 22/03/17.
 */

public enum Situacao {
    MATRICULADO(1), APROVADO(2), REPROVADO(3), CURSANDO(4);

    private int codigo;

    Situacao(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "";
    }
}
