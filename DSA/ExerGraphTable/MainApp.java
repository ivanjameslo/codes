import java.io.IOException;

public class MainApp {
    public static void main(String[] args) throws IOException {
        Graph graph = new Graph();
        System.out.println("Adjacency List:");
        graph.readGraphFromFile("graph.txt");
        graph.displayAdjacencyList();
        System.out.println();
        System.out.println("Incidence Matrix:");
        graph.displayIncidenceMatrix();
    }
}