package com.example.admin.premierleague.RESTful;

/**
 * Created by admin on 2017/08/29.
 * <p>
 * Holds base api URL
 * enable access to Interface
 */

public class ApiUtils {

    public static final String BASE_URL = "http://api.football-data.org/";

    //http://api.football-data.org/v1/competitions/445/teams
    public static SOService getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }
}
