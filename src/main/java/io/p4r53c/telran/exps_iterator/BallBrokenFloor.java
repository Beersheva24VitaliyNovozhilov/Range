package io.p4r53c.telran.exps_iterator;

import java.util.Random;

import io.p4r53c.telran.exps_iterator.exceptions.BrokenBallException;

/**
 * BallBrokenFloor class represents a ball broken at a random floor from 1 to
 * nFloors.
 * It has a method to check if a floor is broken and throws a custom exception
 * if it is.
 * It also has methods to get the number of floors and the min broken floor.
 * 
 * @author p4r53c
 *
 */
public class BallBrokenFloor {

    private int nFloors;
    private int minBrokenFloor;

    public BallBrokenFloor(int nFloors) {
        this.nFloors = nFloors;
        minBrokenFloor = new Random().nextInt(1, nFloors + 1);
    }

    /**
     * Checks if the given floor is broken and throws a {@link BrokenBallException}
     * if it is.
     * 
     * Decided to introduce a custom exception instead of throwing a generic {@link Exception} because of linting.
     * 
     * @param floor the floor to check
     * @throws BrokenBallException if the floor is broken
     */
    public void checkFloor(int floor) throws BrokenBallException {
        if (floor > nFloors) {
            throw new IllegalArgumentException();
        }
        if (floor >= minBrokenFloor) {
            throw new BrokenBallException(floor);
        }
    }

    /**
     * Gets the minimum broken floor.
     * 
     * @return the minimum broken floor
     */
    public int getMinBrokenFloor() {
        return minBrokenFloor;
    }
}
