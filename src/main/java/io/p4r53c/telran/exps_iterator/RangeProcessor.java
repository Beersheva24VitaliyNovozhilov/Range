package io.p4r53c.telran.exps_iterator;

import io.p4r53c.telran.exps_iterator.exceptions.*;

/**
 * 
 * CW 14
 * 
 */ 
public class RangeProcessor {

    private Range range;

    private int counterOfGreaterThanMaxValues;
    private int counterOfLessThanMinValues;
    private int counterOfCorrectValues;

    public RangeProcessor(Range range) {
        this.range = range;
    }

    public void process(int value) {
        try {
            range.checkValue(value);
            counterOfCorrectValues++;
        } catch (OutOfRangeMaxValueException e) {
            counterOfGreaterThanMaxValues++;
        } catch (OutOfRangeMinValueException e) {
            counterOfLessThanMinValues++;
        }
    }

    public int getCounterOfGreaterThanMaxValues() {
        return counterOfGreaterThanMaxValues;
    }

    public int getCounterOfLessThanMinValues() {
        return counterOfLessThanMinValues;
    }

    public int getCounterOfCorrectValues() {
        return counterOfCorrectValues;
    }
}
