import java.io.*;

public class MainApp{
    public static void main(String[] args){
        try{
            Matrix graph = new Matrix();
            System.out.println("Adjacency List:");
            graph.readGraphFromFile("graph.txt");
            graph.displayAdjacencyList();
            System.out.println();
            System.out.println("Incidence Matrix:");
            graph.displayIncidenceMatrix();

            System.out.println();

            System.out.print("Depth-First Traversal: ");
            Output output = new Output();
            output.countVandE("graph.txt");
            output.readGraphFile("graph.txt");
            output.depthFirstTraversal(0);
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}