package com.example.admin.premierleague.ListAdapters;

import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.GenericRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.caverock.androidsvg.SVG;
import com.example.admin.premierleague.Data.Fixture;
import com.example.admin.premierleague.Data.Team;
import com.example.admin.premierleague.R;
import com.example.admin.premierleague.SVGHandler.SvgDecoder;
import com.example.admin.premierleague.SVGHandler.SvgDrawableTranscoder;
import com.example.admin.premierleague.SVGHandler.SvgSoftwareLayerSetter;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2017/08/30.
 */

public class FixturesAdapter extends RecyclerView.Adapter<FixturesAdapter.MyViewHolder> {

    private List<Fixture> fixtureList;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView teamHome, teamAway, teamHomeScore, teamAwayScore, date;


        public MyViewHolder(View view) {
            super(view);
            teamHome = (TextView) view.findViewById(R.id.teamHome);
            teamHomeScore = (TextView) view.findViewById(R.id.teamHome_score);
            teamAway = (TextView) view.findViewById(R.id.teamAway);
            teamAwayScore = (TextView) view.findViewById(R.id.teamAway_score);
            date = (TextView) view.findViewById(R.id.fixture_date);


        }

    }

    public FixturesAdapter(Context context, List<Fixture> fixtureList) {
        this.context = context;
        this.fixtureList = fixtureList;
    }

    @Override
    public FixturesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fixture_item, parent, false);


        return new FixturesAdapter.MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(FixturesAdapter.MyViewHolder holder, int position) {


        Fixture team = fixtureList.get(position);
        Date d = new Date();

        /*Change date format
        String dtStart = team.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
        try {
             d = dateFormat.parse(dtStart);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        */

        holder.teamHome.setText(team.getHomeTeamName());
        holder.teamHomeScore.setText(team.getResult().getGoalsHomeTeam());
        holder.teamAway.setText(team.getAwayTeamName());
        holder.date.setText(team.getDate());
        holder.teamAwayScore.setText(team.getResult().getGoalsAwayTeam());


    }

    @Override
    public int getItemCount() {
        return fixtureList.size();//count = 20
    }

    public void getFootBallFixtures(List<Fixture> team) {
        fixtureList = team;
        notifyDataSetChanged();
    }
}
