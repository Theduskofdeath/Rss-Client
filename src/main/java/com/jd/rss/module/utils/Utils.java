package com.jd.rss.module.utils;

import com.jd.rss.module.user.User_Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.prefs.Preferences;

public class Utils
{
    public void changeWindowOnAction(String nextView, ActionEvent event) throws IOException
    {
        URL url = Paths.get(nextView).toUri().toURL();
        Parent toNextView = FXMLLoader.load(url);
        Scene mainViewScene = new Scene(toNextView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(mainViewScene);
        window.show();
    }

    public void changeWindowWithParametersOnAction(String nextView, ActionEvent event) throws IOException
    {
        URL url = Paths.get(nextView).toUri().toURL();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(url);
        Parent toNextView = loader.load();
        Scene mainViewScene = new Scene(toNextView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(mainViewScene);
        window.show();
    }

    public void logoutFunc(ActionEvent event) throws IOException
    {
        Utils _u = new Utils();
        Preferences pref = Preferences.userNodeForPackage(User_Session.class);

        pref.remove("Token");
        _u.changeWindowOnAction("src/main/ressources/Views/Login_View.fxml", event);
    }
}
