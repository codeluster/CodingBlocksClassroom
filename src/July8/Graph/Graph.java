package July8.Graph;

import July1.Heap.Heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph {

    private class Vertex {
        HashMap<String, Integer> neighbours = new HashMap<>();
    }

    private HashMap<String, Vertex> vertices = new HashMap<>();

    public int numVertex() {
        return vertices.size();
    }

    public boolean containsVertex(String query) {
        return vertices.containsKey(query);
    }

    public void addVertex(String item) {
        vertices.put(item, new Vertex());
    }

    public void removeVertex(String vertex) {
        if (!this.containsVertex(vertex)) return;
        for (String neighbour : vertices.get(vertex).neighbours.keySet()) {
            vertices.get(neighbour).neighbours.remove(vertex);
        }
        vertices.remove(vertex);
    }

    public int numEdges() {
        int sum = 0;
        for (String key : vertices.keySet()) {
            Vertex vertex = vertices.get(key);
            for (String neighbour : vertex.neighbours.keySet()) {
                sum++;
            }
        }
        return sum / 2;
    }

    public boolean containsEdge(String vertex1, String vertex2) {
        return vertices.containsKey(vertex1) && vertices.containsKey(vertex2) && vertices.get(vertex1).neighbours.containsKey(vertex2);
    }

    public void addEdge(String vertex1, String vertex2, int cost) {
        if (this.containsEdge(vertex1, vertex2)) return;

        vertices.get(vertex1).neighbours.put(vertex2, cost);
        vertices.get(vertex2).neighbours.put(vertex1, cost);

    }

    public void removeEdge(String vertex1, String vertex2) {

        if (!this.containsEdge(vertex1, vertex2)) return;

        vertices.get(vertex1).neighbours.remove(vertex2);
        vertices.get(vertex2).neighbours.remove(vertex1);
    }

    public void display() {
        System.out.println("------------------");
        for (String key : vertices.keySet()) {
            Vertex vertex = vertices.get(key);
            System.out.print(key + " --> ");
            for (String neighbour : vertex.neighbours.keySet()) {
                System.out.print(neighbour + " ");
            }
            System.out.println();
        }
        System.out.println("------------------");
    }

    public boolean hasPath(String origin, String destination) {
        return hasPath(origin, destination, new HashMap<>());
    }

    private boolean hasPath(String origin, String destination, HashMap<String, Boolean> processed) {

        if (origin.equals(destination) || this.vertices.get(origin).neighbours.containsKey(destination)) {
            return true;
        }

        processed.put(origin, true);

        for (String neighbour : this.vertices.get(origin).neighbours.keySet()) {
            if (!processed.containsKey(neighbour) && this.hasPath(neighbour, destination, processed)) {
                return true;
            }
        }

        return false;
    }

    private class Pair {
        String vertex_name;
        String path_so_far;
        Vertex vertex;
    }

    public boolean BreadthFirstSearch(String origin, String destination) {
        return BreadthFirstSearch(origin, destination, new HashMap<>());
    }

    // Breadth First Search first searches in the nodes at a particular level before searching the child level
    // Therefore useful to find the shortest path
    private boolean BreadthFirstSearch(String origin, String destination, HashMap<String, Boolean> processed) {
        LinkedList<Pair> queue = new LinkedList<>();

        Pair pair = new Pair();
        pair.vertex_name = origin;
        pair.path_so_far = origin;
        pair.vertex = this.vertices.get(origin);

        queue.addLast(pair);

        while (!queue.isEmpty()) {

            Pair removedPair = queue.removeFirst();

            if (processed.containsKey(removedPair.vertex_name)) continue;

            if (removedPair.vertex_name.equals(destination) || removedPair.vertex.neighbours.containsKey(destination)) {
                System.out.println(removedPair.path_so_far + destination);
                return true;
            }

            processed.put(removedPair.vertex_name, true);

            Pair newPair = new Pair();

            for (String neighbour : removedPair.vertex.neighbours.keySet()) {
                if (!processed.containsKey(neighbour)) {
                    newPair.vertex_name = neighbour;
                    newPair.path_so_far = removedPair.path_so_far + neighbour;
                    newPair.vertex = this.vertices.get(neighbour);
                    queue.addLast(newPair);
                }
            }

        }

        return false;

    }

    public boolean DepthFirstSearch(String origin, String destination) {
        return DepthFirstSearch(origin, destination, new HashMap<>());
    }

    // In Depth First Search one node is picked and is traversed completely before sibling node
    // Can return a path of any length
    private boolean DepthFirstSearch(String origin, String destination, HashMap<String, Boolean> processed) {
        LinkedList<Pair> stack = new LinkedList<>();

        Pair pair = new Pair();
        pair.vertex_name = origin;
        pair.path_so_far = origin;
        pair.vertex = this.vertices.get(origin);

        stack.addFirst(pair);

        while (!stack.isEmpty()) {

            Pair removedPair = stack.removeFirst();

            if (processed.containsKey(removedPair.vertex_name)) continue;

            if (removedPair.vertex_name.equals(destination) || removedPair.vertex.neighbours.containsKey(destination)) {
                System.out.println(removedPair.path_so_far + destination);
                return true;
            }

            processed.put(removedPair.vertex_name, true);

            Pair newPair = new Pair();

            for (String neighbour : removedPair.vertex.neighbours.keySet()) {
                if (!processed.containsKey(neighbour)) {
                    newPair.vertex_name = neighbour;
                    newPair.path_so_far = removedPair.path_so_far + neighbour;
                    newPair.vertex = this.vertices.get(neighbour);
                    stack.addFirst(newPair);
                }
            }

        }

        return false;

    }

    public void BinaryFirstTraversal() {

        LinkedList<Pair> queue = new LinkedList<>();
        HashMap<String, Boolean> processed = new HashMap<>();

        for (String key : this.vertices.keySet()) {

            // If passed this condition second time there are disjoint components in the forest!
            if (processed.containsKey(key)) continue;

            Pair pair = new Pair();
            pair.vertex_name = key;
            pair.path_so_far = key;
            pair.vertex = this.vertices.get(key);

            queue.addLast(pair);

            while (!queue.isEmpty()) {

                Pair removedPair = queue.removeFirst();

                if (processed.containsKey(removedPair.vertex_name)) {
                    continue;
                } else {
                    processed.put(removedPair.vertex_name, true);
                }

                System.out.println(removedPair.vertex_name + " via " + removedPair.path_so_far);


                for (String neighbour : removedPair.vertex.neighbours.keySet()) {

                    // Put all children in the queue
                    if (!processed.containsKey(neighbour)) {
                        Pair newPair = new Pair();
                        newPair.vertex_name = neighbour;
                        newPair.path_so_far = removedPair.path_so_far + neighbour;
                        newPair.vertex = this.vertices.get(neighbour);
                        queue.addLast(newPair);
                    }

                }

            }
        }

    }

    public void DepthFirstTraversal() {

        LinkedList<Pair> stack = new LinkedList<>();
        HashMap<String, Boolean> processed = new HashMap<>();

        for (String key : this.vertices.keySet()) {

            // If passed this condition second time there are disjoint components in the forest!
            if (processed.containsKey(key)) continue;

            Pair pair = new Pair();
            pair.vertex_name = key;
            pair.path_so_far = key;
            pair.vertex = this.vertices.get(key);

            stack.addFirst(pair);

            while (!stack.isEmpty()) {

                Pair removedPair = stack.removeFirst();

                if (processed.containsKey(removedPair.vertex_name)) {
                    continue;
                } else {
                    processed.put(removedPair.vertex_name, true);
                }

                System.out.println(removedPair.vertex_name + " via " + removedPair.path_so_far);


                for (String neighbour : removedPair.vertex.neighbours.keySet()) {

                    // Put all children in the queue
                    if (!processed.containsKey(neighbour)) {
                        Pair newPair = new Pair();
                        newPair.vertex_name = neighbour;
                        newPair.path_so_far = removedPair.path_so_far + neighbour;
                        newPair.vertex = this.vertices.get(neighbour);
                        stack.addFirst(newPair);
                    }

                }

            }
        }

    }

    public boolean isConnected() {

        LinkedList<Pair> queue = new LinkedList<>();
        HashMap<String, Boolean> processed = new HashMap<>();

        int counter = 1;

        for (String key : this.vertices.keySet()) {

            // If passed this condition second time there are disjoint components in the forest!
            if (processed.containsKey(key)) continue;
            counter--;

            Pair pair = new Pair();
            pair.vertex_name = key;
            pair.path_so_far = key;
            pair.vertex = this.vertices.get(key);

            queue.addLast(pair);

            while (!queue.isEmpty()) {

                Pair removedPair = queue.removeFirst();

                if (processed.containsKey(removedPair.vertex_name)) {
                    continue;
                } else {
                    processed.put(removedPair.vertex_name, true);
                }

                for (String neighbour : removedPair.vertex.neighbours.keySet()) {

                    // Put all children in the queue
                    if (!processed.containsKey(neighbour)) {
                        Pair newPair = new Pair();
                        newPair.vertex_name = neighbour;
                        newPair.path_so_far = removedPair.path_so_far + neighbour;
                        newPair.vertex = this.vertices.get(neighbour);
                        queue.addLast(newPair);
                    }

                }

            }
        }

        return counter >= 0;
    }

    public boolean isCyclic() {

        LinkedList<Pair> queue = new LinkedList<>();
        HashMap<String, Boolean> processed = new HashMap<>();

        int flag = 0;

        for (String key : this.vertices.keySet()) {

            // If passed this condition second time there are disjoint components in the forest!
            if (processed.containsKey(key)) continue;

            Pair pair = new Pair();
            pair.vertex_name = key;
            pair.path_so_far = key;
            pair.vertex = this.vertices.get(key);

            queue.addLast(pair);

            while (!queue.isEmpty()) {

                Pair removedPair = queue.removeFirst();

                if (processed.containsKey(removedPair.vertex_name)) {
                    flag++;
                    continue;
                } else {
                    processed.put(removedPair.vertex_name, true);
                }


                for (String neighbour : removedPair.vertex.neighbours.keySet()) {

                    // Put all children in the queue
                    if (!processed.containsKey(neighbour)) {
                        Pair newPair = new Pair();
                        newPair.vertex_name = neighbour;
                        newPair.path_so_far = removedPair.path_so_far + neighbour;
                        newPair.vertex = this.vertices.get(neighbour);
                        queue.addLast(newPair);
                    }

                }

            }
        }
        return flag >= 1;
    }

    public ArrayList<ArrayList<String>> getCyclicComponents() {

        ArrayList<ArrayList<String>> mList = new ArrayList<>();

        LinkedList<Pair> queue = new LinkedList<>();
        HashMap<String, Boolean> processed = new HashMap<>();

        for (String key : this.vertices.keySet()) {

            // If passed this condition second time there are disjoint components in the forest!
            if (processed.containsKey(key)) continue;
            ArrayList<String> arrayList = new ArrayList<>();

            Pair pair = new Pair();
            pair.vertex_name = key;
            pair.path_so_far = key;
            pair.vertex = this.vertices.get(key);

            queue.addLast(pair);

            while (!queue.isEmpty()) {

                Pair removedPair = queue.removeFirst();

                if (processed.containsKey(removedPair.vertex_name)) {
                    continue;
                } else {
                    arrayList.add(removedPair.vertex_name);
                    processed.put(removedPair.vertex_name, true);
                }

                for (String neighbour : removedPair.vertex.neighbours.keySet()) {

                    // Put all children in the queue
                    if (!processed.containsKey(neighbour)) {
                        Pair newPair = new Pair();
                        newPair.vertex_name = neighbour;
                        newPair.path_so_far = removedPair.path_so_far + neighbour;
                        newPair.vertex = this.vertices.get(neighbour);
                        queue.addLast(newPair);
                    }

                }

            }

            mList.add(arrayList);

        }

        return mList;
    }

    public boolean isTree() {
        return this.isConnected() && !this.isCyclic();
    }

    public Graph MSTPrims() {

        Heap<PrimsPair> heap = new Heap<PrimsPair>();
        HashMap<String, PrimsPair> processed = new HashMap<>();
        Graph minimumSpanningTree = new Graph();

        // Make a pair of every vertex
        for (String key : vertices.keySet()) {

            PrimsPair pair = new PrimsPair();
            pair.vertex = vertices.get(key);
            pair.vName = key;
            pair.cost = Integer.MAX_VALUE;
            pair.acquired = null;

            // Put pair in heap and in processed HashMap
            heap.insert(pair);
            processed.put(key, pair);
        }

        // Work till the heap is not empty
        while (!heap.isEmpty()) {

            // Remove pair from heap and from graph
            PrimsPair removedPair = heap.remove();
            processed.remove(removedPair.vName);

            minimumSpanningTree.addVertex(removedPair.vName);

            if (removedPair.acquired != null) {
                minimumSpanningTree.addEdge(removedPair.vName, removedPair.acquired, removedPair.cost);
            }

            // Update neighbours present in the heap
            for (String neighbour : removedPair.vertex.neighbours.keySet()) {

                if (processed.containsKey(neighbour)) {

                    int oldCost = processed.get(neighbour).cost;
                    int newCost = vertices.get(removedPair.vName).neighbours.get(neighbour);

                    if (newCost < oldCost) {
                        processed.get(neighbour).cost = newCost;
                        processed.get(neighbour).acquired = removedPair.vName;
                        heap.priorityUpdate(processed.get(neighbour));
                    }

                }

            }

        }


        return minimumSpanningTree;
    }

    private class PrimsPair implements Comparable<PrimsPair> {

        Vertex vertex;
        String vName;
        int cost;
        String acquired;

        @Override
        public int compareTo(PrimsPair o) {
            return o.cost - this.cost;
        }
    }

}
