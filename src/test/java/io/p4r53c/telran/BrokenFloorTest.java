package io.p4r53c.telran;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.p4r53c.telran.exps_iterator.BallBrokenFloor;

class BrokenFloorTest {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(BrokenFloorTest.class);

    // HW 14
    private int getMinBrokenFloor(BallBrokenFloor ballBrokenFloor) {
        int low = 1;
        int high = Integer.MAX_VALUE;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            try {
                ballBrokenFloor.checkFloor(mid);
                low = mid + 1;
            } catch (Exception ex) {
                logger.debug(ex.getMessage()); // Message: Null is obviously, but it helps to see too many iterations
                high = mid - 1;
            }
        }

        return low;
    }

    @Test
    void testMinimalBrokenFloor() {
        int[] floors = { 200, 17, 1001, 2000 };

        for (int floor : floors) {
            BallBrokenFloor ballBrokenFloor = new BallBrokenFloor(floor);
            assertEquals(ballBrokenFloor.getMinBrokenFloor(), getMinBrokenFloor(ballBrokenFloor));

            logger.debug(String.format("BallBrokenFloor: %d, MinBrokenFloor: %d", ballBrokenFloor.getMinBrokenFloor(),
                    getMinBrokenFloor(ballBrokenFloor)));
        }
    }
}
