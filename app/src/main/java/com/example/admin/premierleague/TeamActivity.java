package com.example.admin.premierleague;


import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.GenericRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.caverock.androidsvg.SVG;
import com.example.admin.premierleague.Data.Team;
import com.example.admin.premierleague.SVGHandler.SvgDecoder;
import com.example.admin.premierleague.SVGHandler.SvgDrawableTranscoder;
import com.example.admin.premierleague.SVGHandler.SvgSoftwareLayerSetter;

import java.io.InputStream;

public class TeamActivity extends AppCompatActivity {

    Button firstFragment, secondFragment;
    TextView teamNameTextview, teamShortNameTextView;
    ImageView logo;
    private FragmentTabHost tabHost;
    Team x = new Team();

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.team);

        final String teamName;
        String teamShortname = null;
        String teamLogo = null;
        final String teamPlayers;

        // Log.i("TeamActivity", "hey");
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            teamName = "No data";
            teamPlayers = "fxg";
        } else {
            teamName = bundle.getString("team_name");
            teamShortname = bundle.getString("team_shortname");
            teamLogo = bundle.getString("team_logo");
            teamPlayers = bundle.getString("team_url");


        }
        //Log.d("TeamActivity", "hey" + teamName);

        setTheme(android.R.style.Theme);//adds theme dynamically
        logo = (ImageView) findViewById(R.id.logo);
        teamShortNameTextView = (TextView) findViewById(R.id.teamA_shortName);
        teamShortNameTextView.setText(teamShortname);
        teamNameTextview = (TextView) findViewById(R.id.teamA_name);
        teamNameTextview.setText(teamName);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("TeamActivity", "hey" + teamName);
                Toast.makeText(TeamActivity.this, "hey " + teamPlayers, Toast.LENGTH_SHORT).show();


            }
        });


        GenericRequestBuilder<Uri, InputStream, SVG, PictureDrawable> requestBuilder = Glide.with(this)
                .using(Glide.buildStreamModelLoader(Uri.class, this), InputStream.class)
                .from(Uri.class)
                .as(SVG.class)
                .transcode(new SvgDrawableTranscoder(), PictureDrawable.class)
                .sourceEncoder(new StreamEncoder())
                .cacheDecoder(new FileToStreamDecoder<SVG>(new SvgDecoder()))
                .decoder(new SvgDecoder())
                .listener(new SvgSoftwareLayerSetter<Uri>());

        requestBuilder
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.mipmap.ic_launcher_round)
                .load(Uri.parse(teamLogo))
                .into(logo);


        tabHost = (FragmentTabHost) findViewById(R.id.teamhost);

        tabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);


        tabHost.addTab(
                tabHost.newTabSpec("tab1").setIndicator("Players", null),
                PlayersFragment.class, null);
        tabHost.addTab(
                tabHost.newTabSpec("tab2").setIndicator("Fixture", null),
                FixtureFragment.class, null);
        for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {//keeps track of the tabs and apply style
            tabHost.getTabWidget().getChildTabViewAt(i).setBackgroundResource(R.drawable.tab_indicator);
        }


    }
}
