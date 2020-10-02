package workshop;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimalCommonPitfallsWithSolution {

    public static void main(String[] args) {
        doubleConstructor();
        System.out.println("----------");
        valueOf();
        System.out.println("----------");
        equals();
        System.out.println("----------");
        round();
    }

    private static void round() {
        BigDecimal x = new BigDecimal("12345.6789");
        x = x.round(new MathContext(2, RoundingMode.HALF_UP));
        System.out.println("x=" + x.toPlainString());
        System.out.println("scale=" + x.scale());

        BigDecimal y = new BigDecimal("12345.6789");
        y = y.setScale(2, RoundingMode.HALF_UP);
        System.out.println("y=" + y.toPlainString());

        BigDecimal a = new BigDecimal("12345.12345");
        BigDecimal b = new BigDecimal("23456.23456");
        BigDecimal c = a.multiply(b);
        System.out.println("c=" + c);
        BigDecimal d = c.round(new MathContext(12, RoundingMode.HALF_UP));
        System.out.println("d=" + d);
        BigDecimal e = c.round(new MathContext(c.precision() - c.scale() + 3, RoundingMode.HALF_UP));
        System.out.println("e=" + e);
    }

    private static void equals() {
        BigDecimal x = new BigDecimal("1");
        BigDecimal y = new BigDecimal("1.0");

        // This output is due to the fact that a BigDecimal consists of an unscaled integer
        // value with arbitrary precision and a 32-bit integer scale, both of which must
        // be equal to the corresponding values of the other BigDecimal that’s being compared. In this case
        // x has an unscaled value of 1 and a scale of 0.
        // y has an unscaled value of 10 and a scale of 1.
        // Hence, x is not equal to y.
        System.out.println(x.equals(y));

        // Use below comparison method.
        System.out.println(x.compareTo(y) == 0);
    }

    private static void valueOf() {
        // Value x has lost four decimal digits because a double has a precision of only 15–17 digits
        // A float has a precision of only 6–9 digits,
        // While a BigDecimal is of arbitrary precision (limited only by memory)
        BigDecimal x = BigDecimal.valueOf(1.01234567890123456789);
        BigDecimal y = new BigDecimal("1.01234567890123456789");

        System.out.println("x=" + x);
        System.out.println("y=" + y);
    }

    private static void doubleConstructor() {
        // Don't use double constructor
        // The result of this constructor can be somewhat unpredictable.
        // This is because floating-point numbers are represented in computer hardware as base 2 (binary) fractions.
        // However, most decimal fractions cannot be represented exactly as binary fractions.
        // Therefore, the binary floating-point numbers actually stored in the machine only approximate
        // the decimal floating-point numbers you enter. Hence,
        // the value passed to the double constructor is not exactly equal to 0.1.
        BigDecimal x = new BigDecimal(0.1);
        System.out.println("x=" + x);

        // Use string constructor
        BigDecimal y = new BigDecimal("0.1");
        System.out.println("y=" + y);
    }
}
