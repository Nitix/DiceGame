package fr.miage.moureypierson.dicegame.controller;

/**
 * Created by Asus on 01/02/2017.
 */

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class TimerAnimation {
    private Timer timer;
    private ImageView imageView;

    public TimerAnimation(ImageView i) {
        this.imageView = i;
        timer = new Timer();
        timer.schedule(new RemindTask(), 0, 100);
    }

    class RemindTask extends TimerTask {
        int compteur = 10;

        public void run() {
            ArrayList<Image> listeImages = new ArrayList<>();
            listeImages.add(new Image("/images/1.png"));
            listeImages.add(new Image("/images/2.png"));
            listeImages.add(new Image("/images/3.png"));
            listeImages.add(new Image("/images/4.png"));
            listeImages.add(new Image("/images/5.png"));
            listeImages.add(new Image("/images/6.png"));

            if (compteur > 0) {
                int index = (int) (Math.random() * 6);
                imageView.setImage(listeImages.get(index));
                compteur--;
            } else {
                timer.cancel();
            }
        }
    }

    public static void startAnimation(ImageView i) {
        new TimerAnimation(i);
    }
}