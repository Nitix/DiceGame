package fr.miage.moureypierson.dicegame;

import fr.miage.moureypierson.dicegame.view.LoginView;
import javafx.application.Application;

/**
 * Created by Asus on 08/01/2017.
 */
public class Main {

    public static void main(String[] args) {
        //JeuDes jeuDes = new JeuDes();
        /*new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //jeuDes.getListeScore().ajouter(new Joueur("Pierson", "Guillaume",  jeuDes.getListeScore()), 12);

        }).start();*/
        try {
            Application.launch(LoginView.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
