package com.graph.response;

public class Lista2Zadanie2Response {

    private Boolean isCycle;
    private String eges;

    public Boolean getCycle() {
        return isCycle;
    }

    public void setCycle(Boolean cycle) {
        isCycle = cycle;
    }

    public String getEges() {
        return eges;
    }

    public void setEges(String eges) {
        this.eges = eges;
    }

    @Override
    public String toString() {
        if(isCycle){
            return "Lista2Zadanie2Response{ \n" +
                    "Graf jest grafem cyklicznym"+
                    "Lista krawedzi='" + eges + '\'' +
                    '}';
        }else{
            return "Lista2Zadanie2Response{" +
                    "Nie jest grafem cyklicznym" +
                    '}';
        }
    }
}
