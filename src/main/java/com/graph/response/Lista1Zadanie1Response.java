package com.graph.response;

public class Lista1Zadanie1Response extends Response {

    private String verticlesNumber;
    private String verticlesCollection;
    private String egesNumber;
    private String egesCollection;
    private String adjacencyMatrix;
    private String incidenceMatrix;

    public Lista1Zadanie1Response() {
        super();
    }

    public Lista1Zadanie1Response(ResponseStatus status, ResponseCode code) {
        super(status, code);
    }

    public Lista1Zadanie1Response(ResponseStatus status, ResponseCode code, String verticlesNumber, String verticlesCollection, String egesNumber, String egesCollection, String adjacencyMatrix, String incidenceMatrix) {
        super(status, code);
        this.verticlesNumber = verticlesNumber;
        this.verticlesCollection = verticlesCollection;
        this.egesNumber = egesNumber;
        this.egesCollection = egesCollection;
        this.adjacencyMatrix = adjacencyMatrix;
        this.incidenceMatrix = incidenceMatrix;
    }

    public String getVerticlesNumber() {
        return verticlesNumber;
    }

    public void setVerticlesNumber(String verticlesNumber) {
        this.verticlesNumber = verticlesNumber;
    }

    public String getVerticlesCollection() {
        return verticlesCollection;
    }

    public void setVerticlesCollection(String verticlesCollection) {
        this.verticlesCollection = verticlesCollection;
    }

    public String getEgesNumber() {
        return egesNumber;
    }

    public void setEgesNumber(String egesNumber) {
        this.egesNumber = egesNumber;
    }

    public String getEgesCollection() {
        return egesCollection;
    }

    public void setEgesCollection(String egesCollection) {
        this.egesCollection = egesCollection;
    }

    public String getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public void setAdjacencyMatrix(String adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
    }

    public String getIncidenceMatrix() {
        return incidenceMatrix;
    }

    public void setIncidenceMatrix(String incidenceMatrix) {
        this.incidenceMatrix = incidenceMatrix;
    }

    @Override
    public String toString() {
        return "Zadanie1Lista1{" +"\n"+
                "Liczba wierzcholkow grafu G wynosi= " + verticlesNumber + "\'\n" +
                "Zbior wierzcholkow V = "+ verticlesCollection + "\'\n" +
                "Liczba krawedzi grafu G wynosi = " + '\'' + egesNumber + "\'\n" +
                "Zbior krawedzi E = " + egesCollection + "\'\n" +
                "Macierz sasiedztwa A = " +"\'\n"+ adjacencyMatrix + '\'' +
                "Macierz incydencji M = " +"\'\n"+ incidenceMatrix + '\'' +
                '}';
    }
}
