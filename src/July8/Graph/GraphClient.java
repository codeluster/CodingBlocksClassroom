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

        graph.addEdge("A", "B", 1);
        graph.addEdge("B", "C", 2);
        graph.addEdge("C", "D", 4);
        graph.addEdge("D", "A", 5);
        graph.addEdge("D", "E", 15);
        graph.addEdge("E", "F", 2);
        graph.addEdge("E", "G", 5);
        graph.addEdge("F", "G", 6);

//        graph.removeVertex("D");

//        System.out.println(graph.hasPath("A", "F"));
//        graph.BinaryFirstTraversal();
//        graph.DepthFirstTraversal();

//        System.out.println(graph.isConnected());
//        System.out.println(graph.isCyclic());
//        System.out.println(graph.isTree());
//        System.out.println(graph.getCyclicComponents());

        graph.MSTPrims().display();

    }

}
