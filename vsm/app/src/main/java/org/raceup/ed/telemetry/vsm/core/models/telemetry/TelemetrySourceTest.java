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

package org.raceup.ed.telemetry.vsm.core.models.telemetry;

import com.sirfoga.hal.streams.telemetry.TelemetryDataSource;
import com.sirfoga.hal.streams.telemetry.data.Data;

import org.raceup.ed.telemetry.vsm.core.models.CarLocation;
import org.raceup.ed.telemetry.vsm.core.models.data.CarDataType;
import org.raceup.ed.telemetry.vsm.core.models.data.CarTelemetryData;

import java.io.PrintStream;

/**
 * Tester for a TelemetrySource
 */
public class TelemetrySourceTest extends TelemetryDataSource implements Runnable {
    private Data currentTelemetryData;
    private int msSerialIntervalUpdate = 200;

    private volatile boolean amIStarted = false;  // start and stop management
    private volatile boolean amIPaused = false;
    private volatile boolean amIStopped = false;

    public TelemetrySourceTest() {
        //
    }

    @Override
    public void start() {
        if (!amIStopped && !amIStarted) {  // only when i'm not stopped
            amIStarted = true;  // start updating

            if (!amIPaused) {  // first time
                new Thread(this, this.getClass().getName()).start();  // start in new thread
            }
        }
    }

    @Override
    public void pause() {
        amIStarted = false;  // stop updating
        amIPaused = true;
    }

    @Override
    public void stop() {
        amIStarted = false;
        amIPaused = false;
        amIStopped = true;
    }

    /**
     * Monitoring BMS
     * 1) read newest value from serial
     * 2) updateOrFail series values in BMS model
     * 3) loop
     */
    public void run() {  // exit thread only when stopped
        while (!amIStopped) {
            while (amIStarted) {
                updateOrFail();
            }
        }
    }

    /**
     * Fetches new data from canbus and updates model
     */
    private void updateOrFail() {
        // generate random values
        double value = Math.random() * 90.0 - Math.random() * 90.0;
        int location = CarLocation.FRONT_LEFT;  // (int) (Math.random() * 10.0);
        int type = CarDataType.TEMPERATURE;  // (int) (Math.random() * 10.0);
        long currentMs = System.currentTimeMillis();
        int timeLoggingMs = (int) Math.abs(currentMs % 1000000);  // sample time of logging

        // raw data created with sample values
        String data = "{\"value\":\"" + Double.toString(value) + "\",\"location\":\"" + Integer.toString(location) + "\",\"type\":\"" + Integer.toString(type) + "\",\"time\":\"" + Integer.toString(timeLoggingMs) + "\"}";

        try {
            currentTelemetryData = new Data(data);
            sendTelemetryData(new CarTelemetryData(currentTelemetryData.getRawData()));

            Thread.sleep(msSerialIntervalUpdate);  // wait next update
        } catch (Exception e) {
            System.err.println("TelemetrySourceTest.updateOrFail: " + e.toString());
            e.printStackTrace(new PrintStream(System.err));
        }
    }
}
