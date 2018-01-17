package codes.wise.retrofitdemo.infra;

import java.util.ArrayList;
import java.util.List;

import codes.wise.retrofitdemo.models.Usuario;

/**
 * Created by rogermac on 04/04/17.
 */

public class ListaUsuarioAPIModel {

    private int count;
    private String next;
    private String previus;
    private List<Usuario> results;

    public ListaUsuarioAPIModel() {
        this.results = new ArrayList<>();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevius() {
        return previus;
    }

    public void setPrevius(String previus) {
        this.previus = previus;
    }

    public List<Usuario> getResults() {
        return results;
    }

    public void setResults(List<Usuario> results) {
        this.results = results;
    }
}
