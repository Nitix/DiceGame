package fr.miage.moureypierson.dicegame.model;

/**
 * Created by Asus on 08/01/2017.
 */
public class Score {
    public Joueur j;
    public int value;

    public Score(Joueur j, int value) {
        this.j = j;
        this.value = value;
    }
}
