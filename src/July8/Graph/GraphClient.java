package July8.Graph;

public class GraphClient {

    public static void main(String[] a0op2) {

        Graph graph = new Graph();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdge("A", "B", 5);
        graph.addEdge("B", "C", 5);
        graph.addEdge("C", "D", 8);
        graph.addEdge("D", "A", 20);
//        graph.addEdge("D", "E", 60);
        graph.addEdge("E", "F", 70);
        graph.addEdge("E", "G", 17);
        graph.addEdge("F", "G", 10);

//        graph.removeVertex("D");

//        System.out.println(graph.hasPath("A", "F"));
//        graph.BinaryFirstTraversal();
//        graph.DepthFirstTraversal();

        System.out.println(graph.isConnected());
        System.out.println(graph.isCyclic());
        System.out.println(graph.isTree());
        System.out.println(graph.getCyclicComponents());
    }

}
