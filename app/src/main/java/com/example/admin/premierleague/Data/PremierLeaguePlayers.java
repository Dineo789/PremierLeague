package com.example.admin.premierleague.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by admin on 2017/08/31.
 */

public class PremierLeaguePlayers {


    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("players")
    @Expose
    private List<Player> players = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }


}
