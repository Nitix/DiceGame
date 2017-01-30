package fr.miage.moureypierson.dicegame.model;

import java.util.ArrayList;

/**
 * Created by Asus on 08/01/2017.
 */
public class Joueur {
    private int[] listeScore;
    private String nomJoueur;
    private String prenomJoueur;

    public Joueur(String nomJoueur, String prenomJoueur) {
        this.nomJoueur = nomJoueur;
        this.prenomJoueur = prenomJoueur;
        this.listeScore = new int[7];
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public String getPrenomJoueur() {
        return prenomJoueur;
    }

    public int[] getScoresJoueur() {
        return listeScore;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public void setPrenomJoueur(String prenomJoueur) {
        this.prenomJoueur = prenomJoueur;
    }

    public void addScore(int value) {
        if(this.listeScore.length>=7) {
            int index = 0;
            for (int score : listeScore) {
                if (value > score) {
                    this.listeScore[index] = value;
                }
                index++;
            }
        }
        else{
            this.listeScore[listeScore.length]=value;
        }
    }
}