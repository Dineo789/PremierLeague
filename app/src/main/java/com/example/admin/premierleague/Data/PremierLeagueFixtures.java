package com.example.admin.premierleague.Data;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by admin on 2017/08/30.
 */

public class PremierLeagueFixtures {


    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("fixtures")
    @Expose
    private List<Fixture> fixtures = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Fixture> getFixtures() {
        return fixtures;
    }

    public void setFixtures(List<Fixture> fixtures) {
        this.fixtures = fixtures;
    }

}

