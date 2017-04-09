package com.bruceding.algs4;

/**
 * author dingjing@youku.com
 * create 2017/4/9 07:59
 */
public class StackTest {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        StackThread stackThread1 = new StackThread();
        StackThread stackThread2 = new StackThread();

        stackThread1.stack = stack;
        stackThread2.stack = stack;

        stackThread1.start();
        stackThread2.start();

        stack = stackThread1.stack;

        for (Integer i : stack) {
            System.out.println(i);
        }

    }
}

class StackThread extends Thread {

    public Stack<Integer> stack;
    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            this.stack.push(i);
        }
    }

}
