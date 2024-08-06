package io.p4r53c.telran.exps_iterator;

import io.p4r53c.telran.exps_iterator.exceptions.OutOfRangeMaxValueException;
import io.p4r53c.telran.exps_iterator.exceptions.OutOfRangeMinValueException;

/**
 * 
 * CW 14
 * 
 */
public class Range {

    private static final String ERROR_MESSAGE = "Range: max must be greater than min";
    private int min;
    private int max;

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
}
