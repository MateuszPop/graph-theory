package com.graph.response;

public class Lista1Zadanie2Response extends Response {

    private String graphOrder;
    private String graphSize;
    private String graphVertexDeg;
    private String seriesDegGraph;

    public Lista1Zadanie2Response() {
        super();
    }

    public Lista1Zadanie2Response(ResponseStatus status, ResponseCode code) {
        super(status, code);
    }

    public Lista1Zadanie2Response(ResponseStatus status, ResponseCode code, String graphOrder, String graphSize, String graphVertexDeg, String seriesDegGraph) {
        super(status, code);
        this.graphOrder = graphOrder;
        this.graphSize = graphSize;
        this.graphVertexDeg = graphVertexDeg;
        this.seriesDegGraph = seriesDegGraph;
    }

    public String getGraphOrder() {
        return graphOrder;
    }

    public void setGraphOrder(String graphOrder) {
        this.graphOrder = graphOrder;
    }

    public String getGraphSize() {
        return graphSize;
    }

    public void setGraphSize(String graphSize) {
        this.graphSize = graphSize;
    }

    public String getGraphVertexDeg() {
        return graphVertexDeg;
    }

    public void setGraphVertexDeg(String graphVertexDeg) {
        this.graphVertexDeg = graphVertexDeg;
    }

    public String getSeriesDegGraph() {
        return seriesDegGraph;
    }

    public void setSeriesDegGraph(String seriesDegGraph) {
        this.seriesDegGraph = seriesDegGraph;
    }

    @Override
    public String toString() {
        return "Lista1Zadanie2Response{"+"\n"+
                "Rząd grafu G wynosi " + graphOrder + '\n' +
                "Rozmiar grafu G wynosi " + graphSize + '\n' +
                "Stopnie wierzcholkow \n" + graphVertexDeg + '\n' +
                "Ciag stopni grafu G: " + seriesDegGraph + '\n' +
                "}";
    }
}
