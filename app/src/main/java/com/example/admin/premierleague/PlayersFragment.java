package com.example.admin.premierleague;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.premierleague.Data.Player;
import com.example.admin.premierleague.Data.PremierLeaguePlayers;
import com.example.admin.premierleague.ListAdapters.PlayersAdapter;
import com.example.admin.premierleague.RESTful.ApiUtils;
import com.example.admin.premierleague.RESTful.SOService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/08/28.
 */

public class PlayersFragment extends Fragment {

    private RecyclerView recyclerView;
    private PlayersAdapter playersAdapter;
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

        view = inflater.inflate(R.layout.players_fragment, container, false);

        mService = ApiUtils.getSOService();
        recyclerView = (RecyclerView) view.findViewById(R.id.player_list);
        playersAdapter = new PlayersAdapter(getActivity(), new ArrayList<Player>(0), new PlayersAdapter.PostItemListener() {
            @Override
            public void onPostClick(long id) {


            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(playersAdapter);
        Bundle bundle = getActivity().getIntent().getExtras();//call activity first
        url = bundle.getString("teamplayer_url");
        displayPlayers();
        return view;
    }

    private void displayPlayers() {
        Log.d("FragmentActivity", "Inside displayPlayers()");

        mService.getPlayers(API_KEY, url).enqueue(new Callback<PremierLeaguePlayers>() {
            @Override
            public void onResponse(Call<PremierLeaguePlayers> call, Response<PremierLeaguePlayers> response) {
                if (response.isSuccessful()) {

                    Log.i("PlayersFragment", "Players " + response.body().getPlayers() + " \n");
                    playersAdapter.getTeamPlayers(response.body().getPlayers());
                } else {
                    int statusCode = response.code();

                }
            }

            @Override
            public void onFailure(Call<PremierLeaguePlayers> call, Throwable t) {
                Log.d("PlayersFragment", "Message : " + t.getMessage());
            }


        });
    }
}
