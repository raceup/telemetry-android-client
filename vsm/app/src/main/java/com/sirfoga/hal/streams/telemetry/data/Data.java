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

package com.sirfoga.hal.streams.telemetry.data;

/**
 * Generic telemetry data
 */
public class Data {
    protected String rawData = "";  // raw data as come from stream
    protected double value;  // value of data

    /**
     * New data
     *
     * @param rawData raw data to parse
     */
    public Data(String rawData) {
        this.rawData = rawData;
    }

    /**
     * Gets raw data
     *
     * @return raw data
     */
    public String getRawData() {
        return rawData;
    }

    /**
     * Gets value of data
     *
     * @return value of data
     */
    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        try {
            Data otherData = (Data) other;
            return otherData.getRawData().equals(this.getRawData());
        } catch (Exception e) {
            return false;
        }
    }
}
