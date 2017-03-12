package telemetry.ed.raceup.org.vsm.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import telemetry.ed.raceup.org.vsm.R;

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
