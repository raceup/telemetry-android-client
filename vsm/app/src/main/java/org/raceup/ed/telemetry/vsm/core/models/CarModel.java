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

import com.sirfoga.hal.maths.geometry.Geometry3d;

import org.raceup.ed.telemetry.vsm.core.models.data.CarValue;

/**
 * Real-time car data model from telemetry data
 */
public class CarModel {
    private final CarValue[] brakes = {new CarValue(), new CarValue()};  // f, r
    private final CarValue[] accelerations = {new CarValue(), new CarValue(), new CarValue()};  // x, y, z axis
    private final CarValue[] temperatures = {new CarValue(), new CarValue(), new CarValue(), new CarValue()};  // fl, fr, rl, rr
    private final CarValue[] suspensionCompressions = {new CarValue(), new CarValue(), new CarValue(), new CarValue()};  // fl, fr, rl, rr
    private final CarValue[] tyreSpeeds = {new CarValue(), new CarValue(), new CarValue(), new CarValue()};  // fl, fr, rl, rr
    private final CarValue[] waterBlocks = {new CarValue(), new CarValue(), new CarValue(), new CarValue()};  // fl, fr, rl, rr
    private final CarValue[] atis = {new CarValue(), new CarValue(), new CarValue(), new CarValue()};  // fl, fr, rl, rr
    private CarValue throttle;
    private CarValue brake;
    private CarValue steeringWheelRotation;
    private CarValue yawRate;
    private CarValue atiCore;

    public CarModel() {
    }

    /*
     * Setters
     */

    /**
     * Sets brake pressure of given brake
     *
     * @param brakePressure pressure of brake
     * @param brakePosition position of brake
     */
    public void setBrakePressure(double brakePressure, int brakePosition) {
        CarLocation brakeLocation = new CarLocation(brakePosition);

        if (brakeLocation.isFront()) {
            this.brakes[0].setValue(brakePressure);
        } else if (brakeLocation.isRear()) {
            this.brakes[1].setValue(brakePressure);
        } else {
            throw new IllegalArgumentException(Integer.toString(brakePosition) + " is an illegal car geometry for brakes.");
        }
    }

    /**
     * Sets acceleration
     *
     * @param acceleration value
     * @param position     where to put new value
     */
    public void setAcceleration(double acceleration, int position) {
        if (position == Geometry3d.X_AXIS) {
            this.accelerations[0].setValue(acceleration);
        } else if (position == Geometry3d.Y_AXIS) {
            this.accelerations[1].setValue(acceleration);
        } else if (position == Geometry3d.Z_AXIS) {
            this.accelerations[2].setValue(acceleration);
        } else {
            throw new IllegalArgumentException(Integer.toString(position) + " is an illegal car geometry for accelerations.");
        }
    }

    /**
     * Sets oil temperature of given tyre
     *
     * @param oilTemperature value
     * @param tyrePosition   position of tyre
     */
    public void setTemperatures(double oilTemperature, int tyrePosition) {
        if (tyrePosition == CarLocation.FRONT_LEFT) {
            this.temperatures[0].setValue(oilTemperature);
        } else if (tyrePosition == CarLocation.FRONT_RIGHT) {
            this.temperatures[1].setValue(oilTemperature);
        } else if (tyrePosition == CarLocation.REAR_LEFT) {
            this.temperatures[2].setValue(oilTemperature);
        } else if (tyrePosition == CarLocation.REAR_RIGHT) {
            this.temperatures[3].setValue(oilTemperature);
        } else {
            throw new IllegalArgumentException(Integer.toString(tyrePosition) + " is an illegal car geometry for oil temperature.");
        }
    }

    /**
     * Sets oil temperature of given tyre
     *
     * @param suspensionCompression value
     * @param tyrePosition          position of tyre
     */
    public void setSuspensionCompression(double suspensionCompression, int tyrePosition) {
        if (tyrePosition == CarLocation.FRONT_LEFT) {
            this.suspensionCompressions[0].setValue(suspensionCompression);
        } else if (tyrePosition == CarLocation.FRONT_RIGHT) {
            this.suspensionCompressions[1].setValue(suspensionCompression);
        } else if (tyrePosition == CarLocation.REAR_LEFT) {
            this.suspensionCompressions[2].setValue(suspensionCompression);
        } else if (tyrePosition == CarLocation.REAR_RIGHT) {
            this.suspensionCompressions[3].setValue(suspensionCompression);
        } else {
            throw new IllegalArgumentException(Integer.toString(tyrePosition) + " is an illegal car geometry for suspension compression.");
        }
    }

