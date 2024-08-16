package io.p4r53c.telran.exps_iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import io.p4r53c.telran.exps_iterator.exceptions.OutOfRangeMaxValueException;
import io.p4r53c.telran.exps_iterator.exceptions.OutOfRangeMinValueException;

public class Range implements Iterable<Integer> {

    private static final String ERROR_MESSAGE = "Range: max must be greater than min";

    private int min;
    private int max;

    private Predicate<Integer> predicate;

    private Range(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public static Range getRange(int min, int max) {
        if (max <= min) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return new Range(min, max);
    }

    public void checkValue(int value) throws OutOfRangeMaxValueException, OutOfRangeMinValueException {
        if (value > max) {
            throw new OutOfRangeMaxValueException(max, value);
        }

        if (value < min) {
            throw new OutOfRangeMinValueException(min, value);
        }
    }

    public void setPredicate(Predicate<Integer> predicate) {
        this.predicate = predicate;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RangeIterator();
    }

    private class RangeIterator implements Iterator<Integer> {

        int current;

        public RangeIterator() {
            current = findNextValid(min);
        }

        @Override
        public boolean hasNext() {
            return current < max;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            Integer result = current;

            current = findNextValid(current + 1); // Move to the next valid element.

            return result;
        }

        private int findNextValid(int min) {
            while (min <= max) {
                if (predicate == null || predicate.test(min)) {
                    return min;
                }
                min++;
            }

            return max; // No more valid elements.
        }
    }
}
