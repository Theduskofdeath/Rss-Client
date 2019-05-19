package com.jd.rss.controllers;

import java.net.URL;
import java.util.ResourceBundle;
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
    private ListView<?> FavFeedList_List; // Value injected by FXMLLoader

    @FXML // fx:id="FeedList_List"
    private ListView<?> FeedList_List; // Value injected by FXMLLoader

    @FXML // fx:id="AddFeed_Button"
    private Button AddFeed_Button; // Value injected by FXMLLoader

    @FXML // fx:id="DeleteFeed_Button"
    private Button DeleteFeed_Button; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert FavFeedList_List != null : "fx:id=\"FavFeedList_List\" was not injected: check your FXML file 'Main_View.fxml'.";
        assert FeedList_List != null : "fx:id=\"FeedList_List\" was not injected: check your FXML file 'Main_View.fxml'.";
        assert AddFeed_Button != null : "fx:id=\"AddFeed_Button\" was not injected: check your FXML file 'Main_View.fxml'.";
        assert DeleteFeed_Button != null : "fx:id=\"DeleteFeed_Button\" was not injected: check your FXML file 'Main_View.fxml'.";

    }
}