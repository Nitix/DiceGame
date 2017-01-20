package fr.miage.moureypierson.dicegame.view;


import fr.miage.moureypierson.dicegame.controller.JeuDes;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Asus on 08/01/2017.
 */
public class FenetreJeu extends JFrame {

    private JeuDes jeuDes;

    public FenetreJeu(JeuDes jeuDes) {
        this.jeuDes = jeuDes;
        this.setTitle("Dice Game");
        this.setSize(400, 100);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ScoreView scoreView =  new ScoreView(jeuDes.getListeScore());
        this.add(scoreView);

        this.pack();
        this.setVisible(true);

    }

}
