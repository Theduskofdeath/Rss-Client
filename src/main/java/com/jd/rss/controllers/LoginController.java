package com.jd.rss.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import com.jd.rss.module.user.User_Creds;
import com.jd.rss.module.Actions.Auth;

public class LoginController
{

    @FXML
    private TextField Login_Field;

    @FXML
    private PasswordField Password_Field;

    @FXML
    private Button Register_Button;

    @FXML
    private Button SignIn_Button;


    public void initialize()
    {



        SignIn_Button.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                String  _susername;
                String  _spassword;
                Auth    signin = new Auth();

                _susername = Login_Field.getText();
                _spassword = Password_Field.getText();
                System.out.println("Login");
                System.out.println("username = " + _susername);
                System.out.println("password = " + _spassword);
                if (signin.register(_susername, _spassword).equals("KO"))
                {
                    System.out.println("Register Failed");
                }
                else
                {
                }
            }
        });

        Register_Button.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                String  _rusername;
                String  _rpassword;
                _rusername = Login_Field.getText();
                _rpassword = Password_Field.getText();
                System.out.println("Register");
                System.out.println("username = " + _rusername);
                System.out.println("password = " + _rpassword);
            }
        });
    }

    @FXML
    void register(ActionEvent event) {

    }

    @FXML
    void signin(ActionEvent event) {

    }
}