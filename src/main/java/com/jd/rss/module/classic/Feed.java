package com.jd.rss.module.classic;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Feed implements Serializable
{

    private String uuid;

    private String title;

    private String link;

    private String sourceFeedUrl;

    private String copyright;

    private String description;

    private List<Person> authors;

    private List<Category> categories;

    private List<Person> contributors;

    private String encoding;

    private List<Entry> entries;

    private String feedType;

    private String generator;

    private String language;

    private List<Link> links;

    private Date publishedDate;

    private String styleSheet;

    private String uri;

    private String webMaster;

    private Date autoUpdatedDate;

}