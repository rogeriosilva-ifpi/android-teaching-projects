package codes.wise.retrofitdemo.infra;

import java.util.ArrayList;
import java.util.List;

import codes.wise.retrofitdemo.models.Disciplina;

/**
 * Created by rogermac on 30/03/17.
 */

public class ListaDisciplinaAPIModel {

    private int count;
    private String next;
    private String previus;
    private List<Disciplina> results;

    public ListaDisciplinaAPIModel(){
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

    public List<Disciplina> getResults() {
        return results;
    }

    public void setResults(List<Disciplina> results) {
        this.results = results;
    }
}
