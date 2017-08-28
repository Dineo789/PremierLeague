package com.example.admin.premierleague;

import android.app.ActivityGroup;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by admin on 2017/08/28.
 */

public class tabHost extends FragmentActivity{
    TextView textView;
    private FragmentTabHost tabHost;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.some_tabs);
        tabHost = (FragmentTabHost) findViewById(R.id.tabhost);
      //  tabHost.setup();

        /*tabHost = getTabHost();
        TabHost.TabSpec spec = tabHost.newTabSpec("artists").setIndicator("Artists");
               // res.getDrawable(R.drawable.ic_tab_artists))
                Intent i = new Intent(this, MainActivity.class);
                spec.setContent(i);


        TabHost.TabSpec spec1 = tabHost.newTabSpec("movies").setIndicator("Movies");
        // res.getDrawable(R.drawable.ic_tab_artists))
        Intent i2 = new Intent(this, MainActivity.class);
        spec1.setContent(i2);
        tabHost.addTab(spec);
        tabHost.addTab(spec1);
        tabHost.setCurrentTab(1);//sets current tab as second

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                // display the name of the tab whenever a tab is changed
                Toast.makeText(getApplicationContext(), tabId, Toast.LENGTH_SHORT).show();
            }
        });*/


        tabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        tabHost.addTab(
                tabHost.newTabSpec("tab1").setIndicator("Tab 1", null),
                otherFragment.class, null);
        tabHost.addTab(
                tabHost.newTabSpec("tab2").setIndicator("Tab 2", null),
                fragment.class, null);



    }
}
