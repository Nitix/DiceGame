package fr.miage.moureypierson.dicegame.controller;

import fr.miage.moureypierson.dicegame.model.Joueur;
import fr.miage.moureypierson.dicegame.model.ListeScore;
import fr.miage.moureypierson.dicegame.view.GameView;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Asus on 23/01/2017.
 */
public class GameController implements Initializable {

    private ListeScore listeScore = new ListeScore();
    private GameView gameView = new GameView();

    public GameView getGameView() {
        return gameView;
    }

    public ListeScore getListeScore() {
        return listeScore;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listeScore.ajouter(new Joueur("Pierson", "Guillaume", listeScore), 5);
        listeScore.ajouter(new Joueur("Mourey", "Arthur", listeScore), 6);
    }
}
