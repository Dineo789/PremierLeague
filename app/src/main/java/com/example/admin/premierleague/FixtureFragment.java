package com.example.admin.premierleague;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.premierleague.Data.Fixture;
import com.example.admin.premierleague.Data.PremierLeagueFixtures;
import com.example.admin.premierleague.Data.PremierLeagueTeams;
import com.example.admin.premierleague.Data.Team;
import com.example.admin.premierleague.ListAdapters.FixturesAdapter;
import com.example.admin.premierleague.ListAdapters.TeamsAdapter;
import com.example.admin.premierleague.RESTful.ApiUtils;
import com.example.admin.premierleague.RESTful.SOService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/08/30.
 */

public class FixtureFragment extends Fragment {
    private RecyclerView recyclerView;
    private FixturesAdapter fixturesAdapter;
    private SOService mService;
    private final static String API_KEY = "8ab44a21a9f94cc08dbe16a1753b7cc5";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
// Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fixtures_fragment, container, false);

        mService = ApiUtils.getSOService();
        recyclerView = (RecyclerView) view.findViewById(R.id.fixtures_list);
        fixturesAdapter = new FixturesAdapter(getActivity(), new ArrayList<Fixture>(0));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(fixturesAdapter);
        displayFixture();
        return view;
    }

    private void displayFixture() {
        Log.d("MainActivity", "error loading from API");

        mService.getFixtures(API_KEY).enqueue(new Callback<PremierLeagueFixtures>() {
            @Override
            public void onResponse(Call<PremierLeagueFixtures> call, Response<PremierLeagueFixtures> response) {
                if (response.isSuccessful()) {
                    // Log.i("MainActivity", "Fixtures " + response.body().getFixtures());
                    Log.i("FixtureFragment", "Teams " + response.body().getFixtures() + " \n");
                    fixturesAdapter.getFootBallFixtures(response.body().getFixtures());
                } else {
                    int statusCode = response.code();
                    // handle request errors depending on status code
                    Log.d("MainActivity", "error loading from API");
                }
            }

            @Override
            public void onFailure(Call<PremierLeagueFixtures> call, Throwable t) {
                Log.d("MainActivity", "error loading from API");
            }


        });
    }

}

