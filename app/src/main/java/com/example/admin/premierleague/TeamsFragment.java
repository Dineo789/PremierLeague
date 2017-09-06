package com.example.admin.premierleague;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.premierleague.Data.PremierLeagueTeams;
import com.example.admin.premierleague.Data.Team;
import com.example.admin.premierleague.ListAdapters.TeamsAdapter;
import com.example.admin.premierleague.RESTful.ApiUtils;
import com.example.admin.premierleague.RESTful.SOService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by admin on 2017/08/28.
 * <p>
 * Download Glide and Retrofit dependecies and display teams
 */

public class TeamsFragment extends Fragment {
    //private View view; //retrofit in here
    private RecyclerView recyclerView;
    private TeamsAdapter teamsAdapter;
    private ProgressBar showProgress;
    private TextView noConnectionMsg;
    private SOService mService;
    private final static String API_KEY = "8ab44a21a9f94cc08dbe16a1753b7cc5";
    //7ecbf6437a9d4342bfb4db6edc960136

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
// Inflate the layout for this fragment
        view = inflater.inflate(R.layout.teams_fragment, container, false);

        mService = ApiUtils.getSOService();
        recyclerView = (RecyclerView) view.findViewById(R.id.team_list);
        showProgress = (ProgressBar) view.findViewById(R.id.team_Progressbar);
        noConnectionMsg = (TextView) view.findViewById(R.id.no_connection);
        noConnectionMsg.setVisibility(View.GONE);

        // showProgress.setVisibility(View.VISIBLE);
        teamsAdapter = new TeamsAdapter(getActivity(), new ArrayList<Team>(0), new TeamsAdapter.PostItemListener() {
            @Override
            public void onPostClick(long id) {
                // Toast.makeText(getActivity(), "id"+ id, Toast.LENGTH_SHORT).show();
                // passTeamInfo();

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(teamsAdapter);
        displayTeams();

      /*  try {
            displayTeams();
           // showProgress.setVisibility(View.GONE);

        }catch (Exception c){
            showProgress.setVisibility(View.GONE);
            noConnectionMsg.setVisibility(View.VISIBLE);

        }*/


        return view;
    }

    private void displayTeams() {
        Log.i("TeamActivity", "Inside displayTeams()");

        mService.getTeams(API_KEY).enqueue(new Callback<PremierLeagueTeams>() {
            @Override
            public void onResponse(Call<PremierLeagueTeams> call, Response<PremierLeagueTeams> response) {
                if (response.isSuccessful()) {
                    Log.i("TeamActivity", "Teams " + response.body().getTeams() + " \n");
                    teamsAdapter.getFootBallTeams(response.body().getTeams());
                } else {
                    int statusCode = response.code();
                    showProgress.setVisibility(View.VISIBLE);

                    Log.i("MainActivity", "Teams " + response.body().getTeams() + " \n");
                }
            }

            @Override
            public void onFailure(Call<PremierLeagueTeams> call, Throwable t) {
                Log.d("MainActivity", "Message: " + t.getMessage());
            }


        });


    }

    private void passTeamInfo() {
        Team item = new Team();
        Intent i = new Intent(getActivity(), TeamActivity.class);
        i.putExtra("team_name", item.getName());
        //i.putExtra("datumTodoa", item.getRecordDate());
        // i.putExtra("idTodoa", item.getItemId());
        getActivity().startActivity(i);
    }
}
