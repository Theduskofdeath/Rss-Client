package com.jd.rss.module.Actions;


import com.google.gson.Gson;

import com.jd.rss.module.user.User_Creds;
import com.jd.rss.module.network.network;
import org.springframework.http.HttpStatus;


public class Auth
{
    private network client = new network("");
    private User_Creds  uc = new User_Creds();

    public String register(String username, String password)
    {

        Gson objson = new Gson();
        String  json;

        uc.setUsername(username);
        uc.setPassword(password);
        json = objson.toJson(uc);
        client.post("/auth/register", json);
        if (client.getStatus() == HttpStatus.CREATED)
        {
            System.out.println("Created user " + username);
            return "OK";
        }
        System.out.println("User creation Failed");
        return "KO";
    }

    public String signin(String username, String password)
    {
        Gson objson = new Gson();
        String  json;
        String  rez;

        uc.setUsername(username);
        uc.setPassword(password);
        json = objson.toJson(uc);
        rez = client.post("/auth/signin", json);
        if (rez != null)
        {
            System.out.println("connection is a success");
            return rez;
        }
        System.out.println("Connection Failed");
        return "KO";
    }
}
