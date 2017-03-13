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
 * Abstract geometry class to subclass all 3d planes
 */
public class Geometry3d extends Geometry {
    public static final int X_AXIS = 2;
    public static final int Y_AXIS = 3;
    public static final int Z_AXIS = 4;

    /*
     * Constructors
     */

    public Geometry3d() {
        super();
    }

    public Geometry3d(int location) {
        super(location);
    }

    public Geometry3d(String dataType) {
        super(dataType);
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
            case X_AXIS:
                return "X axis";
            case Y_AXIS:
                return "Y axis";
            case Z_AXIS:
                return "Z axis";
            default:
                return Geometry.toString(dataType);
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
            case "X axis":
                return X_AXIS;
            case "Y axis":
                return Y_AXIS;
            case "Z axis":
                return Z_AXIS;
            default:
                return Geometry.parseString(dataType);
        }
    }

    /*
     * Check data type
     */

    /**
     * Checks if data is x axis
     *
     * @return True iff data is x axis
     */
    public boolean isXAxis() {
        return rawLocation == X_AXIS;
    }

    /**
     * Checks if data is y axis
     *
     * @return True iff data is y axis
     */
    public boolean isYAxis() {
        return rawLocation == Y_AXIS;
    }

    /**
     * Checks if data is z axis
     *
     * @return True iff data is z axis
     */
    public boolean isZAxis() {
        return rawLocation == Z_AXIS;
    }
}
