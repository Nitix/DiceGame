package fr.miage.moureypierson.dicegame;

import fr.miage.moureypierson.dicegame.controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Asus on 08/01/2017.
 */
public class Main extends Application {

    public static void main(String[] args) {
        try {
            Application.launch(Main.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vues/login.fxml"));
        Parent root = fxmlLoader.load();

        stage.setTitle("Dice Game");
        stage.setScene(new Scene(root, 600, 400));
        LoginController controller = fxmlLoader.getController();
        controller.setStage(stage);
        stage.show();
    }
}
