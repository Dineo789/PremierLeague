package com.example.admin.premierleague.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by admin on 2017/09/06.
 */

public class TeamLinks {


    @SerializedName("fixtures")
    @Expose
    private FixtureLink fixtures;
    @SerializedName("players")
    @Expose
    private PlayerLink players;


    @SerializedName("homeTeam")
    @Expose
    private HomeTeamLink homeTeam;
    @SerializedName("awayTeam")
    @Expose
    private AwayTeamLink awayTeam;


    public FixtureLink getFixtures() {
        return fixtures;
    }

    public void setFixtures(FixtureLink fixtures) {
        this.fixtures = fixtures;
    }

    public PlayerLink getPlayers() {
        return players;
    }

    public void setPlayers(PlayerLink players) {
        this.players = players;
    }

    public HomeTeamLink getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(HomeTeamLink homeTeam) {
        this.homeTeam = homeTeam;
    }

    public AwayTeamLink getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(AwayTeamLink awayTeam) {
        this.awayTeam = awayTeam;
    }


}
