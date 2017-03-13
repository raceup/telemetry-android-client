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

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Current telemetry data that is being processed
 */
public class Buffer {
    private HashMap<String, Data> buffer = new HashMap<>(0);  // buffer of telemetry data

    /*
     * Constructors
     */

    /**
     * Constructor with no default headers, nor data
     */
    public Buffer() {
    }

    /**
     * Predefine a buffer with a dictionary
     *
     * @param buffer dictionary
     */
    public Buffer(HashMap<String, Data> buffer) {
        this.buffer = buffer;
    }

    /**
     * Set dictionary headers and data
     *
     * @param headers keys of data
     * @param data    values of dictionary
     */
    public Buffer(ArrayList<String> headers, ArrayList<Data> data) throws IllegalArgumentException {
        setHeadersAndData(headers, data);
    }

    /*
     * Setters
     */

    public void setHeadersAndData(ArrayList<String> headers, ArrayList<Data> data) throws IllegalArgumentException {
        if (headers.size() != data.size()) {
            throw new IllegalArgumentException("Cannot create dictionary with size of keys != size of values!");
        }

        for (int i = 0; i < headers.size(); i++) {
            setData(headers.get(i), data.get(i));
        }
    }

    /**
     * Sets value of given key
     *
     * @param key   key of value
     * @param value value of key
     */
    public void setData(String key, Data value) {
        buffer.put(key, value);
    }

    /*
     * Getters
     */

    /**
     * Gets data with given header
     *
     * @param key key to get data
     * @return value of given key
     */
    public Data getData(String key) {
        return buffer.get(key);
    }

    /**
     * Gets headers in dictionary
     *
     * @return dictionary's values
     */
    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<>(buffer.size());
        headers.addAll(buffer.keySet());
        return headers;
    }

    /*
     * Operations
     */

    /**
     * Checks if header is present in database
     *
     * @param header header to check
     * @return True iff buffer contains given header
     */
    public boolean contains(String header) {
        return buffer.containsKey(header);
    }

    /**
     * Sets to null objects all data (but keeps headers)
     */
    public void empty() {
        for (String header : getHeaders()) {
            setData(header, null);
        }
    }
}
