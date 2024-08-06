package io.p4r53c.telran.exps_iterator.exceptions;

public class OutOfRangeMinValueException extends Exception {

    public OutOfRangeMinValueException(int min, int value) {
        super(String.format("Out of range MIN: [%d] provided value [%d]", min, value));
    }

}
