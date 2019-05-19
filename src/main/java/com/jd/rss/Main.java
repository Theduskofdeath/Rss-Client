package com.jd.rss;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import com.jd.rss.controllers.LoginController;

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

        FXMLLoader  loader = new FXMLLoader(getClass().getResource("src/main/ressources/Views/Login_View.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Rss Feed Client");
        controller = loader.getController();

        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();

    }
}
