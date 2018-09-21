package cn.croff.hash;

import java.util.HashMap;

/**
 * 146. LRU Cache
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * Example:
 * LRUCache cache = new LRUCache(2); // capacity of 2
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);    // returns 1
 * cache.put(3,3);  // evicts key 2
 * cache.get(2);    // returns -1 (not found)
 * cache.put(4,4);  // evicts key 1
 * cache.get(1);    // returns -1 (not found)
 * cache.get(3);    // returns 3
 * cache.get(4);    // returns 4
 */
public class LRUCache {

    /*
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */

    private int capacity;
    private HashMap<Integer, LRUCacheNode> cacheMap;
    private LRUCacheNode head;

    public LRUCache(int capacity) {
        // 核心设计思路：Hash表+循环双链表
        this.capacity = capacity;
        cacheMap = new HashMap<>((int) (capacity / 0.75));
        // 链表头只起标志作用，不用来实际存储
        head = new LRUCacheNode(-1, -1);
        head.previous = head.next = head;
    }

    public int get(int key) {
        if (cacheMap.containsKey(key)) {
            // 如果Hash表中该节点存在，则把该节点移到链表尾部
            LRUCacheNode node = cacheMap.get(key);
            moveToTail(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            // 如果Hash表中该节点存在，则需要先移除该节点在Hash表和链表中的记录
            deleteNode(cacheMap.get(key));
        }
        if (cacheMap.size() >= capacity) {
            // 如果达到容量上限，需要移除最近最少使用的节点：链表头的下一个节点
            deleteNode(head.next);
        }
        // 插入新节点并将它移动到链表尾部
        LRUCacheNode node = new LRUCacheNode(key, value);
        moveToTail(node);
        cacheMap.put(key, node);
    }

    /**
     * 将指定节点移动到链表尾部
     *
     * @param node 指定节点
     */
    private void moveToTail(LRUCacheNode node) {
        // 将指定节点从链表原位置删除
        if (node.previous != null) node.previous.next = node.next;
        if (node.next != null) node.next.previous = node.previous;
        // 将指定节点插入链表尾部
        LRUCacheNode tail = head.previous;
        tail.next = node;
        head.previous = node;
        node.next = head;
        node.previous = tail;
    }

    /**
     * 删除指定节点在Hash表和链表中的记录
     *
     * @param node 指定节点
     */
    private void deleteNode(LRUCacheNode node) {
        // 删除在链表中的记录
        node.previous.next = node.next;
        node.next.previous = node.previous;
        // 删除在Hash表中的记录
        cacheMap.remove(node.key, node);
    }

    /**
     * Hash表中value存的对象，包括key、value、链表前驱节点和后继节点
     */
    private class LRUCacheNode {

        int key;
        int value;
        LRUCacheNode previous;
        LRUCacheNode next;

        public LRUCacheNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
