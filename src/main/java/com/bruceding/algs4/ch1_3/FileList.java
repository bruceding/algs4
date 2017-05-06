package com.bruceding.algs4.ch1_3;

import com.bruceding.algs4.Queue;
import com.sun.javaws.exceptions.InvalidArgumentException;

import java.io.File;
import java.io.FilterInputStream;

/**
 * author dingjing@youku.com
 * create 2017/4/16 21:40
 */
public class FileList {

    private Queue<File> fileQueue;

    private File rootFile;

    public FileList(String path) throws InvalidArgumentException {
        File file = new File(path);

        if (!file.exists()) {
            throw new InvalidArgumentException(new String[]{"invalid path"});
        }

        rootFile = file;
        fileQueue = new Queue<>();
        File[] files = file.listFiles();

        for (File f : files) {
           fileQueue.enqueue(f);
        }
    }

    private String getPrefix(int index) {

        String str = "|";
        for (int i =0; i < index-1; i++) {
            str += "-";
        }


        return str;
    }

    public void print() {
        System.out.println(rootFile.getName());
        printFile(fileQueue, 4);
    }

    public void printFile(Queue<File> fileQueue, int index) {

        String pre = getPrefix(index);

        for (File file : fileQueue) {
            System.out.println(pre + file.getName());
            if (file.isDirectory()) {
                Queue<File> tmpQueue = new Queue<>();
                for (File f : file.listFiles()) {
                    tmpQueue.enqueue(f);
                }

                printFile(tmpQueue, index + 4);
            }
        }


    }
    public static void main(String[] args) throws InvalidArgumentException {

        FileList fileList = new FileList("/Users/bruceding/Projects/algorithms/algs4/src/main/java/com");

        fileList.print();
    }
}
