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

package org.raceup.ed.telemetry.vsm.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.raceup.ed.telemetry.vsm.R;

/**
 * Fragment in RealTimeTelemetry activity to show info about throttle/brakes and steering
 */

public class RealTimeTelemetryThrottleFragment extends Fragment {
    private static final String TAG = "RealTimeTelemetryThrottleFragment";
    private View mFragmentView;

    public RealTimeTelemetryThrottleFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mFragmentView = inflater.inflate(R.layout.fragment_real_time_telemetry_throttle, container, false);
        return mFragmentView;
    }
}

// TODO snippets
// rotate image
/*
import android.graphics.Matrix;
import android.widget.ImageView;
Code: (Assuming imageView, angle, pivotX & pivotY are already defined)

Matrix matrix = new Matrix();
imageView.setScaleType(ImageView.ScaleType.MATRIX);   //required
matrix.postRotate((float) angle, pivotX, pivotY);
imageView.setImageMatrix(matrix);
 */