package com.graph.response;

public class Lista1Zadanie3Response {

    private String typeGraph;

    public String getTypeGraph() {
        return typeGraph;
    }

    public void setTypeGraph(String typeGraph) {
        this.typeGraph = typeGraph;
    }

    @Override
    public String toString() {
        return "Lista1Zadanie3Response{" +"\n"+
                "Graf G jest grafem '" + typeGraph + '\'' +
                '}';
    }
}
