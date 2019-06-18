package com.graph.response;

public class Lista1Zadanie5Response extends Response{

    private String listAdjacency;

    public String getListAdjacency() {
        return listAdjacency;
    }

    public void setListAdjacency(String listAdjacency) {
        this.listAdjacency = listAdjacency;
    }

    @Override
    public String toString() {
        return "Lista1Zadanie5Response{ \n" +
                "Lista wierzcholkow grafu G: \n" + listAdjacency + '\n' +
                '}';
    }
}
