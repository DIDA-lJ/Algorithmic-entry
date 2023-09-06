package com.qinyao.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class ListStackTest {

    @Test
    public void testListStack() {
        ListStack<String> stack = new ListStack<String>();
        System.out.println("链表是否为空:" + stack.isEmpty());
        stack.push("Java");
        stack.push(null);
        stack.push("Python");
        stack.push("C++");
        stack.push("C");
        System.out.println("栈顶元素:"+stack.peek());
        System.out.println("---------------------------");
        while (!stack.isEmpty()) {
            System.out.println("出栈元素:" + stack.pop());
        }
    }

}