package com.bruceding.algs4;

import edu.princeton.cs.algs4.LinkedQueue;

/**
 * author dingjing@youku.com
 * create 2017/3/30 23:15
 */
public class LinkedQueueTest {

    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();

        queue.enqueue(1);
        queue.enqueue(2);

        System.out.println(queue.dequeue());
    }
}
