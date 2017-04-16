package com.bruceding.algs4;

import edu.princeton.cs.algs4.StdOut;

/**
 * author dingjing@youku.com
 * create 2017/4/15 22:44
 */

public class Josephus {

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        Queue<Integer> queue = new Queue<Integer>();

        for(int i = 0; i < n; i++) {
            queue.enqueue(i);
        }

        StdOut.print(queue);
        while(!queue.isEmpty()) {
            for(int i = 0; i < (m - 1); i++) {
                queue.enqueue(queue.dequeue());
            }
            StdOut.print(queue.dequeue() + " ");
        }

    }

}
