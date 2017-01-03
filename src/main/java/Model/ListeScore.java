package Model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Asus on 08/01/2017.
 */
public class ListeScore {
    public static ArrayList<Score> liste = new ArrayList<Score>();

    public void ajouter(Joueur j, int value){
        this.liste.add(new Score(j,value));
    }

    public static ArrayList<Score> getListe() {
        return liste;
    }
}
