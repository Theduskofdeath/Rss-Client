package com.jd.rss.module.user;

import java.util.List;

public class User_Info
{
    private String username;
    private List<String> roles;
    private List<String> preferredFeeds;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public List<String> getRoles()
    {
        return roles;
    }

    public void setRoles(List<String> roles)
    {
        this.roles = roles;
    }

    public List<String> getPreferredFeeds()
    {
        return preferredFeeds;
    }

    public void setPreferredFeeds(List<String> preferredFeeds)
    {
        this.preferredFeeds = preferredFeeds;
    }
}
