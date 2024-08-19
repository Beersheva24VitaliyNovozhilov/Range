package io.p4r53c.telran;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.StreamSupport;

import org.junit.jupiter.api.Test;

import io.p4r53c.telran.exps_iterator.Range;

class StreamTests {

    Range range = Range.getRange(1, 6);

    @Test
    void evenNumbersFromRange() {

        Integer[] result = { 2, 4, 6 };

        Integer[] actual = StreamSupport.stream(range.spliterator(), false)
                .filter(n -> n % 2 == 0)
                .toArray(Integer[]::new);
        assertArrayEquals(result, actual);
    }

    @Test
    void oddNumbersSumTest() {
        int result = 9;
        int actual = StreamSupport.stream(range.spliterator(), false)
                .filter(n -> n % 2 != 0)
                .mapToInt(n -> n)
                .sum();
        assertEquals(result, actual);
    }
}
