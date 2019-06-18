package com.graph.response;

public class Lista1Zadanie4Response extends Response{

    private Boolean isCompleteGraph;
    private String complementGraph;

    public Boolean getCompleteGraph() {
        return isCompleteGraph;
    }

    public void setCompleteGraph(Boolean completeGraph) {
        isCompleteGraph = completeGraph;
    }

    public String getComplementGraph() {
        return complementGraph;
    }

    public void setComplementGraph(String complementGraph) {
        this.complementGraph = complementGraph;
    }

    @Override
    public String toString() {

        if (isCompleteGraph) {
            return "Lista1Zadanie4Response{" + " \n" +
                    "Graf G jest grafem pelnym \n"+
                    "}";
        } else {
            return "Lista1Zadanie4Response{" + " \n" +
                    "Graf G nie jest grafem pelnym " + "\n" +
                    "Krawedzie dopelnienia grafu G: " + complementGraph + "\n" +
                    "}";
        }
    }
}
