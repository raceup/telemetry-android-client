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

package org.raceup.ed.telemetry.vsm.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;

import org.raceup.ed.telemetry.vsm.R;
import org.raceup.ed.telemetry.vsm.dialog.AboutDialog;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupFabActions();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            openSettingsActivity();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_race_standings) {
            openRaceStandingsActivity();
        } else if (id == R.id.nav_race_conditions) {
            openRaceConditionsActivity();
        } else if (id == R.id.nav_real_time) {
            openRealTimeTelemetryActivity();
        } else if (id == R.id.nav_cached) {
            openCachedDataTelemetryActivity();
        } else if (id == R.id.nav_alerts) {
            openAlertsActivity();
        } else if (id == R.id.nav_webpage) {
            openWebpage("http://www.raceup.it");
        } else if (id == R.id.nav_manage) {
            openSettingsActivity();
        } else if (id == R.id.nav_share) {
            openShareActivity();
        } else if (id == R.id.nav_about) {
            openAboutDialog();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void openRaceStandingsActivity() {
        Intent openActivity = new Intent(MainActivity.this, RaceStandingsActivity.class);
        startActivity(openActivity);
    }

    private void openRaceConditionsActivity() {
        Intent openActivity = new Intent(MainActivity.this, RaceConditionsActivity.class);
        startActivity(openActivity);
    }

    private void openRealTimeTelemetryActivity() {
        Intent openActivity = new Intent(MainActivity.this, RealTimeTelemetryActivity.class);
        startActivity(openActivity);
    }

    private void openCachedDataTelemetryActivity() {
        Intent openActivity = new Intent(MainActivity.this, CachedDataTelemetryActivity.class);
        startActivity(openActivity);
    }

    private void openAlertsActivity() {
        Intent openActivity = new Intent(MainActivity.this, AlertsActivity.class);
        startActivity(openActivity);
    }

    private void openWebpage(String url) {
        Intent openActivity = new Intent(
                "android.intent.action.VIEW",
                Uri.parse(url)
        );
        startActivity(openActivity);
    }

    private void openSettingsActivity() {
        Intent openActivity = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(openActivity);
    }

    private void openShareActivity() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Hey! Have you checked out the Race UP Electric Division App? It shows telemetry data about the Origin-e car! Download it from here: https://github.com/raceup/telemetry-android-client/blob/master/vsm/app/build/outputs/apk/app-debug.apk?raw=true");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    private void openAboutDialog() {
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View aboutDialogView = inflater.inflate(R.layout.about_dialog, null);
        TextView infoText = (TextView) aboutDialogView.findViewById(R.id.info_text_about_dialog);
        infoText.setText(
                Html.fromHtml(
                        "<h3>" +
                                "VSM: Vehicle System Monitor" +
                                "</h3>\n" +
                                "<i>Telemetry client of Race UP Origin-e car</i><br>\n" +
                                "Version 0.1<br>\n" +
                                "Copyright (C) 2017<br>\n" +
                                "<b>Race UP Electric Division</b><br><br>\n" +
                                "info@raceup.it"
                )
        );

        // set legal text
        TextView legalText = (TextView) aboutDialogView.findViewById(R.id.legal_text_about_dialog);
        legalText.setText(Html.fromHtml(
                "Copyright (C) Race UP Electric Division 2017. <b>All rights reserved.</b>\n" +
                        "Unauthorized copying of this file, via any medium is strictly prohibited."));
        AboutDialog dialog = new AboutDialog(MainActivity.this, "", aboutDialogView);
        dialog.show();
    }

    private void setupFabActions() {
        FloatingActionButton fabMenuWifi = (FloatingActionButton) findViewById(R.id.fab_menu_wifi);
        fabMenuWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Create telemetry choice Wi-Fi action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FloatingActionButton fabMenuLogFile = (FloatingActionButton) findViewById(R.id.fab_menu_log_file);
        fabMenuLogFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Create telemetry choice .csv log file action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
