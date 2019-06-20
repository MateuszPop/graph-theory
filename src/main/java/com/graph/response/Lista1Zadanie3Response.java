package com.graph.response;

public class Lista1Zadanie3Response extends Response {

    private String typeGraph;

    public Lista1Zadanie3Response() {
        super();
    }

    public Lista1Zadanie3Response(ResponseStatus status, ResponseCode code) {
        super(status, code);
    }

    public Lista1Zadanie3Response(ResponseStatus status, ResponseCode code, String typeGraph) {
        super(status, code);
        this.typeGraph = typeGraph;
    }

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
