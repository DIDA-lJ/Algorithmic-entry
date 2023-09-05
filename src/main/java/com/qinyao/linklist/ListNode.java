package com.qinyao.linklist;


/**
 * @ClassName LinkList
 * @Description
 * @Version 1.0.0
 * @Author LinQi
 * @Date 2023/09/04
 */
public class ListNode {
    private int data;
    private ListNode next;

    public ListNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    /**
     * 获取链表长度
     *
     * @param head 链表的头结点
     * @return
     */
    public static int getListLength(ListNode head) {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    /**
     * 链表遍历打印
     *
     * @param head
     */
    public static void printNodeList(ListNode head) {
        if (head == null) {
            System.out.println("链表为空，无法打印!");
            return;
        }
        int length = 0;
        //定义头结点
        ListNode node = head;
        while (node != null) {
            System.out.println(node.data);
            length++;
            node = node.next;
        }
    }

    /**
     * 链表插入
     *
     * @param head       链表头结点
     * @param nodeInsert 待插入节点
     * @param position   待插入位置，从 1 开始
     * @return 插入后得到的链表头结点
     */
    public static ListNode insertNode(ListNode head, ListNode nodeInsert, int position) {
        // 头结点为空，直接返回
        if (head == null) {
            return nodeInsert;
        }
        // 已经存放的元素格式
        int size = getListLength(head);
        if (position > size + 1 || position < 1) {
            System.out.println("位置参数越界");
            return head;
        }

        //表头插入
        if (position == 1) {
            nodeInsert.next = head;
            //这里可以直接返回 nodeInsert,也可以先将头结点位置前移
            head = nodeInsert;
            return head;
        }
        // 定义一个临时节点用于遍历
        ListNode pNode = head;
        int count = 1;
        // 这里的 position 被 size 限制住，所以不用考虑 pNode = null
        while (count < position - 1) {
            pNode = pNode.next;
            count++;
        }

        nodeInsert.next = pNode.next;
        pNode.next = nodeInsert;

        return head;
    }

    /**
     * 删除节点
     *
     * @param head     链表头结点
     * @param position 删除节点位置，取值从 1 开始
     * @return 删除后的链表头结点
     */
    public static ListNode deleteNode(ListNode head, int position) {
        //判断头结点是否为空，为空的话直接不删除
        if (head == null) {
            System.out.println("链表为空，无法删除！");
            return null;
        }
        int size = getListLength(head);
        // 删除的话一般都尾部节点就可以了，因为尾部节点的下一个节点为空，所以不需要删除
        if (position > size || position < 1) {
            System.out.println("输入参数有误!");
            return head;
        }
        if(position == 1){
            return head.next;
        }
        ListNode cur = head;
        int count = 1;
        while(count < position - 1){
            cur = cur.next;
            count++;
        }
        cur.next = cur.next.next;
        return  head;
    }
}

