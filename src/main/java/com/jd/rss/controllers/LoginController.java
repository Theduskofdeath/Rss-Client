package com.jd.rss.controllers;

import com.google.gson.Gson;
import com.jd.rss.module.user.User_Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.prefs.*;

import com.jd.rss.module.Actions.Auth;
import com.jd.rss.Main;
import javafx.stage.Stage;

public class LoginController implements Initializable
{

    @FXML
    private TextField Login_Field;
    @FXML
    private PasswordField Password_Field;
    @FXML
    private Button Register_Button;
    @FXML
    private Button SignIn_Button;

    private Main main;

    private Preferences pref;
    public void initialize(URL url, ResourceBundle bundle)
    {
    }

    @FXML
    void register(ActionEvent event) throws IOException
    {
        String  _rusername;
        String  _rpassword;
        Auth    register = new Auth();

        _rusername = Login_Field.getText();
        _rpassword = Password_Field.getText();
        System.out.println("Register");
        System.out.println("Register username = " + _rusername);
        System.out.println("Register password = " + _rpassword);
        if (register.signin(_rusername, _rpassword).equals("KO"))
        {
            System.out.println("Register Failed");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Register Failed");
            alert.setContentText("Ooops, there was an error! Check your internet connection");
        }
        else
        {
            System.out.println("Register Success");
            login(_rusername, _rpassword, event);
        }
    }

    @FXML
    void signin(ActionEvent event) throws IOException
    {
        String  _susername;
        String  _spassword;


        _susername = Login_Field.getText();
        _spassword = Password_Field.getText();
        System.out.println("Login");
        System.out.println("Sign In username = " + _susername);
        System.out.println("Sign In password = " + _spassword);
        login(_susername, _spassword, event);
    }

    private void login(String _username, String _password, ActionEvent event) throws IOException
    {
        Auth    signin = new Auth();
        User_Session session;
        Gson gson = new Gson();
        String  rez;

        rez = signin.signin(_username, _password);
        if (rez.equals("KO"))
        {
            System.out.println("Sign In Failed");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Sign In Failed");
            alert.setContentText("Ooops, there was an error! Check your internet connection or verify your username OR password");
        }
        else
        {
            System.out.println("Sign In Success");
            session = gson.fromJson(rez, User_Session.class);
            pref = Preferences.userNodeForPackage(User_Session.class);
            pref.put("Token", session.getToken());
            toMainView(event);
        }
    }

    private void toMainView(ActionEvent event) throws IOException
    {
        URL url = Paths.get("com/jd/rss/controllers/Main_View.fxml").toUri().toURL();
        Parent toMainView = FXMLLoader.load(url);
        Scene mainViewScene = new Scene(toMainView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(mainViewScene);
        window.show();

    }
}