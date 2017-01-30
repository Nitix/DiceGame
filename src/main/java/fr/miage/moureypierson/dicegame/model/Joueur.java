package fr.miage.moureypierson.dicegame.model;

import java.util.*;

/**
 * Created by Asus on 08/01/2017.
 */
public class Joueur {
    private ArrayList<Integer> listeScore;
    private String nomJoueur;
    private String prenomJoueur;

    public Joueur(String nomJoueur, String prenomJoueur) {
        this.nomJoueur = nomJoueur;
        this.prenomJoueur = prenomJoueur;
        this.listeScore = new ArrayList<Integer>();
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public String getPrenomJoueur() {
        return prenomJoueur;
    }

    public ArrayList<Integer> getScoresJoueur() {
        return listeScore;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public void setPrenomJoueur(String prenomJoueur) {
        this.prenomJoueur = prenomJoueur;
    }

    public boolean addScore(int value) {
        if(this.listeScore.size()>=15) {
            int index = 0;
            for (int score : listeScore) {
                if (value > score) {
                    this.listeScore.set(index,value);
                    tri();
                    return true;
                }
                index++;
            }
        }
        else{
            this.listeScore.add(value);
        }
        tri();
        return true;
    }

    public void tri(){
        Collections.sort(listeScore, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2.compareTo(i1);
            }
        });
    }
}