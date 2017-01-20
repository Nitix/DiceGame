package fr.miage.moureypierson.dicegame.controller;

import fr.miage.moureypierson.dicegame.model.Joueur;
import fr.miage.moureypierson.dicegame.model.ListeScore;
import fr.miage.moureypierson.dicegame.view.FenetreJeu;

/**
 * Created by Asus on 08/01/2017.
 */
public class JeuDes {

    private ListeScore listeScore = new ListeScore();

    private FenetreJeu fenetreJeu = new FenetreJeu(this);


    public JeuDes() {
        listeScore.ajouter(new Joueur("Pierson", "Guillaume", listeScore), 5);
        listeScore.ajouter(new Joueur("Mourey", "Arthur", listeScore), 6);

    }

    public FenetreJeu getFenetreJeu() {
        return fenetreJeu;
    }

    public ListeScore getListeScore() {
        return listeScore;
    }

}
