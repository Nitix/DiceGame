package fr.miage.moureypierson.dicegame.view;

import fr.miage.moureypierson.dicegame.controller.GameController;
import fr.miage.moureypierson.dicegame.controller.ScoreController;
import fr.miage.moureypierson.dicegame.model.ListeScore;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 * Created by Guillaume on 19/01/2017.
 */
public class ScoreView extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vues/scores.fxml"));
        Parent root = fxmlLoader.load();

        stage.setTitle("Dice Game");
        stage.setScene(new Scene(root, 600, 400));
        ScoreController controller = fxmlLoader.getController();
        controller.setStage(stage);
        stage.show();
    }
}
