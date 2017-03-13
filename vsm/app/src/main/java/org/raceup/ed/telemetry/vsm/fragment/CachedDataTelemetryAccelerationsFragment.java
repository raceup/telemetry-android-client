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

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;

import org.raceup.ed.telemetry.vsm.R;

/**
 * Fragment with accelerations and yaw rate chart
 */

public class CachedDataTelemetryAccelerationsFragment extends Fragment {
    private View mFragmentView;
    private LineChart chart;

    public CachedDataTelemetryAccelerationsFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mFragmentView = inflater.inflate(R.layout.fragment_cached_data_telemetry_accelerations, container, false);

        chart = (LineChart) mFragmentView.findViewById(R.id.chart);  // get ui references
        setupChart();

        return mFragmentView;
    }

    private void setupChart() {
        Legend legend = chart.getLegend();
        XAxis xAxis = chart.getXAxis();
        xAxis.setDrawGridLines(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(getResources().getColor(R.color.grey_3));
        xAxis.setAvoidFirstLastClipping(true);
        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.removeAllLimitLines();
        leftAxis.setTextColor(getResources().getColor(R.color.grey_3));
        leftAxis.setStartAtZero(false);
        leftAxis.disableGridDashedLine();
        leftAxis.setDrawGridLines(false);
        leftAxis.setDrawLimitLinesBehindData(true);
        chart.getAxisRight().setEnabled(false);
        chart.setBackgroundColor(Color.parseColor("#FFFFFF"));  // white
        // TODO chart.setDescription("");
        chart.setGridBackgroundColor(Color.parseColor("#FFFFFF"));  // white
        legend.setEnabled(false);
    }
}
