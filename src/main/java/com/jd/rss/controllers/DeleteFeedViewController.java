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

public class DeleteFeedViewController implements Initializable
{
    @FXML
    private Button Delete_Executor;

    @FXML
    private TextArea DeleteFeed_Area;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }

    @FXML
    private void deleteFeed(ActionEvent event) throws IOException
    {
        Feeds f_to_delete = new Feeds();
        String f_id;
        Utils _u = new Utils();

        f_id = DeleteFeed_Area.getText();
        f_to_delete.deleteFeed(f_id);
        _u.changeWindowOnAction("src/main/ressources/Views/Main_View.fxml", event);
    }
}
