package com.bruceding.algs4;

/**
 * author dingjing@youku.com
 * create 2017/3/29 22:58
 */
public class Rational {
    private long numerator;
    private long denominator;

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    public Rational(int numerator, int denominator) {

        assert denominator!=0;

        int gcd = gcd(numerator, denominator);
        if (gcd == 0) {
            gcd = 1;
        }

        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    private int gcd( int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

    public Rational plus(Rational b) {
        long n = numerator * b.getDenominator() + denominator * b.getNumerator();
        long d = denominator * b.getDenominator();

        return  new Rational((int)n, (int)d);

    }

    public Rational minus(Rational b) {
        long n = numerator * b.getDenominator() - denominator * b.getNumerator();
        long d = denominator * b.getDenominator();

        return  new Rational((int)n, (int)d);

    }

    @Override
    public String toString() {
        return "Rational{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }

    public static void main(String[] args) {
        Rational a = new Rational(2, 4);
        Rational b = new Rational(2, 3);

        Rational c = a.plus(b);
        Rational d = a.minus(b);
        System.out.println(a);
        System.out.println(c);
        System.out.println(d);
    }
}
