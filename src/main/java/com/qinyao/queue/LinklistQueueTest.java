package com.qinyao.queue;

/**
 * @ClassName LinklistQueueTest
 * @Description
 * @Version 1.0.0
 * @Author LinQi
 * @Date 2023/09/13
 */
public class LinklistQueueTest {
    public static void main(String[] args) {
        LinklistQueue<Integer> newQueue = new LinklistQueue<>();
        newQueue.push(1);
        newQueue.push(2);
        newQueue.push(3);
        newQueue.push(4);
        newQueue.push(5);
        System.out.print("队列元素: ");
        newQueue.printQueue();
        System.out.println("\n-----------------------------------------");
        LinklistQueue<Integer> finishQueue = new LinklistQueue<>();
        finishQueue.push(newQueue.pull());
        finishQueue.push(newQueue.pull());
        finishQueue.push(newQueue.pull());
        System.out.print("未完成队列:");
        newQueue.printQueue();
        System.out.println();
        System.out.print("已完成队列:");
        finishQueue.printQueue();
        System.out.println("\n-----------------------------------------");
        newQueue.push(6);
        newQueue.push(7);
        newQueue.push(8);
        newQueue.push(9);
        System.out.print("未完成队列:");
        newQueue.printQueue();
        System.out.println();
        System.out.print("已完成队列:");
        finishQueue.printQueue();
        System.out.println("\n-----------------------------------------");
        finishQueue.push(newQueue.pull());
        finishQueue.push(newQueue.pull());
        finishQueue.push(newQueue.pull());
        finishQueue.push(newQueue.pull());
        System.out.print("未完成队列:");
        newQueue.printQueue();
        System.out.println();
        System.out.print("已完成队列:");
        finishQueue.printQueue();
    }
}
