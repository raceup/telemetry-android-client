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

package com.sirfoga.hal.streams.telemetry;

import com.sirfoga.hal.streams.telemetry.data.Data;

import java.util.ArrayList;

/**
 * Someone that gives telemetry data away
 */
public abstract class TelemetryDataSource {
    private ArrayList<TelemetryDataListener> listeners = new ArrayList<>(0);

    /**
     * Start reading data from input
     */
    public abstract void start();

    /**
     * Pause reading data from input
     */
    public abstract void pause();

    /**
     * Close input
     */
    public abstract void stop();

    /**
     * Adds listener to list of listeners of who wants to keep updated with new data events
     *
     * @param listener listener to add to list
     */
    public void addListener(TelemetryDataListener listener) {
        listeners.add(listener);
    }

    /**
     * Notifies everybody that may be interested that new telemetry data has arrived
     *
     * @param data new telemetry data
     */
    public void sendTelemetryData(Data data) {
        for (TelemetryDataListener l : listeners) {
            l.dataEvent(data);
        }
    }
}
