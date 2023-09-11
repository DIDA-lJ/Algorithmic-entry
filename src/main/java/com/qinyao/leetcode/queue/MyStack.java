package com.qinyao.leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName queue
 * @Description
 * @Version 1.0.0
 * @Author LinQi
 * @Date 2023/09/11
 */
public class MyStack {
    Queue<Integer> pre;
    Queue<Integer> after;

    public MyStack() {
        pre = new LinkedList<Integer>();
        after = new LinkedList<Integer>();
    }

    public void push(int x) {
        after.offer(x);
        while(!pre.isEmpty()){
            after.offer(pre.poll());
        }
        Queue<Integer> temp = pre;
        pre = after;
        after = temp;
    }

    public int pop()  {
        return pre.poll();
    }

    public int top() {
        return pre.peek();
    }

    public boolean empty() {
        return pre.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
