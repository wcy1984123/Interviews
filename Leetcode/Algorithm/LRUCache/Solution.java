package LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * Project: Interviews
 * Package: LRUCache
 * Date: 19/Mar/2015
 * Time: 09:21
 * System Time: 9:21 AM
 */

/*
    Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

    get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
    set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */

public class Solution {

    Map<Integer, DoubleLinkedNode> map;
    DoubleLinkedNode head;
    DoubleLinkedNode tail;
    int len;
    int capacity;

    public Solution(int capacity) {
        len = 0;
        head = tail = null;
        this.capacity = capacity;
        map = new HashMap<Integer, DoubleLinkedNode>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DoubleLinkedNode node = map.get(key);
            removeNode(node);
            setHead(node);
            return node.val;
        }

        return -1;
    }

    public void removeNode(DoubleLinkedNode node) {
        DoubleLinkedNode prev = node.prev;
        DoubleLinkedNode next = node.next;
        node.prev = null;
        node.next = null;

        if (prev != null) {
            prev.next = next;
        } else {
            head = next;
        }

        if (next != null) {
            next.prev = prev;
        } else {
            tail = prev;
        }
    }

    public void setHead(DoubleLinkedNode node) {
        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }

        head = node;

        if (tail == null) {
            tail = node;
        }

    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            DoubleLinkedNode node = map.get(key);
            node.val = value;
            removeNode(node);
            setHead(node);
        } else {
            DoubleLinkedNode node = new DoubleLinkedNode(key, value);
            if (len < capacity) {
                setHead(node);
                map.put(key, node);
                len++;
            } else {
                map.remove(tail.key);
                tail = tail.prev;
                if (tail != null) tail.next = null;
                setHead(node);
                map.put(key, node);

            }
        }
    }
}

class DoubleLinkedNode{
    DoubleLinkedNode prev;
    DoubleLinkedNode next;
    int key;
    int val;

    DoubleLinkedNode(int key, int val) {
        this.key = key;
        this.val = val;
        prev = next = null;
    }
}
