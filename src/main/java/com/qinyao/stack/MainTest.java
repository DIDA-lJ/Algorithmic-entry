package com.qinyao.stack;

import java.util.Stack;

/**
 * @ClassName MainTest
 * @Description 栈的基本使用
 * @Version 1.0.0
 * @Author LinQi
 * @Date 2023/09/06
 */
public class MainTest {
    public static void main(String[] args) {
        // 栈的构建
        Stack<Integer> stack = new Stack<>();

        // 压栈
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // 查看栈顶元素
        System.out.println("栈顶元素为:" + stack.peek());
        System.out.println("--------------------------------");

        while (!stack.empty()) {
            // 对于栈顶元素进行显示,但是不出栈
            System.out.println("栈顶元素:" + stack.peek());
            // 出栈并且显示
            System.out.println("出栈元素:" + stack.pop());
        }

    }
}
