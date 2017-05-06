package com.bruceding.algs4.ch1_3;

import edu.princeton.cs.algs4.Stack;

/**
 * TODO 说明 algs4
 *
 * @author 丁静
 * @since 2017-05-06 09:50
 */
public class Buffer {

    private Stack<Character> stack;
    private Stack<Character> stack1;

    private int offset; // 光标位置
    public Buffer() {

        this.offset = 0;
        stack = new Stack<>();
        stack1 = new Stack<>();

    }

    public void insert(char c) {
        stack.push(c);
        this.offset = stack.size();
    }

    public int size() {
        return stack.size();
    }

    public void left(int k) {
       assert offset >= k + 1;
       this.offset -= k;
    }

    public void right(int k) {
        assert offset + k <= stack.size();
        this.offset += k;
    }

    public char delete() {
        assert stack.size() != 0;
        for ( int i = stack.size(); i > offset; i--) {
            stack1.push(stack.pop());
        }

        char c = stack.pop();


        while (!stack1.isEmpty()) {
            stack.push(stack1.pop());
        }

        if (offset > stack.size()) {
            offset = stack.size();
        }
        return c;
    }

    @Override
    public String toString() {
        return "Buffer{" + "stack=" + stack + ", offset=" + offset + '}';
    }

    public static void main(String[] args) {

        Buffer buffer = new Buffer();
        buffer.insert('a');
        buffer.insert('b');
        buffer.insert('c');
        buffer.insert('d');

        System.out.println(buffer.toString());

        buffer.left(2);
        char c = buffer.delete();
        System.out.println(c);
        System.out.println(buffer.toString());

         c = buffer.delete();
        System.out.println(c);
        System.out.println(buffer.toString());

        c = buffer.delete();
        System.out.println(c);
        System.out.println(buffer.toString());

        c = buffer.delete();
        System.out.println(c);
        System.out.println(buffer.toString());

    }
}
