package io.p4r53c.telran.exps_iterator.exceptions;

/**
 * This class represents a custom exception that is thrown when a ball is broken
 * at a specific floor.
 *
 * @author p4r53c
 */
public class BrokenBallException extends Exception {

    public BrokenBallException(int floor) {
        super(String.format("Ball broken at floor [%d]", floor));
    }
}
