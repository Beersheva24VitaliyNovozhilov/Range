package io.p4r53c.telran.exps_iterator.exceptions;

public class OutOfRangeMaxValueException extends Exception {

    public OutOfRangeMaxValueException(int max, int value) {
        super(String.format("Out of range MAX: [%d] provided value [%d]", max, value));
    }
}
