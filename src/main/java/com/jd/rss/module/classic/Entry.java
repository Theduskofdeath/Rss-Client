package com.jd.rss.module.classic;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Entry implements Serializable
{

    private Long id;
    private Feed feed;
    private String link;
    private List<Person> authors;
    private List<Category> categories;
    private String comments;
    private List<Person> contributors;
    private List<Link> links;
    private Date publishedDate;
    private String title;
    private Date updatedDate;
    private String uri;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Feed getFeed()
    {
        return feed;
    }

    public void setFeed(Feed feed)
    {
        this.feed = feed;
    }

    public String getLink()
    {
        return link;
    }

    public void setLink(String link)
    {
        this.link = link;
    }

    public List<Person> getAuthors()
    {
        return authors;
    }

    public void setAuthors(List<Person> authors)
    {
        this.authors = authors;
    }

    public List<Category> getCategories()
    {
        return categories;
    }

    public void setCategories(List<Category> categories)
    {
        this.categories = categories;
    }

    public String getComments()
    {
        return comments;
    }

    public void setComments(String comments)
    {
        this.comments = comments;
    }

    public List<Person> getContributors()
    {
        return contributors;
    }

    public void setContributors(List<Person> contributors)
    {
        this.contributors = contributors;
    }

    public List<Link> getLinks()
    {
        return links;
    }

    public void setLinks(List<Link> links)
    {
        this.links = links;
    }

    public Date getPublishedDate()
    {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate)
    {
        this.publishedDate = publishedDate;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Date getUpdatedDate()
    {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate)
    {
        this.updatedDate = updatedDate;
    }

    public String getUri()
    {
        return uri;
    }

    public void setUri(String uri)
    {
        this.uri = uri;
    }
}
