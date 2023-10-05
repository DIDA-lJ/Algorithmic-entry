package com.qinyao.linklist;

/**
 * @ClassName DoubleNode
 * @Description 双向链表节点
 * @Version 1.0.0
 * @Author LinQi
 * @Date 2023/10/01
 */
public class DoubleNode {
    public int data;
    public DoubleNode prev;
    public DoubleNode next;

    public DoubleNode(int data) {
        this.data = data;
    }

    /**
     * 打印结点的数据域
     */
    public void displayNode() {
        System.out.println("{" + data + "}");
    }
}
