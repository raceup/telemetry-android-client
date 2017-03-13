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

import android.util.Log;

import com.sirfoga.hal.streams.telemetry.data.Data;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.raceup.ed.telemetry.vsm.core.models.CarLocation;

/**
 * Car data coming from telemetry
 */
public class CarTelemetryData extends Data {
    private static final String TAG = "CarTelemetryData";
    private CarLocation carLocation;  // location of data coming from car
    private CarDataType typeData;  // data type
    private int timeMs;  // time of logging (ms)

    /**
     * New data
     *
     * @param rawData raw data to parse
     */
    public CarTelemetryData(String rawData) {
        super(rawData);  // initialize fields
        try {
            parseRawString();  // parse raw data
        } catch (Exception e) {
            Log.e(TAG, "CarTelemetryData: " + e.toString());
        }
    }

    /**
     * Parses header and value and builds object (useful when parsing static local telemetry files)
     *
     * @param header category of data
     * @param value  value of data
     */
    public CarTelemetryData(String header, String value) {
        super(header + value);
        parseHeader(header);
        this.value = Double.parseDouble(value);
    }

    /**
     * Gets location of data coming from car
     *
     * @return location of data coming from car
     */
    public int getCarLocation() {
        return carLocation.getLocation();
    }

    /**
     * Gets type of data coming from car
     *
     * @return type of data coming from car
     */
    public int getTypeData() {
        return typeData.getDataType();
    }

    /**
     * Gets time of data logging coming from car
     *
     * @return time of data logging coming from car
     */
    public int getTimeMs() {
        return timeMs;
    }

    /**
     * Converts car location and data type to unique name of data
     *
     * @return (human readable) name of data
     */
    public String getName() {
        String name = "";

        if (!carLocation.isUndefined()) {
            name = carLocation.getLocationName() + " ";
        }

        if (!typeData.isUndefined()) {
            name += typeData.getDataName();
        }

        return name;
    }

    /**
     * Parses raw data and updates fields
     */
    private void parseRawString() throws JSONException {
        JSONTokener tokener = new JSONTokener(rawData);
        JSONObject root = new JSONObject(tokener);

        value = Double.parseDouble(root.getString("value"));
        carLocation = new CarLocation(Integer.parseInt(root.getString("location")));
        typeData = new CarDataType(Integer.parseInt(root.getString("type")));
        timeMs = Integer.parseInt(root.getString("time"));
    }

    /**
     * Parses header and updates fields
     *
     * @param header raw data to parse
     */
    private void parseHeader(String header) {
        String[] tokens = header.split(" ");

        if (tokens.length == 1) {
            carLocation = new CarLocation(CarLocation.UNDEFINED);
        } else {
            carLocation = new CarLocation(tokens[1]);
        }

        typeData = new CarDataType(tokens[0]);
    }
}
