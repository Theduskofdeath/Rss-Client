package com.jd.rss.module.Actions;

import com.google.gson.Gson;
import com.jd.rss.module.Feed.SendFavFeed;
import com.jd.rss.module.network.network;
import com.jd.rss.module.user.User_Session;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Arrays;
import java.util.prefs.*;

public class Users
{
    private Preferences pref = Preferences.userNodeForPackage(User_Session.class);
    private network client = new network(pref.get("Token", ""));

    public String me()
    {
        String  rez;

        rez = client.post("/users/me", "");
        if (rez != null)
        {
            System.out.println("Request OK for Profle");
            return rez;
        }
        System.out.println("Request Failed");
        return "KO";
    }

    public String favFeeds_update(String feed_id)
    {
        Gson objson = new Gson();
        SendFavFeed fav = new SendFavFeed();
        String[]  parsed = feed_id.split("\\s+|,\\s*");
        List<String>    tmp = Arrays.asList(parsed);
        String  json;

        fav.setPreferredFeeds(tmp);
        json = objson.toJson(fav);
        client.put("/users/me/feeds", json);
        if (client.getStatus() == HttpStatus.NO_CONTENT)
        {
            System.out.println("Update Fav List : OK");
            return "OK";
        }
        System.out.println("Update Fav : Request Failed");
        return "KO";
    }
}


//TODO Ajout méthode conservation token