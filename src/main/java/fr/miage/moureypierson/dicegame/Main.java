package fr.miage.moureypierson.dicegame;

import fr.miage.moureypierson.dicegame.controller.JeuDes;
import fr.miage.moureypierson.dicegame.model.Joueur;
import fr.miage.moureypierson.dicegame.view.FenetreJeu;

/**
 * Created by Asus on 08/01/2017.
 */
public class Main {

    public static void main (String [] args){
        JeuDes jeuDes = new JeuDes();
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            jeuDes.getListeScore().ajouter(new Joueur("Pierson", "Guillaume",  jeuDes.getListeScore()), 12);
        }).start();
    }
}
