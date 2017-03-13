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

package org.raceup.ed.telemetry.vsm.core.models.data;

/**
 * Possible type of data coming from data
 */
public class CarDataType {
    public static final int TEMPERATURE = 6;
    public static final int SUSPENSION_COMPRESSION = 7;
    public static final int TYRE_SPEED = 8;
    public static final int WATER_BLOCK = 9;
    public static final int TI = 10;
    public static final int UNDEFINED = -1;
    public static final int THROTTLE = 0;
    public static final int BRAKE = 1;
    public static final int STEERING_ANGLE = 2;
    public static final int BRAKE_PRESSURE = 3;
    public static final int ACCELERATION = 4;
    public static final int YAW_RATE = 5;
    private int rawDataType;
    private String stringDataType;

    /*
     * Constructors
     */

    /**
     * Constructor with raw int to parse
     *
     * @param dataType raw int to parse
     */
    public CarDataType(int dataType) {
        this.rawDataType = dataType;
        this.stringDataType = toString(rawDataType);
    }

    /**
     * Constructor with raw string
     *
     * @param dataType raw string to parse
     */
    public CarDataType(String dataType) {
        this.rawDataType = parseString(dataType);
        this.stringDataType = toString(rawDataType);
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
            case THROTTLE:
                return "THROTTLE";
            case BRAKE:
                return "BRAKE";
            case STEERING_ANGLE:
                return "STEERING_ANGLE";
            case BRAKE_PRESSURE:
                return "BRAKE_PRESSURE";
            case ACCELERATION:
                return "ACCELERATION";
            case YAW_RATE:
                return "YAW_RATE";
            case TEMPERATURE:
                return "TEMPERATURE";
            case SUSPENSION_COMPRESSION:
                return "SUSPENSION_COMPRESSION";
            case TYRE_SPEED:
                return "TYRE_SPEED";
            case WATER_BLOCK:
                return "WATER_BLOCK";
            case TI:
                return "TI";
            default:
                return "UNDEFINED";
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
            case "THROTTLE":
                return THROTTLE;
            case "BRAKE":
                return BRAKE;
            case "STEERING_ANGLE":
                return STEERING_ANGLE;
            case "BRAKE_PRESSURE":
                return BRAKE_PRESSURE;
            case "ACCELERATION":
                return ACCELERATION;
            case "YAW_RATE":
                return YAW_RATE;
            case "TEMPERATURE":
                return TEMPERATURE;
            case "SUSPENSION_COMPRESSION":
                return SUSPENSION_COMPRESSION;
            case "TYRE_SPEED":
                return TYRE_SPEED;
            case "WATER_BLOCK":
                return WATER_BLOCK;
            case "TI":
                return TI;
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
    public int getDataType() {
        return rawDataType;
    }

    /**
     * Gets string representation of data type
     *
     * @return string representation of data type
     */
    public String getDataName() {
        return stringDataType;
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
        return rawDataType == UNDEFINED;
    }

    /**
     * Checks if data is throttle
     *
     * @return True iff data is throttle
     */
    public boolean isThrottle() {
        return rawDataType == THROTTLE;
    }

    /**
     * Checks if data is brake
     *
     * @return True iff data is brake
     */
    public boolean isBrake() {
        return rawDataType == BRAKE;
    }

    /**
     * Checks if data is steering
     *
     * @return True iff data is steering
     */
    public boolean isSteeringAngle() {
        return rawDataType == STEERING_ANGLE;
    }

    /**
     * Checks if data is brake pressure
     *
     * @return True iff data is brake pressure
     */
    public boolean isBrakePressure() {
        return rawDataType == BRAKE_PRESSURE;
    }

    /**
     * Checks if data is acceleration
     *
     * @return True iff data is acceleration
     */
    public boolean isAcceleration() {
        return rawDataType == ACCELERATION;
    }

    /**
     * Checks if data is yaw rate
     *
     * @return True iff data is yaw rate
     */
    public boolean isYawRate() {
        return rawDataType == YAW_RATE;
    }

    /**
     * Checks if data is temperature
     *
     * @return True iff data is temperature
     */
    public boolean isTemperature() {
        return rawDataType == TEMPERATURE;
    }

    /**
     * Checks if data is suspension compression
     *
     * @return True iff data is suspension compression
     */
    public boolean isSuspensionCompression() {
        return rawDataType == SUSPENSION_COMPRESSION;
    }

    /**
     * Checks if data is tyre speed
     *
     * @return True iff data is tyre speed
     */
    public boolean isTyreSpeed() {
        return rawDataType == TYRE_SPEED;
    }

    /**
     * Checks if data is water block
     *
     * @return True iff data is water block
     */
    public boolean isWaterBlock() {
        return rawDataType == WATER_BLOCK;
    }

    /**
     * Checks if data is ati
     *
     * @return True iff data is ati
     */
    public boolean isAti() {
        return rawDataType == TI;
    }
}
