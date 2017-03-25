package com.bruceding.algs4;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.io.IOException;

/**
 * @author dingjing@youku.com
 * @create 2017/3/25 08:04
 */
public class Point2DTest {
    public static void main(String[] args) throws IOException {
        StdDraw.setPenRadius();
        StdDraw.setPenColor(StdDraw.BLUE);

        Point2D point1 = new Point2D(1,.5);
        Point2D point2 = new Point2D(0,0);

        point1.draw();
        point2.drawTo(point1);

        Interval1D[] intervals = new Interval1D[4];
        intervals[0] = new Interval1D(15.0, 33.0);
        intervals[1] = new Interval1D(45.0, 60.0);
        intervals[2] = new Interval1D(20.0, 70.0);
        intervals[3] = new Interval1D(46.0, 55.0);

        StdOut.println(intervals[0].length());
        System.in.read();
        StdOut.println(point1.theta());
    }
}
