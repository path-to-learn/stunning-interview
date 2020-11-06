package by_topic.Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Design an in-memory LRU cache
 */
public class LRUCache {
    private class Node {
        Node prev;
        Node next;
        int val;
        int key;
    }
    int capacity = 0, count = 0;
    Map<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node();

        head.prev = null;
        tail = new Node();
        tail.next = null;

        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        addToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node();
            node.key = key;
            node.val = value;
            map.put(key, node);
            addNode(node);

            count++;
            if (count > capacity) {
                Node tail = removeTail();
                map.remove(tail.key);
                count--;
            }
        } else {
            node.val = value;
            addToHead(node);
        }
    }

    private void addToHead(Node node) {
        remove(node);
        addNode(node);
    }

    private void addNode(Node node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private Node removeTail() {
        Node node = tail.prev;
        remove(node);
        return node;
    }

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(1,1);
        System.out.println(obj.get(1));
        obj.put(2,2);
        System.out.println(obj.get(2));
        obj.put(2,2);
        System.out.println(obj.get(3));
        System.out.println(obj.get(1));

        List<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(list.size());
        Random ran = new Random(list.size());
        ran.nextInt();
    }
}
