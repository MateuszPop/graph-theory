package com.graph.response;

public class Lista3Zadanie2Response {

    private Boolean isCycle;
    private String eges;
    private String link;

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        if(isCycle){
            return "Lista2Zadanie2Response{ \n" +
                    "Graf jest grafem cyklicznym"+
                    "Lista krawedzi='" + eges + "\n" +
                    "Link: "+link+"\n"+
                    '}';
        }else{
            return "Lista2Zadanie2Response{" +
                    "Nie jest grafem cyklicznym" +
                    '}';
        }
    }
}
