package com.graph.services;

import com.graph.response.*;
import org.jgrapht.Graph;
import org.jgrapht.GraphMetrics;
import org.jgrapht.GraphPath;
import org.jgrapht.GraphTests;
import org.jgrapht.alg.color.GreedyColoring;
import org.jgrapht.alg.cycle.HierholzerEulerianCycle;
import org.jgrapht.alg.interfaces.EulerianCycleAlgorithm;
import org.jgrapht.alg.interfaces.VertexColoringAlgorithm;
import org.jgrapht.generate.ComplementGraphGenerator;
import org.jgrapht.generate.GraphGenerator;
import org.jgrapht.generate.WheelGraphGenerator;
import org.jgrapht.graph.*;
import org.jgrapht.io.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class GrafyService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String UPLOADED_FOLDER = "src/main/resources/";

    public String lista1Zadanie1(String filePath){
        CSVExporter<String,DefaultEdge> matrixExporter = new CSVExporter<>(CSVFormat.MATRIX);
        matrixExporter.setParameter(CSVFormat.Parameter.MATRIX_FORMAT_ZERO_WHEN_NO_EDGE,true);
        Graph graph = loadGraphWithFile(filePath);
        Lista1Zadanie1Response lista1Zadanie1Response = new Lista1Zadanie1Response();
        lista1Zadanie1Response.setEgesNumber(String.valueOf(graph.edgeSet().size()));
        lista1Zadanie1Response.setEgesCollection(graph.edgeSet().toString());
        lista1Zadanie1Response.setVerticlesNumber(String.valueOf(graph.vertexSet().size()));
        lista1Zadanie1Response.setVerticlesCollection(graph.vertexSet().toString());
        try {
            Writer writerAdjacencyMatrix = new StringWriter();
            matrixExporter.exportGraph(graph,writerAdjacencyMatrix);
            String dataAdjacencyMatrix = writerAdjacencyMatrix.toString();
            Writer writerIncidenceMatrix = new StringWriter();
            matrixExporter.exportGraph(graph,writerIncidenceMatrix);
            lista1Zadanie1Response.setAdjacencyMatrix(dataAdjacencyMatrix);
            lista1Zadanie1Response.setIncidenceMatrix(getIncidenceMatrix(graph));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista1Zadanie1Response.toString();
    }

    public String lista1Zadanie2(String filePath){
        Lista1Zadanie2Response lista1Zadanie2 = new Lista1Zadanie2Response();
        Graph graph = loadGraphWithFile(filePath);
        lista1Zadanie2.setGraphOrder(String.valueOf(graph.vertexSet().size()));
        lista1Zadanie2.setGraphSize(String.valueOf(graph.edgeSet().size()));
        lista1Zadanie2.setGraphVertexDeg(degreesOfVertices(graph));
        lista1Zadanie2.setSeriesDegGraph(seriesDegGraph(graph));
        return lista1Zadanie2.toString();
    }

    public String lista1Zadanie3(String filePath){
        Lista1Zadanie3Response lista1Zadanie3 = new Lista1Zadanie3Response();
        Graph graph = loadGraphWithFile(filePath);
        lista1Zadanie3.setTypeGraph(testGraphSimple(graph));
        return lista1Zadanie3.toString();
    }

    public String lista1Zadanie4(String filePath){
        Lista1Zadanie4Response lista1Zadanie4 = new Lista1Zadanie4Response();
        Graph graph = loadGraphWithFile(filePath);
        lista1Zadanie4.setCompleteGraph(GraphTests.isComplete(graph));
        ComplementGraphGenerator complementGraphGenerator = new ComplementGraphGenerator(graph);
        Graph<Object, DefaultEdge> complementGraph = new Pseudograph<>(DefaultEdge.class);
        complementGraphGenerator.generateGraph(complementGraph);
        lista1Zadanie4.setComplementGraph(complementGraph.edgeSet().toString());
        return lista1Zadanie4.toString();
    }

    public String lista1Zadanie5(String filePath){
        Lista1Zadanie5Response lista1Zadanie5 = new Lista1Zadanie5Response();
        Graph graph = loadGraphWithFile(filePath);
        String listVertex = new String();
        Set<String> vertes = graph.vertexSet();
        for ( String vertex : vertes) {
            Set<DefaultEdge> eges = graph.outgoingEdgesOf(vertex);
            listVertex+=vertex+" -> "+eges.toString().replaceAll(vertex," ").replaceAll("\\p{Punct}","").replaceAll(" +", " ")+"\n";
        }
        lista1Zadanie5.setListAdjacency(listVertex);
        return lista1Zadanie5.toString();
    }

    public String lista2Zadanie1(String filePath){
        Lista2Zadanie1Response lista2Zadanie1 = new Lista2Zadanie1Response();
        Graph graph = loadGraphWithFile(filePath);
        lista2Zadanie1.setRegular(regularGraph(graph));
       if(regularGraph(graph)){
           lista2Zadanie1.setDeg(Integer.valueOf(regularGraphDeg(graph)));
       }
        return lista2Zadanie1.toString();
    }

    public String lista2Zadanie2(String filePath){
        Lista2Zadanie2Response lista2Zadanie2 = new Lista2Zadanie2Response();
        Graph graph = loadGraphWithFile(filePath);
        if(regularGraph(graph)&& GraphTests.isConnected(graph) && Integer.valueOf(regularGraphDeg(graph)).equals(new Integer(2))){
            SimpleGraph<Object, DefaultEdge> wheelGraph = new SimpleGraph<>(DefaultEdge.class);
            Supplier<Object> vSupplier = new Supplier<Object>()
            {
                private int id = 0;

                @Override
                public String get()
                {
                    return  ""+id++;
                }
            };
            wheelGraph.setVertexSupplier(vSupplier);
            GraphGenerator wheelGraphGenerator = new WheelGraphGenerator(graph.vertexSet().size());
            wheelGraphGenerator.generateGraph(wheelGraph);
            lista2Zadanie2.setCycle(true);
            lista2Zadanie2.setEges(wheelGraph.edgeSet().toString());
            DOTExporter dotExporter = new DOTExporter();
            File file = new File(UPLOADED_FOLDER+new Date().getTime());
            try {
                dotExporter.exportGraph(wheelGraph,file);
            } catch (ExportException e) {
                e.printStackTrace();
            }
            return lista2Zadanie2.toString();
           }
           else
        {
            lista2Zadanie2.setCycle(false);
            return lista2Zadanie2.toString();
        }

    }
    public String lista2Zadanie3(String filePath) {
        Lista2Zadanie2Response lista2Zadanie2 = new Lista2Zadanie2Response();
        Graph graph = loadGraphWithFile(filePath);
        long tirangles = GraphMetrics.getNumberOfTriangles(graph);
        if (tirangles == graph.vertexSet().size() - 1) {
        return "Jest Kołem";
        } else {
            return "Nie Jest Kołem";
        }
    }

    public String lista2Zadanie4(String filePath) {
        Lista2Zadanie2Response lista2Zadanie2 = new Lista2Zadanie2Response();
        Graph graph = loadGraphWithFile(filePath);
        GreedyColoring greedyColoring = new GreedyColoring(graph);
        VertexColoringAlgorithm.Coloring coloring = greedyColoring.getColoring();
        DOTExporter dotExporter = new DOTExporter();
        File file = new File(UPLOADED_FOLDER+new Date().getTime());
        try {
            dotExporter.putGraphAttribute("colors", coloring.getColorClasses().toString());
            dotExporter.exportGraph(graph,file);
            return file.getAbsolutePath();
        } catch (ExportException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    public String lista2Zadanie5(String filePath) {
        int number =0;
        Graph graph = loadGraphWithFile(filePath);

        if(GraphTests.isEulerian(graph)){
            return "Graf jest grafem eulerowskim";

        }else{
            Set<String> vertes = graph.vertexSet();
            for ( String vertex : vertes) {
                if( graph.degreeOf(vertex) % 2 != 0 ){
                    number++;
                }

            }
            if(number==2){
                return "Graf jest grafem półeulerowskim";
            }
        }
        return "Graf nie jest grafem eulerowskim";

    }



    private Graph loadGraphWithFile(String filePath){
        VertexProvider<Object> vertexProvider = (label, attributes) -> label;
        EdgeProvider<Object, DefaultEdge> edgeProvider = (from, to, label, attributes) -> new DefaultEdge();
        CSVImporter<Object,DefaultEdge> csvImporter = new CSVImporter<>(vertexProvider,edgeProvider);
        csvImporter.setFormat(CSVFormat.EDGE_LIST);
        Graph<Object, DefaultEdge> network = new Pseudograph<>(DefaultEdge.class);
        try {
            try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
                List<String> replaced = lines
                        .map(line-> line.replaceAll(" ", ","))
                        .collect(Collectors.toList());
                replaced.remove(0);
                Files.write(Paths.get(filePath), replaced);
            }
            csvImporter.importGraph(network,new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return network;
    }

    private String getIncidenceMatrix(Graph graph){
        int[][] arr = new int[graph.vertexSet().size()][graph.edgeSet().size()];
        Set<DefaultEdge> edges = graph.edgeSet();
        int c=0;
        for ( DefaultEdge edge : edges) {
            arr[Integer.valueOf((String)graph.getEdgeSource(edge))-1][c] = 1;
            arr[Integer.valueOf((String)graph.getEdgeTarget(edge))-1][c] = 1;
            c++;
        }
        return arrayToString(arr);
    }

    private   String arrayToString(int[][] a) {
        return Arrays.stream(a)
                .map(s -> Arrays.stream(s)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(","))
                )
                .collect(Collectors.joining("\n"));
    }

    private String degreesOfVertices(Graph graph){
        String degress = new String();
        Set<String> vertes = graph.vertexSet();
        for ( String vertex : vertes) {
            degress += "deg("+vertex+") = " + graph.degreeOf(vertex) +" \n";
        }
        return degress;
    }

    private String seriesDegGraph(Graph graph){
        List<Integer> series = new ArrayList<>();
        Set<String> vertes = graph.vertexSet();
        for ( String vertex : vertes) {
            series.add(graph.degreeOf(vertex));
        }
        Collections.sort(series);
        return series.toString();
    }

    private Boolean regularGraph(Graph graph){
        List<Integer> series = new ArrayList<>();
        Set<String> vertes = graph.vertexSet();
        for ( String vertex : vertes) {
            series.add(graph.degreeOf(vertex));
        }
        return series.stream().distinct().limit(2).count() <= 1;

    }

    private String regularGraphDeg(Graph graph){
        Set<String> vertes = graph.vertexSet();
        for ( String vertex : vertes) {
            return String.valueOf(graph.degreeOf(vertex));
        }
        return "";
    }

    private String testGraphSimple(Graph graph){
        if(GraphTests.isSimple(graph)){
            return "prostym";
        }
        else return "ogólny";
    }

}
