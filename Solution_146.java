/*
146. LRU缓存机制
运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

进阶:
你是否可以在 O(1) 时间复杂度内完成这两种操作？

示例:

LRUCache cache = new LRUCache( 2 ); //缓存容量

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
 */
/*
["LRUCache","get","put","get","put","put","get","get"]
[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
 */
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2); //缓存容量
        System.out.print("cache.get(2): ");
        System.out.println(cache.get(2));
        System.out.println("cache.put(2,6);");
        cache.put(2, 6);
        System.out.print("cache.get(1): ");
        System.out.println(cache.get(1));
        System.out.println("cache.put(1,5);");
        cache.put(1, 5);
        System.out.println("cache.put(1,2);");
        cache.put(1, 2);
        System.out.print("cache.get(1): ");
        System.out.println(cache.get(1));
        System.out.print("cache.get(2): ");
        System.out.println(cache.get(2));
    }

}

class DeLinkedList {
    int val;
    int key;
    DeLinkedList next;
    DeLinkedList pre;

    public DeLinkedList(int x, int y) {
        key = x;
        val = y;
    }
}

class LRUCache {

    int count = 0;
    int max;
    DeLinkedList head = new DeLinkedList(-1, -1);
    DeLinkedList tail = new DeLinkedList(-1, -1);
    Map<Integer, DeLinkedList> hash = new HashMap<>();

    public LRUCache(int capacity) {
        max = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DeLinkedList cur = hash.getOrDefault(key, head);
        if (cur.val != -1) {
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre;
            cur.next = head.next;
            head.next.pre = cur;
            head.next = cur;
            cur.pre = head;
        }
        return cur.val;
    }

    public void put(int key, int value) {
        if (hash.containsKey(key)) {
            DeLinkedList p = hash.get(key);
            p.val = value;
            if (p.pre != head) {
                p.pre.next = p.next;
                p.next.pre = p.pre;
                p.next = head.next;
                head.next.pre = p;
                head.next = p;
                p.pre = head;
            }
        } else {
            DeLinkedList n = new DeLinkedList(key, value);
            hash.put(key, n);
            if (count >= max) {
                DeLinkedList t = tail.pre;
                tail.pre.pre.next = tail;
                tail.pre = tail.pre.pre;
                hash.remove(t.key, t);
                count--;
            }
            n.next = head.next;
            head.next.pre = n;
            head.next = n;
            n.pre = head;
            count++;
        }
    }
}