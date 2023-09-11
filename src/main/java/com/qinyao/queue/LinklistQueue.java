package com.qinyao.queue;

import org.w3c.dom.Node;

/**
 * @ClassName LinkQueue
 * @Description
 * @Version 1.0.0
 * @Author LinQi
 * @Date 2023/09/10
 */
public class LinklistQueue<T> {
    private Node front;
    private Node rear;
    private int size;

    public LinklistQueue() {
        this.front = new Node(0);
        this.rear = new Node(0);
    }

    /**
     * 入队
     */
    public  void push(int value){
        Node newNode = new Node(value);
        Node temp = front;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        rear = newNode;
        size++;
    }

    /**
     * 出队
     */
    public T pull(){
        if(front.next == null){
            System.out.println("队列为空，没有要出队的元素");
        }
        Node firstNode = front.next;
        front.next = firstNode.next;
        size--;
        return (T) firstNode.data;
    }

    /**
     * 遍历队列
     */
    public void traverse(){
        if(front.next == null){
            System.out.println("队列为空");
            return;
        }
        Node temp = front.next;
        while(temp != null){
            System.out.println(temp.data + "\t");
            temp = temp.next;
        }
    }


    private class Node<T> {
        T data;
        Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(T data) {
            this.data = data;
        }
    }
}
