package com.qinyao.stack;


import org.junit.Test;

public class MyStackByArrayTest {
    @Test
    public void testStack() {
        MyStackByArray<String> stack = new MyStackByArray<>();

        System.out.println("栈顶元素:" + stack.peek());
        System.out.println(stack.isEmpty());
        stack.push("Java");
        stack.push(null);
        stack.push("Python");
        stack.push("C++");

        System.out.println("----------------");
        while (!stack.isEmpty()) {
            System.out.println("栈顶元素为:" + stack.peek());
            System.out.println("出栈元素为:" + stack.pop());
        }

    }
}