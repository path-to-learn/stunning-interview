package by_topic.BFS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GraphTraversal_BFS {
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

    public boolean hasPathBFS(int source, int destination) {
        return hasPathBFS(getNode(source), getNode(destination));
    }

    private boolean hasPathBFS(Node source, Node destination) {
        Set<Integer> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(source);
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if (node == destination)
                return true;
            if (visited.contains(node.id))
                continue;
            visited.add(node.id);
            for (Node nn : node.adjList) {
                queue.add(nn);
            }
        }
        return false;
    }
    /*

        1 -> 2 -> 3
         \ /   \
          4     5
    */
    public static void main(String[] args) {
        GraphTraversal_BFS obj = new GraphTraversal_BFS();
        obj.addEdge(1,2);
        obj.addEdge(1,4);
        obj.addEdge(2,3);
        obj.addEdge(2,5);
        obj.addEdge(7,8);
        System.out.println("Has Path Between 1 and 5 :: " + obj.hasPathBFS(1, 5));
        System.out.println("Has Path Between 1 and 8 :: " + obj.hasPathBFS(1, 8));
    }
}
