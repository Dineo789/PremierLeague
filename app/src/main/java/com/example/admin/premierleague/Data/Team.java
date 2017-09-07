package com.example.admin.premierleague.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.UUID;

/**
 * Created by admin on 2017/08/29.
 */

public class Team {


    @SerializedName("_links")
    @Expose
    private TeamLinks links;


    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("shortName")
    @Expose
    private String shortName;
    @SerializedName("squadMarketValue")
    @Expose
    private String squadMarketValue;
    @SerializedName("crestUrl")
    @Expose
    private String crestUrl;


    public TeamLinks getLinks() {

        return links;
    }

    public void setLinks(TeamLinks links) {
        this.links = links;
    }

    public String returnPlayersUrl() {

        String url = links.getPlayers().getHref();
        return url;
    }
    public String returnFixturesUrl() {

        String url = links.getFixtures().getHref();
        return url;
    }
    public String returnMyFixturesUrl() {

        String url = links.getFixtures().getHref();
        return url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getSquadMarketValue() {
        return squadMarketValue;
    }

    public void setSquadMarketValue(String squadMarketValue) {
        this.squadMarketValue = squadMarketValue;
    }

    public String getCrestUrl() {
        return crestUrl;
    }

    public void setCrestUrl(String crestUrl) {
        this.crestUrl = crestUrl;
    }


}
