package fr.miage.moureypierson.dicegame;

import fr.miage.moureypierson.dicegame.controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Initialize and start the program.
 */
public class Main extends Application {

    /**
     * Entry point for the program.
     * @param args Arguments for the program (currently no arguments is used).
     */
    public static void main(String[] args) {
        try {
            Application.launch(Main.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Start the fxml application.
     * @param stage The stage on where the program will run.
     * @throws Exception Exception in the application.
     */
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vues/login.fxml"));
        Parent root = fxmlLoader.load();

        stage.setTitle("Die Game");
        stage.setScene(new Scene(root, 600, 400));
        LoginController controller = fxmlLoader.getController();
        controller.setStage(stage);
        stage.show();
    }
}
