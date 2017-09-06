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


}
