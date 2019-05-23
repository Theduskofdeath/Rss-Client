package com.jd.rss;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import com.jd.rss.controllers.LoginController;

import java.net.URL;
import java.nio.file.Paths;
import java.util.prefs.*;

public class Main extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        LoginController controller;

        URL url = Paths.get("src/main/ressources/Views/Login_View.fxml").toUri().toURL();
        Parent root = FXMLLoader.load(url);
        //Parent root = FXMLLoader.load(getClass().getResource("Login_View.fxml"));
        primaryStage.setTitle("Rss Feeds Client");
        //controller = loader.getController();

        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }
}
