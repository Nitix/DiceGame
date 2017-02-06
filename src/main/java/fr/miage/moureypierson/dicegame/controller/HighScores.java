package fr.miage.moureypierson.dicegame.controller;

import fr.miage.moureypierson.dicegame.model.Player;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nitix on 06/02/17.
 */
@XmlRootElement(name = "highscores")
public class HighScores {

    private List<Player> players = new ArrayList<>();

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        if(players.isEmpty()) {
            this.players = new ArrayList<>();
        }else {
            this.players = players;
        }
    }
}