    /**
     * Sets oil temperature of given tyre
     *
     * @param tyreSpeed    value
     * @param tyrePosition position of tyre
     */
    public void setTyreSpeed(double tyreSpeed, int tyrePosition) {
        if (tyrePosition == CarLocation.FRONT_LEFT) {
            this.tyreSpeeds[0].setValue(tyreSpeed);
        } else if (tyrePosition == CarLocation.FRONT_RIGHT) {
            this.tyreSpeeds[1].setValue(tyreSpeed);
        } else if (tyrePosition == CarLocation.REAR_LEFT) {
            this.tyreSpeeds[2].setValue(tyreSpeed);
        } else if (tyrePosition == CarLocation.REAR_RIGHT) {
            this.tyreSpeeds[3].setValue(tyreSpeed);
        } else {
            throw new IllegalArgumentException(Integer.toString(tyrePosition) + " is an illegal car geometry for tyre speed.");
        }
    }

    /**
     * Sets oil temperature of given tyre
     *
     * @param waterBlock   value
     * @param tyrePosition position of tyre
     */
    public void setWaterBlock(double waterBlock, int tyrePosition) {
        if (tyrePosition == CarLocation.FRONT_LEFT) {
            this.waterBlocks[0].setValue(waterBlock);
        } else if (tyrePosition == CarLocation.FRONT_RIGHT) {
            this.waterBlocks[1].setValue(waterBlock);
        } else if (tyrePosition == CarLocation.REAR_LEFT) {
            this.waterBlocks[2].setValue(waterBlock);
        } else if (tyrePosition == CarLocation.REAR_RIGHT) {
            this.waterBlocks[3].setValue(waterBlock);
        } else {
            throw new IllegalArgumentException(Integer.toString(tyrePosition) + " is an illegal car geometry for water block.");
        }
    }

    /**
     * Sets oil temperature of given tyre
     *
     * @param ati          value
     * @param tyrePosition position of tyre
     */
    public void setAtis(double ati, int tyrePosition) {
        if (tyrePosition == CarLocation.FRONT_LEFT) {
            this.atis[0].setValue(ati);
        } else if (tyrePosition == CarLocation.FRONT_RIGHT) {
            this.atis[1].setValue(ati);
        } else if (tyrePosition == CarLocation.REAR_LEFT) {
            this.atis[2].setValue(ati);
        } else if (tyrePosition == CarLocation.REAR_RIGHT) {
            this.atis[3].setValue(ati);
        } else {
            throw new IllegalArgumentException(Integer.toString(tyrePosition) + " is an illegal car geometry for TI.");
        }
    }

    /**
     * Gets throttle
     *
     * @return throttle value
     */
    public double getThrottle() {
        return throttle.getValue();
    }

    /**
     * Sets throttle
     *
     * @param throttle value
     */
    public void setThrottle(double throttle) {
        this.throttle = new CarValue(throttle);
    }

    /**
     * Gets brake
     *
     * @return brake value
     */
    public double getBrake() {
        return brake.getValue();
    }

    /**
     * Sets brake
     *
     * @param brake value
     */
    public void setBrake(double brake) {
        this.brake = new CarValue(brake);
    }

    /**
     * Gets brake pressure of given brake
     *
     * @param brakePosition position of brake
     * @return pressure of brake
     */
    public double getBrakePressure(int brakePosition) {
        if (brakePosition == CarLocation.FRONT) {
            return brakes[0].getValue();
        } else if (brakePosition == CarLocation.REAR) {
            return brakes[1].getValue();
        } else {
            throw new IllegalArgumentException(Integer.toString(brakePosition) + " is an illegal car geometry for brakes.");
        }
    }

    /*
     * Getters
     */

    /**
     * Gets new rotation of steering wheel
     *
     * @return steeringWheelRotation value
     */
    public double getSteeringAngle() {
        return steeringWheelRotation.getValue();  // degrees in a circle
    }

    /**
     * Sets new rotation of steering wheel
     *
     * @param steeringWheelRotation value
     */
    public void setSteeringWheelRotation(double steeringWheelRotation) {
        this.steeringWheelRotation = new CarValue(steeringWheelRotation % 360);  // degrees in a circle
    }

    /**
     * Gets acceleration
     *
     * @param position where to put new value
     * @return acceleration value
     */
    public double getAcceleration(int position) {
        if (position == Geometry3d.X_AXIS) {
            return accelerations[0].getValue();
        } else if (position == Geometry3d.Y_AXIS) {
            return accelerations[1].getValue();
        } else if (position == Geometry3d.Z_AXIS) {
            return accelerations[2].getValue();
        } else {
            throw new IllegalArgumentException(Integer.toString(position) + " is an illegal car geometry for accelerations.");
        }
    }

