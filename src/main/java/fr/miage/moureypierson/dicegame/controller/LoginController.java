package fr.miage.moureypierson.dicegame.controller;

import fr.miage.moureypierson.dicegame.view.GameView;
import fr.miage.moureypierson.dicegame.view.LoginView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Asus on 23/01/2017.
 */
public class LoginController implements Initializable{

    @FXML
    private Button start;

    @FXML
    private TextField prenom;

    @FXML
    private TextField nom;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        start.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println(prenom.getText());
                System.out.println(nom.getText());

            }
        });
    }
}
