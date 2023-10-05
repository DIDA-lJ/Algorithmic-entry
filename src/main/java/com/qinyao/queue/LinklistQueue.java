package com.qinyao.queue;

import org.w3c.dom.Node;

import java.util.LinkedList;

/**
 * @ClassName LinkQueue
 * @Description
 * @Version 1.0.0
 * @Author LinQi
 * @Date 2023/09/10
 */
public class LinklistQueue<T> {
    private Node rear, front;
    private int size;

    public LinklistQueue() {
        this.rear = new Node(0);
        this.front = new Node(0);
    }

    /**
     * 入队
     */
    public void push(T data) {
        Node newNode = new Node(data);
        Node temp = front;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        rear = newNode;
        size++;
    }

    /**
     * 出队
     *
     * @return
     */
    public T pull() {
        if (front.next == null) {
            System.out.println("队列为空，没有要出队的元素");
        }
        Node firstNode = front.next;
        front.next = firstNode.next;
        size--;
        return (T) firstNode.data;
    }

    public void printQueue() {
        Node node = front.next;
        while (node != null) {
            System.out.print(node.data + "\t");
            node = node.next;
        }
    }


    private class Node<T> {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