    /**
     * Gets yaw rate
     *
     * @return yaw rate value
     */
    public double getYawRate() {
        return yawRate.getValue();
    }

    /**
     * Sets yawrate
     *
     * @param yawRate value
     */
    public void setYawRate(double yawRate) {
        this.yawRate = new CarValue(yawRate);
    }

    /**
     * Gets oil temperature of given tyre
     *
     * @param tyrePosition position of tyre
     * @return oilTemperature value
     */
    public double getTemperatures(int tyrePosition) {
        if (tyrePosition == CarLocation.FRONT_LEFT) {
            return temperatures[0].getValue();
        } else if (tyrePosition == CarLocation.FRONT_RIGHT) {
            return temperatures[1].getValue();
        } else if (tyrePosition == CarLocation.REAR_LEFT) {
            return temperatures[2].getValue();
        } else if (tyrePosition == CarLocation.REAR_RIGHT) {
            return temperatures[3].getValue();
        } else {
            throw new IllegalArgumentException(Integer.toString(tyrePosition) + " is an illegal car geometry for oil temperature.");
        }
    }

    /**
     * Gets oil temperature of given tyre
     *
     * @param tyrePosition position of tyre
     * @return suspensionCompression value
     */
    public double getSuspensionCompression(int tyrePosition) {
        if (tyrePosition == CarLocation.FRONT_LEFT) {
            return suspensionCompressions[0].getValue();
        } else if (tyrePosition == CarLocation.FRONT_RIGHT) {
            return suspensionCompressions[1].getValue();
        } else if (tyrePosition == CarLocation.REAR_LEFT) {
            return suspensionCompressions[2].getValue();
        } else if (tyrePosition == CarLocation.REAR_RIGHT) {
            return suspensionCompressions[3].getValue();
        } else {
            throw new IllegalArgumentException(Integer.toString(tyrePosition) + " is an illegal car geometry for suspension compression.");
        }
    }

    /**
     * Gets oil temperature of given tyre
     *
     * @param tyrePosition position of tyre
     * @return tyreSpeed value
     */
    public double getTyreSpeed(int tyrePosition) {
        if (tyrePosition == CarLocation.FRONT_LEFT) {
            return tyreSpeeds[0].getValue();
        } else if (tyrePosition == CarLocation.FRONT_RIGHT) {
            return tyreSpeeds[1].getValue();
        } else if (tyrePosition == CarLocation.REAR_LEFT) {
            return tyreSpeeds[2].getValue();
        } else if (tyrePosition == CarLocation.REAR_RIGHT) {
            return tyreSpeeds[3].getValue();
        } else {
            throw new IllegalArgumentException(Integer.toString(tyrePosition) + " is an illegal car geometry for tyre speed.");
        }
    }

    /**
     * Gets oil temperature of given tyre
     *
     * @param tyrePosition position of tyre
     * @return waterBlock value
     */
    public double getWaterBlock(int tyrePosition) {
        if (tyrePosition == CarLocation.FRONT_LEFT) {
            return waterBlocks[0].getValue();
        } else if (tyrePosition == CarLocation.FRONT_RIGHT) {
            return waterBlocks[1].getValue();
        } else if (tyrePosition == CarLocation.REAR_LEFT) {
            return waterBlocks[2].getValue();
        } else if (tyrePosition == CarLocation.REAR_RIGHT) {
            return waterBlocks[3].getValue();
        } else {
            throw new IllegalArgumentException(Integer.toString(tyrePosition) + " is an illegal car geometry for water block.");
        }
    }

    /**
     * Gets new ati core value
     *
     * @return atiCore value
     */
    public double getAtiCore() {
        return atiCore.getValue();
    }

    /**
     * Sets new ati core value
     *
     * @param atiCore value
     */
    public void setAtiCore(double atiCore) {
        this.atiCore = new CarValue(atiCore);
    }

    /**
     * Gets oil temperature of given tyre
     *
     * @param tyrePosition position of tyre
     * @return ati value
     */
    public double getAtis(int tyrePosition) {
        if (tyrePosition == CarLocation.FRONT_LEFT) {
            return atis[0].getValue();
        } else if (tyrePosition == CarLocation.FRONT_RIGHT) {
            return atis[1].getValue();
        } else if (tyrePosition == CarLocation.REAR_LEFT) {
            return atis[2].getValue();
        } else if (tyrePosition == CarLocation.REAR_RIGHT) {
            return atis[3].getValue();
        } else {
            throw new IllegalArgumentException(Integer.toString(tyrePosition) + " is an illegal car geometry for TI.");
        }
    }
}
