package fr.miage.moureypierson.dicegame.controller;

import fr.miage.moureypierson.dicegame.model.Des;
import fr.miage.moureypierson.dicegame.model.Joueur;
import fr.miage.moureypierson.dicegame.view.GameView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

    public static final int MAX_TOUR = 7;

    private Des des;
    private Joueur joueur;

    @FXML
    private Label text;

    @FXML
    private Button boutonJouer;

    @FXML
    private Button boutonMesScores;

    @FXML
    private Button boutonLesScores;

    @FXML
    private ImageView imageDe1;

    @FXML
    private ImageView imageDe2;

    private GameView gameView = new GameView();

    public GameView getGameView() {
        return gameView;
    }

    private Stage stage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.des = new Des();

        boutonJouer.setOnAction(event -> {
            int value = getResult();
            animation(value);

            joueur.addPoints(value);
            joueur.upTour();

            if (joueur.getTour() >= MAX_TOUR) {
                boolean isHighScore = isHighScore(value);
                if (isHighScore) {
                    text.setText("High Score !");
                } else {
                    text.setText("Fin du jeu");
                }
                joueur.addScore(joueur.getPointsPartie());
                boutonJouer.setDisable(true);
            } else {
                text.setText("Encore " + (MAX_TOUR - joueur.getTour()) + " tour(s) !");
            }
        });

        boutonLesScores.setOnAction(event -> loadScoreScene(false));

        boutonMesScores.setOnAction(event -> loadScoreScene(true));
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void animation(int value) {
        int[] images = getDeImage(value);
        this.animation(imageDe1, images[0]);
        this.animation(imageDe2, images[1]);
    }

    private int[] getDeImage(int value) {
        int de1 = 1;
        int de2 = 1;
        int dispo = (int) (Math.random() * 3);
        switch (value) {
            case 3:
                de1 = 1;
                de2 = 2;
                break;
            case 4:
                if (dispo == 1) {
                    de1 = de2 = 2;
                } else {
                    de1 = 1;
                    de2 = 3;
                }
                break;
            case 5:
                if (dispo == 1) {
                    de1 = 1;
                    de2 = 4;
                } else {
                    de1 = 2;
                    de2 = 3;
                }
                break;
            case 6:
                if (dispo == 1) {
                    de1 = 1;
                    de2 = 5;
                } else if (dispo == 2) {
                    de1 = 2;
                    de2 = 4;
                } else {
                    de1 = de2 = 3;
                }
                break;
            case MAX_TOUR:
                if (dispo == 1) {
                    de1 = 1;
                    de2 = 6;
                } else if (dispo == 2) {
                    de1 = 2;
                    de2 = 5;
                } else {
                    de1 = 3;
                    de2 = 4;
                }
                break;
            case 8:
                if (dispo == 1) {
                    de1 = 2;
                    de2 = 6;
                } else if (dispo == 2) {
                    de1 = 3;
                    de2 = 5;
                } else {
                    de1 = 4;
                    de2 = 4;
                }
                break;
            case 9:
                if (dispo == 1) {
                    de1 = 3;
                    de2 = 6;
                } else {
                    de1 = 4;
                    de2 = 5;
                }
                break;
            case 10:
                if (dispo == 1) {
                    de1 = 4;
                    de2 = 6;
                } else {
                    de1 = 5;
                    de2 = 5;
                }
                break;
            case 11:
                de1 = 5;
                de2 = 6;
                break;
            case 12:
                de1 = 6;
                de2 = 6;
                break;
            default:
                de1 = 1;
                de2 = 1;
                break;
        }
        return new int[]{de1, de2};
    }

    public int getResult() {
        this.des.roll();
        return this.des.getValue();
    }

    public void loadScoreScene(boolean isMyScore) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vues/scores.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setTitle("Dice Game");
        stage.setScene(new Scene(root, 600, 400));
        ScoreController controller = fxmlLoader.getController();
        controller.setJoueur(joueur);
        controller.setType(isMyScore);
        controller.setStage(stage);
        stage.show();
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
        if (this.joueur.getTour() >= MAX_TOUR) {
            boutonJouer.setDisable(true);
        }
    }

    public void animation(ImageView imageView, int endValue) {
        TimerAnimation.startAnimation(imageView);
        imageView.setImage(new Image("/images/" + endValue + ".png"));
    }

    public boolean isHighScore(int value) {
        return joueur.getScoresJoueur().size() <= 0 || value >= joueur.getScoresJoueur().get(0);
    }
}
