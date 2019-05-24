package com.jd.rss.module.Actions;

import com.jd.rss.module.classic.Feed;
import com.jd.rss.module.network.network;
import com.jd.rss.module.Feed.SendFeed;

import com.jd.rss.module.user.User_Session;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import com.google.gson.Gson;

import java.util.prefs.Preferences;

public class Feeds
{
    private Preferences pref;
    private network client;
    HttpHeaders headers;

    public Feeds()
    {
        headers = new HttpHeaders();
        pref = Preferences.userNodeForPackage(User_Session.class);
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", "Bearer " + pref.get("Token", ""));
        client = new network(headers);
    }

    public String Feeds()
    {
        String  rez;

        rez = client.get("/feeds");
        if (rez != null)
        {
            System.out.println("Request Get Feeds : OK");
            return rez;
        }
        System.out.println("Request Get Feeds : Failed");
        return "KO";
    }

    public String getSecificFeed(String feed_id)
    {
        String rez;

        rez = client.get("/feeds/" + feed_id);
        if (rez != null)
        {
            System.out.println("Request Get Specific Feeds : OK");
            return rez;
        }
        System.out.println("Request Get Specific Feeds : Failed");
        return "KO";
    }

    public String addNewFeed(final String feed_uri)
    {
        Gson objson = new Gson();
        String  json;
        SendFeed obj = new SendFeed();

        obj.setUri(feed_uri);
        json = objson.toJson(obj);
        client.post("/feeds", json);
        if (client.getStatus() == HttpStatus.CREATED)
        {
            System.out.println("Send New Feed : OK");
            return "OK";
        }
        System.out.println("Send New Feed  : Request Failed");
        return "KO";
    }

    public void deleteFeed(final String feed_id)
    {
        client.delete("/feeds/" + feed_id);
        if (client.getStatus() == HttpStatus.NO_CONTENT)
        {
            System.out.println("Feeds " + feed_id + " has been deleted");
        }
        else
            System.out.println("Feeds " + feed_id + " don't exist");
    }
}
