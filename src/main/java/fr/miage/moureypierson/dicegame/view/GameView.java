package fr.miage.moureypierson.dicegame.view;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Asus on 08/01/2017.
 */
public class GameView extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/vues/jeu.fxml"));

        stage.setTitle("Dice Game");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
}
