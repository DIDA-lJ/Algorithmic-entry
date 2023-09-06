package com.qinyao.stack;

import java.util.Arrays;

/**
 * @ClassName My
 * @Description
 * @Version 1.0.0
 * @Author LinQi
 * @Date 2023/09/06
 */
public class MyStackByArray<T> {
    /**
     * 实现栈的数组
     */
    private Object[] stack;

    /**
     * 栈顶元素
     */
    private int top;

    public MyStackByArray() {
        // 初始化栈的容量为 10
        stack = new Object[10];
    }

    /**
     * 判断栈是否为空
     */
    public boolean isEmpty() {
        return top == 0;
    }

    /**
     * 返回栈顶元素，但是不出栈
     */
    public T peek() {
        T t = null;
        if (top > 0) {
            t = (T) stack[top - 1];
        }
        return t;
    }

    /**
     * 入栈
     *
     * @param t
     */
    public void push(T t) {
        if (t == null) {
            System.out.println("插入元素不能为空");
            return;
        }
        extendCapacity(top + 1);
        stack[top] = t;
        top++;
        System.out.println("数据 " + t + " 插入数据成功");
    }

    /**
     * 出栈
     *
     * @return 出栈元素
     */
    public T pop() {
        T t = peek();
        if (top > 0) {
            stack[top - 1] = null;
            top--;
        }
        return t;
    }

    /**
     * 扩大容量
     */
    public void extendCapacity(int size) {
        int len = stack.length;
        if (size > len) {
            // 每次扩大 50 %
            size = size * 3 / 2 + 1;
            stack = Arrays.copyOf(stack, size);
        }
    }
}
