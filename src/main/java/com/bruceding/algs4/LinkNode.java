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
    public static void main(String[] args) {
        LinkNode<Integer> linkNode = new LinkNode<>();
        linkNode.addNode(3);
        linkNode.addNode(1);
        linkNode.addNode(2);

        System.out.println(linkNode);

        linkNode.delTailNode();
        System.out.println(linkNode);
        linkNode.delNode(1);
        System.out.println(linkNode);

    }
}
