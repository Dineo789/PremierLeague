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
import com.example.admin.premierleague.ListAdapters.GeneralFixturesAdapter;
import com.example.admin.premierleague.ListAdapters.TeamFixtureAdapter;
import com.example.admin.premierleague.RESTful.ApiUtils;
import com.example.admin.premierleague.RESTful.SOService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/09/07.
 */

public class TeamFixtureFragment extends Fragment {
    private RecyclerView recyclerView;
    private TeamFixtureAdapter fixturesAdapter;
    private SOService mService;
    private final static String API_KEY = "8ab44a21a9f94cc08dbe16a1753b7cc5";
    String url;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
// Inflate the layout for this fragment
        view = inflater.inflate(R.layout.team_fixtures_fragment, container, false);

        mService = ApiUtils.getSOService();
        recyclerView = (RecyclerView) view.findViewById(R.id.team_fixtures_list);
        fixturesAdapter = new TeamFixtureAdapter(getActivity(), new ArrayList<Fixture>(0));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(fixturesAdapter);
        Bundle bundle = getActivity().getIntent().getExtras();//call activity first
        url = bundle.getString("teamfixture_url");
        displayFixture();
        return view;
    }

    private void displayFixture() {
        Log.d("TeamFixtureFragment", "Inside displayFixture()");

        mService.getTeamFixtures(API_KEY,url).enqueue(new Callback<PremierLeagueFixtures>() {
            @Override
            public void onResponse(Call<PremierLeagueFixtures> call, Response<PremierLeagueFixtures> response) {
                if (response.isSuccessful()) {
                    Log.i("FixtureFragment", "Fixtures " + response.body().getFixtures() + " \n");
                    //fixturesAdapter.getFootBallFixtures(response.body().getTeamFixtures());//needs to get Teams fixtures from PremierLeague
                    fixturesAdapter.getFootBallFixtures(response.body().getFixtures());
                } else {
                    int statusCode = response.code();

                    Log.d("TeamFixtureFragment", "Status code: " + statusCode);
                }
            }

            @Override
            public void onFailure(Call<PremierLeagueFixtures> call, Throwable t) {
                Log.d("TeamFixtureFragment", "OnFailure Message : " + t.getMessage());
            }


        });
    }
}
