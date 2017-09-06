package com.example.admin.premierleague.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Created by admin on 2017/08/30.
 */

public class Result {

    @SerializedName("goalsHomeTeam")
    @Expose
    private String goalsHomeTeam;
    @SerializedName("goalsAwayTeam")
    @Expose
    private String goalsAwayTeam;


    public String getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    public void setGoalsHomeTeam(String goalsHomeTeam) {
        this.goalsHomeTeam = goalsHomeTeam;
    }

    public String getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

    public void setGoalsAwayTeam(String goalsAwayTeam) {
        this.goalsAwayTeam = goalsAwayTeam;
    }


}
