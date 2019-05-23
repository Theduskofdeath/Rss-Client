package com.jd.rss.controllers;

import com.google.gson.Gson;
import com.jd.rss.module.user.User_Info;
import com.jd.rss.module.user.User_Session;
import com.jd.rss.module.utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import com.jd.rss.module.Actions.Users;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;


public class ProfileViewController implements Initializable
{
    @FXML
    private Label Role_Label;

    @FXML
    private Label Username_Label;

    @FXML
    private Button Logout_Button;

    @FXML
    private Button FavEdit_Button;

    @FXML
    private Button BackToMain_Button;

    private User_Info   user_info;
    private Users   users = new Users();


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        String rez = users.me();
        Gson gson = new Gson();
        if (rez.equals("KO"))
        {
            System.out.println("Request (me) Failed");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Request Failed");
            alert.setContentText("Ooops, there was an error! Check your internet connection");
        }
        user_info = gson.fromJson(rez, User_Info.class);
        Username_Label.setText(user_info.getUsername());
        Role_Label.setText(user_info.getRoles().toString());
    }

    private void notConnected(ActionEvent event) throws IOException
    {
        URL url = Paths.get("src/main/ressources/Views/Login_View.fxml").toUri().toURL();
        Parent toMainView = FXMLLoader.load(url);
        Scene mainViewScene = new Scene(toMainView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(mainViewScene);
    }

    @FXML
    void logout(ActionEvent event) throws IOException
    {
        Utils _u = new Utils();
        Preferences pref = Preferences.userNodeForPackage(User_Session.class);

        pref.remove("Token");
        _u.changeWindowOnAction("src/main/ressources/Views/Login_View.fxml", event);
    }

    @FXML
    void toMainView(ActionEvent event) throws IOException
    {
        URL url = Paths.get("com/jd/rss/controllers/Main_View.fxml").toUri().toURL();
        Parent toMainView = FXMLLoader.load(url);
        Scene mainViewScene = new Scene(toMainView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(mainViewScene);
    }
}
