package com.bruceding.algs4;

import java.util.NoSuchElementException;

/**
 * author dingjing@youku.com
 * create 2017/4/9 18:43
 */
public class LinkNode<Item> {

    private Node<Item> head ;
    private int n;
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;

        public Node(Item item) {
            this.item = item;
        }
        public Node() {
        }
    }

    public LinkNode() {
        this.head = null ;
    }

    public void addNode(Item item) {
        Node<Item> oldHead = head;

        head = new Node<Item>();
        head.item = item;
        head.next = oldHead;
        n++;

    }
    public void addNode(Node<Item> item) {
        Node<Item> oldHead = head;

        head = item;
        head.next = oldHead;
        n++;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public String toString() {
        String str = "";

        if (isEmpty()) {
            str = "empty link node";
        } else {
            str = "[";
            Node<Item> oldHead = head;
            while (oldHead != null) {
               str += oldHead.item.toString() + ",";
               oldHead = oldHead.next;
            }

            str = str.substring(0, str.length() - 1);

            str += "]";
        }
        return str;

    }

    public void delTailNode(){
        if (isEmpty())  throw  new NoSuchElementException("link node empty");

        if (head.next == null) {
            head = null;
            n = 0;
            return;
        }

        Node<Item> oldHead = head;

        while(oldHead.next.next != null) {
            oldHead = oldHead.next;
        }

        oldHead.next = null;
        n--;
    }

    public void delNode(int k) {
        if (k > n) throw new NoSuchElementException("not have node");

        if (k == 1) {
            head = head.next;
            n--;
            return;
        }

        Node<Item> nextHead = head;
        Node<Item> preHead  = nextHead;

        for (int i = 1; i< k; i++) {
            preHead = nextHead;
            nextHead = nextHead.next;
        }

        preHead.next = nextHead.next;
        nextHead = null;
        n--;

    }

    public Node<Item> reverse(Node<Item> first) {
        if (first == null) return null;
        if (first.next == null) return first;

        Node<Item> second = first.next;
        Node<Item> rest = reverse(second);
        second.next = first;
        first.next = null;
        return rest;
    }
    public static void main(String[] args) {
        LinkNode<Integer> linkNode = new LinkNode<>();
        Node<Integer> first = new Node<>(1);
        Node<Integer> tail = new Node<>(3);

        linkNode.addNode(tail);
        linkNode.addNode(new Node<Integer>(2));
        linkNode.addNode(first);

        System.out.println(linkNode);
        Node<Integer> newFirst = linkNode.reverse(first);
        System.out.println(newFirst.item);
        System.out.println(linkNode);

    }
}
