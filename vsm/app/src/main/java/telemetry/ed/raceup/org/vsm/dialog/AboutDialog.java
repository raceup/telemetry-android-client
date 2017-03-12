package telemetry.ed.raceup.org.vsm.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Show a simple about dialog about your app.
 */

public class AboutDialog {
    private AlertDialog dialog;
    private LayoutInflater inflater;
    private View view;

    public AboutDialog(Activity parentActivity, String title, int layout) {
        dialog = new AlertDialog.Builder(parentActivity).create();
        dialog.setTitle(title);
        dialog.setCanceledOnTouchOutside(true);
        setLayout(parentActivity, layout);
    }

    public AboutDialog(Activity parentActivity, String title, View view) {
        dialog = new AlertDialog.Builder(parentActivity).create();
        dialog.setTitle(title);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setView(view);
    }

    private void setLayout(Activity parentActivity, int layout) {
        inflater = parentActivity.getLayoutInflater();
        view = inflater.inflate(layout, null);  // inflate
        dialog.setView(view);  // set view
    }

    public void show() {
        dialog.show();
    }
}
