package com.example.admin.premierleague.RESTful;

import com.example.admin.premierleague.Data.PremierLeagueFixtures;
import com.example.admin.premierleague.Data.PremierLeaguePlayers;
import com.example.admin.premierleague.Data.PremierLeagueTeams;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Url;

/**
 * Created by admin on 2017/08/29.
 * HTTP method calls
 */

public interface SOService {
    @GET("/v1/competitions/445/teams")
    Call<PremierLeagueTeams> getTeams();

    @GET("/v1/competitions/445/teams")
    Call<PremierLeagueTeams> getTeams(@Header("X-Auth-Token") String apiKey);

    @GET("/v1/teams/57/fixtures")
    Call<PremierLeagueFixtures> getFixtures(@Header("X-Auth-Token") String apiKey);

    @GET
    Call<PremierLeaguePlayers> getPlayers(@Header("X-Auth-Token") String apiKey,@Url String url);//for dynamic url
    @GET
    Call<PremierLeagueFixtures> getTeamFixtures(@Header("X-Auth-Token") String apiKey,@Url String url);

}
