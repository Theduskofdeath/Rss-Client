package com.jd.rss.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import com.google.gson.Gson;
import com.jd.rss.module.Actions.Feeds;
import com.jd.rss.module.Actions.Users;
import com.jd.rss.module.classic.Feed;
import com.jd.rss.module.user.User_Info;
import com.jd.rss.module.utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 * Sample Skeleton for 'Main_View.fxml' Controller Class
 */

public class MainViewController
{
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="FavFeedList_List"
    private ListView<Feed> FavFeedList_List; // Value injected by FXMLLoader

    @FXML // fx:id="FeedList_List"
    private ListView<Feed> FeedList_List; // Value injected by FXMLLoader

    @FXML // fx:id="AddFeed_Button"
    private Button AddFeed_Button; // Value injected by FXMLLoader

    @FXML // fx:id="DeleteFeed_Button"
    private Button DeleteFeed_Button; // Value injected by FXMLLoader

    private Feeds n_feeds = new Feeds();
    private Users n_user = new Users();

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize()
    {
        load_feeds();
        load_favfeeds();
        assert FavFeedList_List != null : "fx:id=\"FavFeedList_List\" was not injected: check your FXML file 'Main_View.fxml'.";
        assert FeedList_List != null : "fx:id=\"FeedList_List\" was not injected: check your FXML file 'Main_View.fxml'.";

    }

    private void load_feeds()
    {

        Feed[] list_feed;
        Gson obgson = new Gson();
        String tmp_list;

        tmp_list = n_feeds.Feeds();
        if (tmp_list.equals("KO"))
        {
            //TODO err gest
        }
        list_feed = obgson.fromJson(tmp_list, Feed[].class);
        for (Feed tmp : list_feed)
        {
            FeedList_List.getItems().add(tmp);
        }
    }

    private void load_favfeeds()
    {
        User_Info ui;
        List<String> s_feed;
        Feed[] list_feed;
        Gson obgson = new Gson();
        String tmp_list;
        Feed toBeInserted;

        tmp_list = n_user.me();
        if (tmp_list.equals("KO"))
        {
            //TODO err gest
        }
        ui = obgson.fromJson(tmp_list, User_Info.class);
        s_feed = ui.getPreferredFeeds();
        if (s_feed != null)
        {
            for (String f_tmp : s_feed)
            {
                tmp_list = n_feeds.getSecificFeed(f_tmp);
                toBeInserted = obgson.fromJson(tmp_list, Feed.class);
                FavFeedList_List.getItems().add(toBeInserted);
            }
        }
    }

    @FXML
    private void loadProfile(ActionEvent event) throws IOException
    {
        Utils _u = new Utils();

        _u.changeWindowOnAction("src/main/ressources/Views/Profile_View.fxml", event);
    }

    @FXML
    private void logoutFromMain(ActionEvent event) throws IOException
    {
        Utils _u = new Utils();

        _u.logoutFunc(event);
    }

    @FXML
    private void deleteFeed(ActionEvent event) throws IOException
    {
        Utils _u = new Utils();

        _u.changeWindowOnAction("src/main/ressources/Views/DeleteFeedView.fxml", event);
    }

    @FXML
    private void openWindowToAddANewFeed(ActionEvent event) throws IOException
    {
        Utils _u = new Utils();

        _u.changeWindowOnAction("src/main/ressources/Views/AddFeedView.fxml", event);
    }
}