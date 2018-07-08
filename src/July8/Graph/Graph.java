package July8.Graph;

import java.util.HashMap;

public class Graph {

    private class Vertex {
        HashMap<String, Integer> neighbours = new HashMap<>();
    }

    private HashMap<String, Vertex> graph = new HashMap<>();

    public int numVertex() {
        return graph.size();
    }

    public boolean containsVertex(String query) {
        return graph.containsKey(query);
    }

    public void addVertex(String item) {
        graph.put(item, new Vertex());
    }

    public void removeVertex(String vtx) {
        if (!this.containsVertex(vtx)) return;
        for (String neighbour : graph.get(vtx).neighbours.keySet()) {
            graph.get(neighbour).neighbours.remove(vtx);
        }
        graph.remove(vtx);
    }

    public int numEdges() {
        int sum = 0;
        for (String key : graph.keySet()) {
            Vertex vertex = graph.get(key);
            for (String neighbour : vertex.neighbours.keySet()) {
                sum++;
            }
        }
        return sum / 2;
    }

    public boolean containsEdge(String vtx1, String vtx2) {
        return graph.containsKey(vtx1) && graph.containsKey(vtx2) && graph.get(vtx1).neighbours.containsKey(vtx2);
    }

    public void addEdge(String vtx1, String vtx2, int cost) {
        if (this.containsEdge(vtx1, vtx2)) return;

        graph.get(vtx1).neighbours.put(vtx2, cost);
        graph.get(vtx2).neighbours.put(vtx1, cost);

    }

    public void removeEdge(String vtx1, String vtx2) {

        if (!this.containsEdge(vtx1, vtx2)) return;

        graph.get(vtx1).neighbours.remove(vtx2);
        graph.get(vtx2).neighbours.remove(vtx1);
    }

    public void display() {
        System.out.println("------------------");
        for (String key : graph.keySet()) {
            Vertex vertex = graph.get(key);
            System.out.print(key + " --> ");
            for (String neighbour : vertex.neighbours.keySet()) {
                System.out.print(neighbour + "\t");
            }
            System.out.println();
        }
        System.out.println("------------------");
    }

    public boolean hasPath(String origin, String destination) {
        return hasPath(origin, destination, new HashMap<>());
    }

    private boolean hasPath(String origin, String destination, HashMap<String, Boolean> processed) {

        if (origin.equals(destination) || this.graph.get(origin).neighbours.containsKey(destination)) {
            return true;
        }

        processed.put(origin, true);

        for (String neighbour : this.graph.get(origin).neighbours.keySet()) {
            if (!processed.containsKey(neighbour) && this.hasPath(neighbour, destination, processed)) {
                return true;
            }
        }

        return false;
    }

}
