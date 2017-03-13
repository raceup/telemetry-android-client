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

package com.sirfoga.hal.maths.geometry;

/**
 * Abstract geometry class to subclass all possible 1d geometries
 */
public class Geometry {
    public static final int UNDEFINED = -1;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;

    protected int rawLocation;
    protected String stringLocation;

    /*
     * Constructors
     */

    /**
     * Undefined geometry
     */
    public Geometry() {
        rawLocation = UNDEFINED;  // undefined
        stringLocation = toString(rawLocation);
    }

    /**
     * Constructor with raw int to parse
     *
     * @param location raw int to parse
     */
    public Geometry(int location) {
        rawLocation = location;
        stringLocation = toString(rawLocation);
    }

    /**
     * Constructor with raw string
     *
     * @param dataType raw string to parse
     */
    public Geometry(String dataType) {
        rawLocation = parseString(dataType);
        stringLocation = toString(rawLocation);
    }

    /*
     * Getters
     */

    /**
     * Convert type to string
     *
     * @param dataType raw int data type
     * @return string representation
     */
    public static String toString(int dataType) {
        switch (dataType) {
            case LEFT:
                return "Left";
            case RIGHT:
                return "Right";
            default:
                return "Undefined";
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
            case "Left":
                return LEFT;
            case "Right":
                return RIGHT;
            default:
                return UNDEFINED;
        }
    }

    /*
     * Convert and parse
     */

    /**
     * Gets type of data
     *
     * @return type of data
     */
    public int getLocation() {
        return rawLocation;
    }

    /**
     * Gets string representation of data type
     *
     * @return string representation of data type
     */
    public String getLocationName() {
        return stringLocation;
    }

    /*
     * Check data type
     */

    /**
     * Checks if data is undefined
     *
     * @return True iff data is undefined
     */
    public boolean isUndefined() {
        return rawLocation == UNDEFINED;
    }

    /**
     * Checks if data is left
     *
     * @return True iff data is left
     */
    public boolean isLeft() {
        return rawLocation == LEFT;
    }

    /**
     * Checks if data is right
     *
     * @return True iff data is right
     */
    public boolean isRight() {
        return rawLocation == RIGHT;
    }
}
