package com.structure.stack;

import java.util.Stack;

public class 实现min为常数复杂度的栈 {

    private static class MinStack<T extends Comparable<T>> {

        // 这是存储所有数据的栈
        private final Stack<T> stack = new Stack<>();

        // 这是存储min值的栈
        private final Stack<T> minStack = new Stack<>();

        public boolean isEmpty() {
            return stack.isEmpty();
        }

        public T pop() {
            T result = null;
            // 空意味着没有可以出栈的，不空就允许出栈
            if (!isEmpty()) {
                // 数据出栈
                result = stack.pop();
            }
            // 要注意处理掉min栈的栈顶元素
            if (minStack.peek().equals(result)) {
                minStack.pop();
            }
            return result;
        }

        public void push(T obj) {
            // 正常入栈
            stack.push(obj);
            // 空栈或新值≤旧min可以直接加入
            if (minStack.isEmpty() || minStack.peek().compareTo(obj) >= 0) {
                minStack.push(obj);
            }
        }

        public T getMin() {
            return isEmpty() ? null : minStack.peek();
        }

    }

    public static void main(String[] args) {
        MinStack<Integer> stack = new MinStack<>();
        int[] nums = new int[] {88, 11, 33, 11, 5, 8, 3, 1, 20};
        for (int i : nums) {
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            System.out.println("当前最小值：" + stack.getMin());
            System.out.println("当前出栈元素：" + stack.pop());
        }
    }

}
