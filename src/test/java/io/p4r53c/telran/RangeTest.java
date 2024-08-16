package io.p4r53c.telran;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import io.p4r53c.telran.exps_iterator.Range;
import io.p4r53c.telran.exps_iterator.exceptions.OutOfRangeMaxValueException;

class RangeTest {

    private static final int MIN = 50;
    private static final int MAX = 100;

    // CW 14
    @Test
    void testWrongRange() {
        assertThrowsExactly(IllegalArgumentException.class, () -> Range.getRange(MAX, MIN));
    }

    @Test
    void testRightValue() throws Exception {
        Range range = Range.getRange(MIN, MAX);
        range.checkValue(55);
    }

    @Test
    void testWrongValue() {
        Range range = Range.getRange(MIN, MAX);
        assertThrowsExactly(OutOfRangeMaxValueException.class, () -> range.checkValue(MAX + 1));
    }

    // --- Iterator tests --- HW 18

    // Only numbers from 1 to 5, no predicate
    @Test
    void testRangeWithoutPredicate() {
        Range range = Range.getRange(1, 5);

        List<Integer> result = new ArrayList<>();

        for (int num : range) {
            result.add(num);
        }
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), result);
    }

    // Only even numbers from 1 to 10
    @Test
    void testRangeWithEvenPredicate() {
        Range range = Range.getRange(1, 10);
        range.setPredicate(n -> n % 2 == 0);

        List<Integer> result = new ArrayList<>();

        for (int num : range) {
            result.add(num);
        }

        assertEquals(Arrays.asList(2, 4, 6, 8, 10), result);
    }

    // Primes from 1 to 20
    @Test
    void testRangeWithPrimePredicate() {
        Range range = Range.getRange(1, 20);

        range.setPredicate(n -> {
            boolean isPrime = n > 1;

            for (int i = 2; i <= Math.sqrt(n) && isPrime; i++) {
                if (n % i == 0) {
                    isPrime = false;
                }
            }

            return isPrime;
        });

        List<Integer> result = new ArrayList<>();

        for (int num : range) {
            result.add(num);
        }
        assertEquals(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19), result);
    }

    // Perfect squares from 1 to 20
    @Test
    void testPerfectSquares() {
        Range range = Range.getRange(1, 20);

        range.setPredicate(n -> {
            int sqrt = (int) Math.sqrt(n);
            return sqrt * sqrt == n;
        });

        List<Integer> result = new ArrayList<>();

        for (int num : range) {
            result.add(num);
        }

        assertEquals(Arrays.asList(1, 4, 9, 16), result);
    }

    // Powers of 2
    @Test
    void testPowersOfTwo() {
        Range range = Range.getRange(1, 33);

        range.setPredicate(n -> n > 0 && (n & (n - 1)) == 0);

        List<Integer> result = new ArrayList<>();

        for (int num : range) {
            result.add(num);
        }
        assertEquals(Arrays.asList(1, 2, 4, 8, 16, 32), result);
    }

    @Test
    void testFibonacciNumbers() {
        Range range = Range.getRange(1, 35);

        range.setPredicate(n -> {
            boolean isFibonacci = n >= 0;

            if (isFibonacci) {
                int a = 0, b = 1;

                while (b < n) {
                    int temp = b;
                    b = a + b;
                    a = temp;
                }
                isFibonacci = b == n;
            } else {
                isFibonacci = false;
            }
            return isFibonacci;
        });

        List<Integer> result = new ArrayList<>();

        for (int num : range) {
            result.add(num);
        }

        assertEquals(Arrays.asList(1, 2, 3, 5, 8, 13, 21, 34), result);
    }

}
