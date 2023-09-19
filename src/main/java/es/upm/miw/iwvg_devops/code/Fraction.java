package es.upm.miw.iwvg_devops.code;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        int gcd = gcd(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    public Fraction() {
        this(1, 1);
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
        this.denominator = denominator;
    }

    public double decimal() {
        return (double) numerator / denominator;
    }

    public static boolean isProper(Fraction fraction){
        return (fraction.getNumerator() < fraction.getDenominator()) && (fraction.getDenominator() != 0);
    }

    public static boolean isImproper(Fraction fraction){
        return (fraction.getNumerator() >= fraction.getDenominator()) && (fraction.getDenominator() != 0);
    }

    public static boolean isEquivalent(Fraction fraction1, Fraction fraction2){
        return (fraction1.getNumerator() * fraction2.getDenominator()) == (fraction1.getDenominator() * fraction2.getNumerator());
    }

    public static Fraction add(Fraction fraction1, Fraction fraction2) {
        int numerator = (fraction1.getNumerator() * fraction2.getDenominator()) + (fraction1.getDenominator() * fraction2.getNumerator());
        int denominator = fraction1.getDenominator() * fraction2.getDenominator();
        return new Fraction(numerator, denominator);
    }

    public static Fraction multiply(Fraction fraction1, Fraction fraction2) {
        int numerator = fraction1.getNumerator() * fraction2.getNumerator();
        int denominator = fraction1.getDenominator() * fraction2.getDenominator();
        return new Fraction(numerator, denominator);
    }

    public static Fraction divide(Fraction fraction1, Fraction fraction2) {
        if (fraction2.numerator == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        int numerator = fraction1.getNumerator() * fraction2.getDenominator();
        int denominator = fraction1.getDenominator() * fraction2.getNumerator();
        return new Fraction(numerator, denominator);
    }

    private static int gcd(int numerator, int denominator) {
        return denominator == 0 ? numerator : gcd(denominator, numerator % denominator);
    }
    
    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numerator;
        result = prime * result + denominator;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Fraction other = (Fraction) obj;
        if (numerator != other.numerator)
            return false;
        if (denominator != other.denominator)
            return false;
        return true;
    }
}