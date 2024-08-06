package io.p4r53c.telran;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.Test;

import io.p4r53c.telran.exps_iterator.Range;
import io.p4r53c.telran.exps_iterator.exceptions.OutOfRangeMaxValueException;

class RangeTest {

    private static final int MIN = 50;
    private static final int MAX = 100;

    Range range = Range.getRange(MIN, MAX);

    // CW 14
    @Test
    void testWrongRange() {
        assertThrowsExactly(IllegalArgumentException.class, () -> Range.getRange(MAX, MIN));
    }

    @Test
    void testRightValue() throws Exception {
        range.checkValue(55);
    }

    @Test
    void testWrongValue() {
        assertThrowsExactly(OutOfRangeMaxValueException.class, () -> range.checkValue(MAX + 1));
    }

}
