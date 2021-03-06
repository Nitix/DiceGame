package fr.miage.moureypierson.dicegame.controller;

import fr.miage.moureypierson.dicegame.model.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Asus on 23/01/2017.
 */
public class ScoreController implements Initializable {

    private Stage stage;
    private HighScores highScores;

    private boolean isMyScore;

    @FXML
    private Button retour;

    @FXML
    private ListView<String> listeScore;
    private Player player;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        retour.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vues/jeu.fxml"));
                Parent root = null;
                try {
                    root = fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                stage.setTitle("Die Game");
                stage.setScene(new Scene(root, 600, 400));
                GameController controller = fxmlLoader.getController();
                controller.setStage(stage);
                controller.setPlayer(player);
                stage.show();
            }
        });
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setType(boolean isMyScore) {
        this.isMyScore = isMyScore;
        if (isMyScore) {
            initMyScores();
        } else {
            initAllScores();
        }
    }

    private void initMyScores() {
        ObservableList<String> items = FXCollections.observableArrayList();
        String firstname = player.getFirstName();
        String lastName = player.getLastName();
        for (int value : player.getScores()) {
            items.add(firstname + " " + lastName + " : " + value);
        }
        listeScore.setItems(items);
    }

    private void initAllScores() {
        ObservableList<String> items = FXCollections.observableArrayList();
        Collections.sort(highScores.getPlayers(), Collections.reverseOrder());
        for (Player pl : highScores.getPlayers()) {
            items.add(pl.getFirstName() + " " + pl.getLastName() + " : " + pl.getScores().get(0));
        }
        listeScore.setItems(items);
    }

    public void setHighScores(HighScores highScores) {
        this.highScores = highScores;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
