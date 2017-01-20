package fr.miage.moureypierson.dicegame.model;

import java.util.ArrayList;

/**
 * Created by Asus on 08/01/2017.
 */
public class Joueur {
    private final ListeScore listeScore;
    public String nomJoueur;
    public String prenomJoueur;

    public Joueur(String nomJoueur, String prenomJoueur, ListeScore listeScore) {
        this.nomJoueur = nomJoueur;
        this.prenomJoueur = prenomJoueur;
        this.listeScore = listeScore;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public String getPrenomJoueur() {
        return prenomJoueur;
    }

    public ArrayList<Score> getScoreJoueur() {
        ArrayList<Score> scoresJoueurs = new ArrayList<Score>();
        for (Score score : listeScore.getScores()) {
            if ((score.j.getNomJoueur().equals(this.getNomJoueur())) && (score.j.getPrenomJoueur().equals(this.getPrenomJoueur()))) {
                scoresJoueurs.add(score);
            }
        }
        return scoresJoueurs;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public void setPrenomJoueur(String prenomJoueur) {
        this.prenomJoueur = prenomJoueur;
    }
}