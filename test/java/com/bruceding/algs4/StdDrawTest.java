package com.bruceding.algs4;

import edu.princeton.cs.algs4.StdDraw;
import junit.framework.TestCase;

import java.io.IOException;

/**
 * @author dingjing@youku.com
 * @create 2017/3/23 22:23
 */
public class StdDrawTest extends TestCase {

    public void testDraw() {
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.line(.1,.1, .4, .4);
        StdDraw.circle(.5, .5, .10);

        // text
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(0.2, 0.5, "black text");
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0.8, 0.8, "white text");

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
