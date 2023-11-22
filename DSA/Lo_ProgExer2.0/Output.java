import java.io.*;
import java.util.*;

public class Output {
    private String[] vertices;
    private String[] edges;
    private int[][] adjacencyMatrix;
    private int[][] incidenceMatrix;
    private int vertexCount = 0;
    private int edgeCount = 0;

    public void countVandE(String filename) throws IOException {
        
        BufferedReader br = new BufferedReader(new FileReader("graph.txt"));
        String l; //line

        while ((l = br.readLine()) != null) {
            if (l.length() == 1) {
                vertexCount++;
            } else {
                edgeCount++;
            }
        }

        br.close();
        vertices = new String[vertexCount];
        edges = new String[edgeCount];
        adjacencyMatrix = new int[vertexCount][vertexCount];
        incidenceMatrix = new int[vertexCount][edgeCount];
    }

    public void readGraphFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("graph.txt"));
        String l;
        int vIndex = 0;
        int eIndex = 0;
        
        while ((l = br.readLine()) != null) {

            if (l.length() == 1) {
                vertices[vIndex++] = l;
            } 
            else {
                String[] vertices = l.split(" ");
                int sourceIndex = Arrays.asList(this.vertices).indexOf(vertices[0]);
                int destinationIndex = Arrays.asList(this.vertices).indexOf(vertices[1]);
                adjacencyMatrix[sourceIndex][destinationIndex] = 1;
                edges[eIndex] = vertices[0] + "-" + vertices[1];
                incidenceMatrix[sourceIndex][eIndex] = 1;
                eIndex++;
            }
        }
        br.close();
    }

    public void depthFirstTraversal(int startVertex) {
        boolean[] visited = new boolean[vertexCount];
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        StringBuilder traversalResult = new StringBuilder();

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();

            if (!visited[currentVertex]) {
                visited[currentVertex] = true;
                traversalResult.append(vertices[currentVertex]).append("-");

                List<Integer> neighbors = getNeighbors(currentVertex);
                Collections.reverse(neighbors);
                for (int neighbor : neighbors) {
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }

        if (traversalResult.length() > 0) {
            traversalResult.setLength(traversalResult.length() - 1);
        }
        System.out.println(traversalResult.toString());
    }

    private List<Integer> getNeighbors(int vertex) {
        List<Integer> neighbors = new ArrayList<>();
        for (int i = 0; i < vertexCount; i++) {
            if (adjacencyMatrix[vertex][i] == 1) {
                neighbors.add(i);
            }
        }
        return neighbors;
    }
}
