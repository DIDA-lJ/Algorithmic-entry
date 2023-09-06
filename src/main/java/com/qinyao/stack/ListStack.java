package com.qinyao.stack;

/**
 * @ClassName ListStack
 * @Description
 * @Version 1.0.0
 * @Author LinQi
 * @Date 2023/09/06
 */
public class ListStack<T> {
    private class Node<T> {
        public T data;
        public Node next;
    }

    public Node<T> head;

    /**
     * 构造函数初始化指针
     */
    public ListStack() {
        head = null;
    }

    /**
     * 入栈
     *
     * @param t
     */
    public void push(T t) {
        if (t == null) {
            System.out.println("插入元素不能为空");
        }
        // 如果头结点为空
        if (head == null) {
            head = new Node<T>();
            head.data = t;
            head.next = null;
        } else {
            // 创建一个临时节点，用于存放头结点
            Node<T> temp = head;
            head = new Node<>();
            head.data = t;
            head.next = temp;
        }
        System.out.println("数据 " + t +" 插入成功.");
    }

    /**
     * 出栈
     */
    public T pop() {
        if (head == null) {
            System.out.println("头结点为空，返回元素为 null .");
            return null;
        }
        T temp = head.data;
        head = head.next;
        return temp;
    }

    /**
     * 获取栈顶元素
     */
    public T peek() {
        if (head == null) {
            System.out.println("头结点元素为空");
            return null;
        }
        T temp = head.data;
        return temp;
    }

    /**
     * 栈空
     */
    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }
}
