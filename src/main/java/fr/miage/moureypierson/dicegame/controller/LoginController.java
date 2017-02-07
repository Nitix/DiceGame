package fr.miage.moureypierson.dicegame.controller;

import fr.miage.moureypierson.dicegame.model.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by Asus on 23/01/2017.
 */
public class LoginController implements Initializable {

    @FXML
    public Button regles;

    @FXML
    public Button configuration;

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
        start.setOnAction(event -> {
            Player user = new Player(nom.getText(), prenom.getText());
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
            controller.setPlayer(user);
            stage.show();
        });
        regles.setOnAction(event -> {
            final Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Règles du jeu");
            alert.contentTextProperty().set("Lancez les dés pendant 10 tours. A chaque fois que la somme" +
                    " des deux dés fait 7, vous gagner 10 points.\nAyez le plus de points possible " +
                            "pour être sur le tableau des highscores !");
            alert.showAndWait();
        });
        configuration.setOnAction(event -> {
            final Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Configuration");
            ButtonType buttonMongo = new ButtonType("MongoDB");
            ButtonType buttonMaria = new ButtonType("MariaDB");
            ButtonType buttonFile = new ButtonType("XML");
            ButtonType buttonRandom = new ButtonType("Aléatoire");
            ButtonType buttonCancel = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.contentTextProperty().set("Choix de la persistence");
            alert.getButtonTypes().setAll(buttonMongo, buttonMaria, buttonFile,buttonRandom, buttonCancel);
            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent()){
                if(result.get() == buttonMongo) {
                    Config.getInstance().setTypeSave(Config.Type.MONGODB);
                }else if(result.get() == buttonMaria) {
                    Config.getInstance().setTypeSave(Config.Type.MARIADB);
                }else if(result.get() == buttonFile) {
                    Config.getInstance().setTypeSave(Config.Type.FILE);
                }else if(result.get() == buttonRandom) {
                    Config.getInstance().setTypeSave(Config.Type.RANDOM);
                }
            }
        });
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
