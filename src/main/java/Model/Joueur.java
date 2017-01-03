package Model;

import java.util.ArrayList;

/**
 * Created by Asus on 08/01/2017.
 */
public class Joueur {
    public String nomJoueur;
    public String prenomJoueur;

    public Joueur(String nomJoueur, String prenomJoueur) {
        this.nomJoueur = nomJoueur;
        this.prenomJoueur = prenomJoueur;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public String getPrenomJoueur() {
        return prenomJoueur;
    }

    public ArrayList<Score> getScoresJoueur() {
        ArrayList<Score> scoresJoueurs = new ArrayList<Score>();
        for (Score score : ListeScore.getListe()){
            if((score.j.getNomJoueur()==this.getNomJoueur())&&(score.j.getPrenomJoueur()==this.getPrenomJoueur())){
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
