package com.qinyao.leetcode.stack;

/**
 * @ClassName MinStack
 * @Description 最小栈
 * @Version 1.0.0
 * @Author LinQi
 * @Date 2023/09/06
 */
public class MinStack {

    /**
     * 私有化头结点
     */
    private  Node head;

    public MinStack() {

    }

    /**
     * '
     * 入栈
     *
     * @param val 插入的值
     */
    public void push(int val) {
        if (head == null){
            head = new Node(val,val,null);
            return;
        }
        head = new Node(val,Math.min(val,head.min),head);
    }

    /**
     * 出栈
     */
    public void pop() {
        head = head.next;
    }

    /**
     * 查看栈顶元素
     *
     * @return
     */
    public int top() {
        return head.val;
    }

    /**
     * 获取栈中元素最小值
     *
     * @return 最小值
     */
    public int getMin() {
        return head.min;
    }

    /**
     * 构造化节点类，用于实现链栈
     */
    private class Node {
        private int val;
        private int min;
        private Node next;


        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }

        public Node(int val, int min) {
            this(val, min, null);
        }
    }
}
