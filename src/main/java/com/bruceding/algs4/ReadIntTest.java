package com.bruceding.algs4;

import edu.princeton.cs.algs4.In;

/**
 * author dingjing@youku.com
 * create 2017/3/29 22:41
 */
public class ReadIntTest {

   public static void main(String[] args) {
       String name = args[0];

       In in = new In(name);

       String input = in.readAll();

       String[] words = input.split("\\s+");

       System.out.println(words);
   }
}
