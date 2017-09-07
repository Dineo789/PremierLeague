package com.example.admin.premierleague.ListAdapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.premierleague.Data.Fixture;
import com.example.admin.premierleague.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2017/08/30.
 */

public class GeneralFixturesAdapter extends RecyclerView.Adapter<GeneralFixturesAdapter.MyViewHolder> {

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

    public GeneralFixturesAdapter(Context context, List<Fixture> fixtureList) {
        this.context = context;
        this.fixtureList = fixtureList;
    }

    @Override
    public GeneralFixturesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fixture_item, parent, false);


        return new GeneralFixturesAdapter.MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(GeneralFixturesAdapter.MyViewHolder holder, int position) {


        Fixture team = fixtureList.get(position);
        Date d = new Date();

        //Change date format
        String dtStart = team.getDate();
        SimpleDateFormat currentDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
        try {
             d = currentDateFormat.parse(dtStart);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        holder.teamHome.setText(team.getHomeTeamName());
        holder.teamHomeScore.setText(team.getResult().getGoalsHomeTeam());
        holder.teamAway.setText(team.getAwayTeamName());
        //Attempt to handle null values
        if(team.getAwayTeamName()== null){
            holder.teamAway.setText("Null");
        }
        holder.date.setText(dateFormat.format(d));
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
