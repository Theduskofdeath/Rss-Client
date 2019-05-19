package com.jd.rss.module;

import com.jd.rss.module.network.network;
import com.jd.rss.module.user.User_Creds;
import com.jd.rss.module.user.User_Session;

import io.vertx.core.json.JsonObject;
import org.json.JSONObject;

public class Login
{
    String usern;
    String passwd;

    User_Creds cred = new User_Creds();
    User_Session sess = new User_Session();

    network client = new network();

    JsonObject  obj;

    public void login()
    {}
}
