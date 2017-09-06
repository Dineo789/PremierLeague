package com.example.admin.premierleague;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by admin on 2017/08/28.
 * Loads the home page with tabs
 */

public class HomeActivity extends AppCompatActivity {
    TextView textView;
    ImageView logo;
    private FragmentTabHost tabHost;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        setTheme(android.R.style.Theme);//adds theme dynamically
        logo = (ImageView) findViewById(R.id.logo);


        tabHost = (FragmentTabHost) findViewById(R.id.tabhost);

        tabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        tabHost.addTab(
                tabHost.newTabSpec("tab1").setIndicator("Teams", null),
                TeamsFragment.class, null);
        tabHost.addTab(
                tabHost.newTabSpec("tab2").setIndicator("Competitions", null),
                FixtureFragment.class, null);
        tabHost.addTab(
                tabHost.newTabSpec("tab3").setIndicator("Fixtures", null),
                FixtureFragment.class, null);
        for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {//keeps track of the tabs and apply style
            tabHost.getTabWidget().getChildTabViewAt(i).setBackgroundResource(R.drawable.tab_indicator);
        }


    }
}
