package com.jd.rss.module.network;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.*;

import io.vertx.core.json.JsonObject;
import org.json.*;

import java.io.IOException;
import java.util.Map;

//import java.net.http.HttpClient;

public class Http_Request
{
    private Vertx   vertx = Vertx.vertx();
    private HttpClientOptions options = new HttpClientOptions().
            setProtocolVersion(HttpVersion.HTTP_2).
            setLogActivity(true).
            setSsl(true).
            setUseAlpn(true).
            setTrustAll(true).
            setDefaultHost("localhost").
            setDefaultPort(8080);
    HttpClient  _client = vertx.createHttpClient(options);

    public void     post_request(String uri, Map<String, String> params, String token)
    {
        JsonObject  fullmsg;

        HttpClientRequest  _request = _client.post(uri, response ->
        {
            System.out.println("Received response with status code " + response.statusCode());
        });
        JsonObject  _data;
        try
        {
            if (params != null)
            {
                _data = new JsonObject();
                for (Map.Entry<String, String> param : params.entrySet())
                {
                    _data.put(param.getKey(), param.getValue());
                }
            }
            _request.putHeader("Content-Type", "application/json; charset=UTF-8");
            _request.putHeader("Authorization", "Basic " + token);
            _request.end();
        }
        catch (Exception e)
        {
           e.printStackTrace();
        }

    }

    
}
