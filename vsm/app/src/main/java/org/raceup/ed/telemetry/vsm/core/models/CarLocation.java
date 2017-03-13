/*
 * Copyright 2017 Race UP Electric Division
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.raceup.ed.telemetry.vsm.core.models;


import com.sirfoga.hal.maths.geometry.Geometry;
import com.sirfoga.hal.maths.geometry.Geometry3d;

/**
 * General positions of car components
 */
public class CarLocation extends Geometry3d {
    public static final int FRONT_LEFT = 7;
    static final int FRONT = 5;
    static final int REAR = 6;
    static final int FRONT_RIGHT = 8;
    static final int REAR_LEFT = 9;
    static final int REAR_RIGHT = 10;

    /*
     * Constructors
     */

    /**
     * Constructor with raw int to parse
     *
     * @param location raw int to parse
     */
    public CarLocation(int location) {
        rawLocation = location;
    }

    /**
     * Constructor with raw string
     *
     * @param dataType raw string to parse
     */
    public CarLocation(String dataType) {
        this.rawLocation = parseString(dataType);
    }

    /*
     * Convert and parse
     */

    /**
     * Convert type to string
     *
     * @param dataType raw int data type
     * @return string representation
     */
    public static String toString(int dataType) {
        switch (dataType) {
            case FRONT:
                return "Front";
            case REAR:
                return "Rear";
            case FRONT_LEFT:
                return "Front left";
            case FRONT_RIGHT:
                return "Front right";
            case REAR_LEFT:
                return "Rear left";
            case REAR_RIGHT:
                return "Rear right";
            default:
                return Geometry3d.toString(dataType);
        }
    }

    /**
     * Parses raw string data type
     *
     * @param dataType raw string data type
     * @return int representation
     */
    public static int parseString(String dataType) {
        switch (dataType) {
            case "Front":
                return FRONT;
            case "Rear":
                return REAR;
            case "Front left":
                return FRONT_LEFT;
            case "Front right":
                return FRONT_RIGHT;
            case "Rear left":
                return REAR_LEFT;
            case "Rear right":
                return REAR_RIGHT;
            default:
                return Geometry.parseString(dataType);
        }
    }

    /*
     * Check data type
     */

    /**
     * Checks if location is front
     *
     * @return True iff location is front
     */
    public boolean isFront() {
        return rawLocation == FRONT;
    }

    /**
     * Checks if location is rear
     *
     * @return True iff location is rear
     */
    public boolean isRear() {
        return rawLocation == REAR;
    }

    /**
     * Checks if location is front left
     *
     * @return True iff location is front left
     */
    public boolean isFrontLeft() {
        return rawLocation == FRONT_LEFT;
    }

    /**
     * Checks if location is front right
     *
     * @return True iff location is front right
     */
    public boolean isFrontRight() {
        return rawLocation == FRONT_RIGHT;
    }

    /**
     * Checks if location is rear left
     *
     * @return True iff location is rear left
     */
    public boolean isRearLeft() {
        return rawLocation == REAR_LEFT;
    }

    /**
     * Checks if location is rear right
     *
     * @return True iff location is rear right
     */
    public boolean isRearRight() {
        return rawLocation == REAR_RIGHT;
    }
}
