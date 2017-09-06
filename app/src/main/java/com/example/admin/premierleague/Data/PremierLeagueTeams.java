package com.example.admin.premierleague.Data;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by admin on 2017/08/29.
 */

public class PremierLeagueTeams {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("teams")
    @Expose
    private List<Team> teams = null;


    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }


}
