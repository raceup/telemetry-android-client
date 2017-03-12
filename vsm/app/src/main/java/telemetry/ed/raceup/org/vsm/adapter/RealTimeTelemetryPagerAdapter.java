package telemetry.ed.raceup.org.vsm.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import telemetry.ed.raceup.org.vsm.R;
import telemetry.ed.raceup.org.vsm.fragment.RealTimeTelemetryTemperaturesFragment;
import telemetry.ed.raceup.org.vsm.fragment.RealTimeTelemetryThrottleFragment;
import telemetry.ed.raceup.org.vsm.fragment.RealTimeTelemetryTyresFragment;

/**
 * Pager for RealTimeTelemetry activity
 */
public class RealTimeTelemetryPagerAdapter extends FragmentPagerAdapter {
    private Context context;

    public RealTimeTelemetryPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new RealTimeTelemetryTyresFragment();
        } else if (position == 1) {
            return new RealTimeTelemetryThrottleFragment();
        } else {
            return new RealTimeTelemetryTemperaturesFragment();
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
                return context.getString(R.string.real_time_telemetry_fragment_tyres);
            case 1:
                return context.getString(R.string.real_time_telemetry_fragment_throttle);
            case 2:
                return context.getString(R.string.real_time_telemetry_fragment_temperatures);
        }
        return null;
    }
}