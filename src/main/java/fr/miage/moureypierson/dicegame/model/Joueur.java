package fr.miage.moureypierson.dicegame.model;

import java.util.*;

/**
 * Created by Asus on 08/01/2017.
 */
public class Joueur implements Persistable {
    private ArrayList<Integer> listeScore;
    private String nomJoueur;
    private String prenomJoueur;
    private int pointsPartie;
    private int nbTour = 0;

    public Joueur(String nomJoueur, String prenomJoueur) {
        this.nomJoueur = nomJoueur;
        this.prenomJoueur = prenomJoueur;
        this.listeScore = new ArrayList<>();
        this.nbTour = 0;
        this.pointsPartie = 0;
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

    public void addPoints(int value){
        if(value==7){this.pointsPartie+=10;}
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
        listeScore.sort(Comparator.reverseOrder());
    }

    public int getTour() {
        return nbTour;
    }

    public void upTour(){
        this.nbTour++;
    }

    public int getPointsPartie() {
        return pointsPartie;
    }
}