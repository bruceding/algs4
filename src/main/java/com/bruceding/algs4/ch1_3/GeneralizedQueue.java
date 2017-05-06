package com.bruceding.algs4.ch1_3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * author dingjing@youku.com
 * create 2017/4/16 20:37
 */
public class GeneralizedQueue<Item> {

    private Item[] a ;
    private int n ;
    private int first ;
    private int last;

    public GeneralizedQueue() {

        a = (Item[]) new Object[2];
        n = 0;
        first = 0;
        last = 0;

    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(Item x) {
        if (n == a.length) {
           resize(n * 2);
        }

        a[last++] = x;
        if (last == a.length) last = 0; // 循环
        n++;
    }

    public void resize(int size) {
        Item[] tmp = (Item[]) new Object[size];
        for(int i = 0; i < n; i++) {
            tmp[i] = a[(i+first)% a.length];
        }

        a = tmp;
        first = 0;
        last = n;
    }

    public Item delete(int k) {
        assert  k <= n;
        int i = (first + k -1) % a.length; // 被删除

        Item item = a[i];


        int rest = n -k ;

        for (int j = 1; j <= rest; j++) {
            a[i + j -1] = a[( i + j) % a.length];
        }
        if (last == 0) {
            last = a.length - 1;
        } else {
            last--;
        }

        a[last] = null;

        n--;
        return item;
    }

    @Override
    public String toString() {
        return "GeneralizedQueue{" +
                "a=" + Arrays.toString(a) +
                ", n=" + n +
                ", first=" + first +
                ", last=" + last +
                '}';
    }
    public static void main(String[] args) {

        GeneralizedQueue<Integer> queue = new GeneralizedQueue<>();

        queue.insert(1);
        queue.insert(2);
        queue.insert(3);

        StdOut.println(queue);

        queue.delete(1);
        StdOut.println(queue);
        queue.delete(1);
        StdOut.println(queue);
        queue.delete(1);
        StdOut.println(queue);

    }
}
