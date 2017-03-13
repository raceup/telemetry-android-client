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

package org.raceup.ed.telemetry.vsm.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import org.raceup.ed.telemetry.vsm.R;
import org.raceup.ed.telemetry.vsm.fragment.CachedDataTelemetryAccelerationsFragment;
import org.raceup.ed.telemetry.vsm.fragment.CachedDataTelemetryTyreSpeedsFragment;
import org.raceup.ed.telemetry.vsm.fragment.CachedDataTelemetryTyreTemperaturesFragment;

/**
 * Pager for CachedDataTelemetry activity
 */

public class CachedDataTelemetryPagerAdapter extends FragmentPagerAdapter {
    private Context context;

    public CachedDataTelemetryPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new CachedDataTelemetryTyreSpeedsFragment();
        } else if (position == 1) {
            return new CachedDataTelemetryTyreTemperaturesFragment();
        } else {
            return new CachedDataTelemetryAccelerationsFragment();
        }
    }

    @Override
    public int getCount() {
        // number of pages
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.cached_data_telemetry_fragment_tyres_speeds);
            case 1:
                return context.getString(R.string.cached_data_telemetry_fragment_tyres_temperatures);
            case 2:
                return context.getString(R.string.cached_data_telemetry_fragment_accelerations);
        }
        return null;
    }
}
