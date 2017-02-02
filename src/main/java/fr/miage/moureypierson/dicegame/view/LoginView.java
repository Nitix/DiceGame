package fr.miage.moureypierson.dicegame.view;

import fr.miage.moureypierson.dicegame.controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Asus on 23/01/2017.
 */
public class LoginView extends Application {

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