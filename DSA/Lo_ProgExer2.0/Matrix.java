import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Matrix {
    private String[][] adjacencyList;
    private Map<String, Integer> vertexIndices;
    private static final int MAX_VERTICES = 20;
    private static final int MAX_EDGES = 100;
    private String[] edges = new String[MAX_EDGES];
    private int edgeCount = 0;

    public Matrix() {
        adjacencyList = new String[MAX_VERTICES][MAX_EDGES];
        vertexIndices = new HashMap<>();
    }

    public void addEdge(String vertex1, String vertex2) {
        int index1 = vertexIndices.get(vertex1);
        int index2 = vertexIndices.get(vertex2);

        for (int i = 0; i < MAX_EDGES; i++) {
            if (adjacencyList[index1][i] == null) {
                adjacencyList[index1][i] = vertex2;
                break;
            }
        }

        for (int i = 0; i < MAX_EDGES; i++) {
            if (adjacencyList[index2][i] == null) {
                adjacencyList[index2][i] = vertex1;
                break;
            }
        }

        if (edgeCount < MAX_EDGES) {
            edges[edgeCount++] = vertex1 + "-" + vertex2;
        }
    }

    public void readGraphFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        int vertexIndex = 0;
        while ((line = reader.readLine()) != null) {
            if (line.length() == 1) {
                vertexIndices.put(line, vertexIndex++);
            } else {
                String[] vertices = line.split(" ");
                addEdge(vertices[0], vertices[1]);
            }
        }
        reader.close();
    }

    public void displayAdjacencyList() {
        System.out.print("   ");
        for (String vertex : vertexIndices.keySet()) {
            System.out.printf("%-3s", vertex);
        }
        System.out.println();
        for (String vertex : vertexIndices.keySet()) {
            System.out.printf("%-3s", vertex);
            for (String otherVertex : vertexIndices.keySet()) {
                int index = vertexIndices.get(vertex);
                int contains = 0;
                for (String edge : adjacencyList[index]) {
                    if (edge != null && edge.equals(otherVertex)) {
                        contains = 1;
                        break;
                    }
                }
                System.out.printf("%-3d", contains);
            }
            System.out.println();
        }
    }

    public void displayIncidenceMatrix() {
        System.out.print("   ");
        for (int i = 0; i < edgeCount; i++) {
            System.out.printf("%-5s", edges[i]);
        }
        System.out.println();
        for (String vertex : vertexIndices.keySet()) {
            System.out.printf("%-3s", vertex);
            for (int i = 0; i < edgeCount; i++) {
                int contains = 0;
                if (edges[i].contains(vertex)) {
                    contains = 1;
                }
                System.out.printf("%-5d", contains);
            }
            System.out.println();
        }
    }

    

}
