package by_topic.DFS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class GraphTraversal_DFS {
    private HashMap<Integer, Node> nodeLookUp = new HashMap<>();
    private static class Node {
        private int id;
        LinkedList<Node> adjList = new LinkedList<>();
        public Node(int id) {
            this.id = id;
        }
    }
    private Node getNode(int id) {
        if (nodeLookUp.containsKey(id))
            return nodeLookUp.get(id);
        Node node = new Node(id);
        nodeLookUp.put(id, node);
        return node;
    }
    public void addEdge(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        s.adjList.add(d);
    }

    public boolean hasPathDFS(int source, int destination) {
        Set<Integer> visited = new HashSet<>();
        return hasPathDFS(getNode(source), getNode(destination), visited);
    }

    private boolean hasPathDFS(Node source, Node destination, Set<Integer> visited) {
        if (visited.contains(source)) {
            return false;
        }
        visited.add(source.id);
        if (source == destination) {
            return true;
        }
        for (Node child : source.adjList) {
            if (hasPathDFS(child, destination, visited))
                return true;
        }
        return false;
    }
    /*

        1 ->2->3
        \ /  \
         4    5
    */
    public static void main(String[] args) {
        GraphTraversal_DFS obj = new GraphTraversal_DFS();
        obj.addEdge(1,2);
        obj.addEdge(1,4);
        obj.addEdge(2,3);
        obj.addEdge(2,5);
        obj.addEdge(7,8);
        System.out.println("Has Path Between 1 and 5 :: " + obj.hasPathDFS(1, 5));
        System.out.println("Has Path Between 1 and 8 :: " + obj.hasPathDFS(1, 8));

    }
}
