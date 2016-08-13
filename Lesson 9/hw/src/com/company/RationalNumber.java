package com.company;

/**
 * Created by Juda on 13/08/2016.
 */
public class RationalNumber extends Number {//we created a new pattern of Number
    private int numerator;
    private int denominator;

    public RationalNumber(int denominator, int numerator) {
        setNumerator(numerator);
        this.denominator = 1;
        setDenominator(denominator);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        if (denominator != 0)
            this.denominator = denominator;
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return (double)numerator/(double)denominator;
    }
}
