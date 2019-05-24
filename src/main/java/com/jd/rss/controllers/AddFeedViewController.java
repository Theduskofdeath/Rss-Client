package com.jd.rss.controllers;

import com.jd.rss.module.Actions.Feeds;
import com.jd.rss.module.utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddFeedViewController implements Initializable
{
    @FXML
    private Button sendNewFeed;

    @FXML
    private TextArea insertFeedUrlArea;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }

    @FXML
    private void sendFeed(ActionEvent event) throws IOException
    {
        String result;
        Feeds feeds = new Feeds();
        String newfeed;
        Utils _u = new Utils();

        newfeed = insertFeedUrlArea.getText();
        result = feeds.addNewFeed(newfeed);
        if (result.equals("KO"))
        {

        }
        else
            _u.changeWindowOnAction("src/main/ressources/Views/Main_View.fxml", event);
    }
}
