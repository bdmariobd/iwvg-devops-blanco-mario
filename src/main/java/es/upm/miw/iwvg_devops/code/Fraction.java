package es.upm.miw.iwvg_devops.code;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
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
    
    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}