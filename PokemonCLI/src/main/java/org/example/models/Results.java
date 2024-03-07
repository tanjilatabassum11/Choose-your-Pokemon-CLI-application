package org.example.models;

import java.util.List;

public class Results {
    List<Pokemon> results;

    public List<Pokemon> getResults(){
        return results;
    }

    public void setResults(List<Pokemon> results){
        this.results = results;
    }
//    /list automatically return toString
}
