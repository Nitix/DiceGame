package fr.miage.moureypierson.dicegame.controller;

import fr.miage.moureypierson.dicegame.controller.persistence.*;
import fr.miage.moureypierson.dicegame.model.Die;
import fr.miage.moureypierson.dicegame.model.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Asus on 23/01/2017.
 */
public class GameController implements Initializable {

    public static final int MAX_TOUR = 10;

    private Die die1;
    private Die die2;
    private Player player;

    @FXML
    private Label text;

    @FXML
    private Button boutonJouer;

    @FXML
    private Button boutonRejouer;

    @FXML
    private Button boutonMesScores;

    @FXML
    private Button boutonLesScores;

    @FXML
    private ImageView imageDe1;

    @FXML
    private ImageView imageDe2;

    private Stage stage;

    private Persistence persistence = Config.getInstance().getPersistanceInitializer().initiatePersistence();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.die1 = new Die();
        this.die2 = new Die();

        boutonRejouer.setDisable(true);

        boutonJouer.setOnAction(event -> {
            this.rollDice();
            int valDie1 = die1.getValue();
            int valDie2 = die2.getValue();
            int total = valDie1 + valDie2;
            animation(valDie1, valDie2);

            player.addPoints(total);
            player.upTurn();

            if (player.getTurn() >= MAX_TOUR) {
                boolean isHighScore = isHighScore(total);
                if (isHighScore) {
                    text.setText("High Score !");
                } else {
                    text.setText("Fin du jeu");
                }
                player.addScore(player.getPointsParty());
                boutonJouer.setDisable(true);
                boutonRejouer.setDisable(false);
                persistence.save(player);
            } else {
                text.setText("Encore " + (MAX_TOUR - player.getTurn()) + " tour(s) !");
            }
        });

        boutonRejouer.setOnAction(event -> {
            player.resetTurn();
            boutonJouer.setDisable(false);
            this.initialize(location,resources);
        });

        boutonLesScores.setOnAction(event -> loadScoreScene(false));

        boutonMesScores.setOnAction(event -> loadScoreScene(true));
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void animation(int val1, int val2) {
        this.animation(imageDe1, val1);
        this.animation(imageDe2, val2);
    }

    public void rollDice() {
        this.die1.roll();
        this.die2.roll();
    }

    public void loadScoreScene(boolean isMyScore) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vues/scores.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setTitle("Die Game");
        stage.setScene(new Scene(root, 600, 400));
        ScoreController controller = fxmlLoader.getController();
        HighScores highScores = persistence.loadAll();
        controller.setPlayer(player);
        controller.setHighScores(highScores);
        controller.setType(isMyScore);
        controller.setStage(stage);
        stage.show();
    }

    public void setPlayer(Player player) {
        this.player = player;
        if (this.player.getTurn() >= MAX_TOUR) {
            boutonJouer.setDisable(true);
            boutonRejouer.setDisable(false);
        }
    }

    public void animation(ImageView imageView, int endValue) {
        TimerAnimation.startAnimation(imageView);
        imageView.setImage(new Image("/images/" + endValue + ".png"));
    }

    public boolean isHighScore(int value) {
        return player.getScores().size() <= 0 || value >= player.getScores().get(0);
    }

}
