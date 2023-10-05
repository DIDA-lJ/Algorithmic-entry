package com.qinyao.map;

import java.util.HashMap;

/**
 * @ClassName MyHashMap
 * @Description 自定义实现 HashMap，使用 链表 + 数组的方式实现
 * @Version 1.0.0
 * @Author LinQi
 * @Date 2023/10/02
 */
public class MyHashMap<K, V> {

    /**
     * HashMap 链表节点类
     *
     * @param <K> key 键
     * @param <V> value 值
     */
    private class Node<K, V> {
        // HashMap节点 键
        private K key;
        // HashMap节点 值
        private V value;

        // 后继节点
        private Node<K, V> next;

        /**
         * 构造方法
         *
         * @param key   节点的键
         * @param value 节点的值
         */
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * 构造方法
         *
         * @param key   节点的键
         * @param value 节点的值
         * @param next  节点的后继
         */
        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 成员变量：默认容量
     */
    private final int DEFAULT_CAPACITY = 16;

    /**
     * 成员变量：这里不使用 double , 使用float计算，在转换成整数的时候会进行舍入
     */
    private final float LOAD_FACTOR = 0.75f;

    /**
     * HashMap 的元素个数
     */
    private int size;

    /**
     * 桶数组
     */
    Node<K, V>[] buckets;

    /**
     * 无参构造器，设置桶数组的默认容量为 16
     */
    public MyHashMap() {
        buckets = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * 有参构造器，初始化 HashMap 的容量
     *
     * @param capacity HashMap 初始化容量
     */
    public MyHashMap(int capacity) {
        buckets = new Node[capacity];
        size = 0;
    }

    /**
     * 返回 HashMap 的元素个数
     *
     * @return HashMap 的元素个数
     */
    public int size() {
        return size;
    }


    /**
     * 哈希函数，获取地址
     *
     * @param key 存储的 key
     * @return 存储位置的缩影
     */
    private int getIndex(K key, int length) {
        //获取hash code
        int hashCode = key.hashCode();
        //和桶数组长度取余
        int index = hashCode % length;
        // 获取到插入位置的索引
        return Math.abs(index);
    }

    /**
     * put方法
     *
     * @param key
     * @param value
     * @return
     */
    public void put(K key, V value) {
        //判断是否需要进行扩容
        if (size >= buckets.length * LOAD_FACTOR) {
            resize();
        }
        // 将元素插入对应的桶数组
        putVal(key, value, buckets);
    }

    /**
     * 扩容方法
     */
    private void resize() {
        //创建一个原本容量两倍的桶数组
        Node<K, V>[] newBuckets = new Node[buckets.length * 2];
        //将当前元素重新散列到新的桶数组
        rehash(newBuckets);
        //将数组进行拷贝
        buckets = newBuckets;
    }

    /**
     * 重新散列当前元素
     *
     * @param newBuckets 扩容后的桶数组，这里获取原本桶数组的大小，进行再哈希取余
     */
    private void rehash(Node<K, V>[] newBuckets) {
        //map大小重新计算
        size = 0;
        //将旧的桶数组的元素全部刷到新的桶数组里
        for (int i = 0; i < buckets.length; i++) {
            //数组元素为空，直接跳过
            if (buckets[i] == null) {
                continue;
            }
            Node<K, V> node = buckets[i];
            while (node != null) {
                //将元素放入新数组
                putVal(node.key, node.value, newBuckets);
                node = node.next;
            }
        }
    }

    /**
     * 将元素存入指定的node数组
     *
     * @param key   存储的 key
     * @param value 存储的 value
     * @param table 存储的桶数组
     */
    private void putVal(K key, V value, Node<K, V>[] table) {
        //获取位置
        int index = getIndex(key, table.length);
        Node node = table[index];
        //插入的位置为空
        if (node == null) {
            table[index] = new Node<>(key, value);
            size++;
            return;
        }
        //插入位置不为空，说明发生冲突，使用链地址法,遍历链表
        while (node != null) {
            //如果key相同，就覆盖掉
            if ((node.key.hashCode() == key.hashCode()) && ((node.key == key) || node.key.equals(key))) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        //当前key不在链表中，插入链表头部
        Node newNode = new Node(key, value, table[index]);
        table[index] = newNode;
        size++;
    }

    /**
     * 获取元素
     *
     * @param key
     * @return
     */
    public V get(K key) {
        //获取key对应的地址
        int index = getIndex(key, buckets.length);
        if (buckets[index] == null) {
            return null;
        }
        Node<K, V> node = buckets[index];
        //查找链表，当链表节点不为空的时候，继续查找
        while (node != null) {
            if ((node.key.hashCode() == key.hashCode()) && (node.key == key || node.key.equals(key))) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }
}
