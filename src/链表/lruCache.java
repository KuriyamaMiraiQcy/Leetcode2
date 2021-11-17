package 链表;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer, Node> map = new HashMap<>();
    DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = doubleLinkedList.remove(map.get(key));
            doubleLinkedList.insert(n, doubleLinkedList.head);
            return map.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node n = doubleLinkedList.remove(map.get(key));
            n.val = value;
            doubleLinkedList.insert(n, doubleLinkedList.head);
            return;
        }
        Node n = new Node(value, key);
        map.put(key, n);
        if (doubleLinkedList.getCount() >= this.capacity) {
            map.remove(doubleLinkedList.head.prev.key);
            doubleLinkedList.remove(doubleLinkedList.head.prev);
        }
        doubleLinkedList.insert(n, doubleLinkedList.head);
    }
    class Node {
        int val;
        int key;
        Node prev;
        Node next;
        Node(int val, int key) {
            this.val = val;
            this.key = key;
        }
    }

    class DoubleLinkedList {
        int count = 0;

        Node head;
        DoubleLinkedList() {
            head  = new Node(-1, - 1);
            head.next = head;
            head.prev = head;
        }

        int getCount() {
            return this.count;
        }

        void insert(Node n, Node location) {
            n.next = location.next;
            location.next = n;
            n.prev = location;
            n.next.prev = n;
            count++;
        }

        Node remove(Node n) {
            n.prev.next = n.next;
            n.next.prev = n.prev;
            count--;
            return n;
        }
    }
}
