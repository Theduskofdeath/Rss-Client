package com.jd.rss.module.Actions;


import com.google.gson.Gson;

import com.jd.rss.module.user.User_Creds;
import com.jd.rss.module.network.network;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class Auth
{
    private HttpHeaders headers;
    private network client;
    private User_Creds  uc = new User_Creds();
    public Auth()
    {
        headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        client = new network(headers);

    }

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
