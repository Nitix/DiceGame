package fr.miage.moureypierson.dicegame.controller;

import fr.miage.moureypierson.dicegame.model.Joueur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Asus on 23/01/2017.
 */
public class LoginController implements Initializable {

    @FXML
    private Button start;

    @FXML
    private TextField prenom;

    @FXML
    private TextField nom;

    private Stage stage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        start.setDefaultButton(true);
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Joueur user = new Joueur(nom.getText(), prenom.getText());
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vues/jeu.fxml"));
                Parent root = null;
                try {
                    root = fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                stage.setTitle("Dice Game");
                stage.setScene(new Scene(root, 600, 400));
                GameController controller = fxmlLoader.getController();
                controller.setStage(stage);
                controller.setJoueur(user);
                stage.show();
            }
        });
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
