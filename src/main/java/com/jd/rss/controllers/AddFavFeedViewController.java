package com.jd.rss.controllers;

import com.google.gson.Gson;
import com.jd.rss.module.Actions.Users;
import com.jd.rss.module.utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddFavFeedViewController implements Initializable
{
    @FXML
    private Button SendFavFeedList_Button;

    @FXML
    private TextArea FavFeedList_TextArea;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }

    @FXML
    private void sendNewFav(ActionEvent event) throws IOException
    {
        String result;
        Users users = new Users();
        String newfav;
        Utils _u = new Utils();

        newfav = FavFeedList_TextArea.getText();
        //TODO error gest
        result = users.favFeeds_update(newfav);
        if (result.equals("KO"))
        {
            //TODO gest err
        }
        _u.changeWindowOnAction("src/main/ressources/Views/Profile_View.fxml",event);
    }
}
