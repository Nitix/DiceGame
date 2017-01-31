package fr.miage.moureypierson.dicegame.model;

import fr.miage.moureypierson.dicegame.controller.Randomizer;

import java.util.ArrayList;

/**
 * Created by Asus on 08/01/2017.
 */
public class Des{
    private int idDes;
    private int value;
    private static int nbDes = 0;

    public Des() {
        nbDes++;
        this.idDes = nbDes;
        this.value = 0;
    }

    public int getIdDice() {
        return idDes;
    }

    public int getValue() {
        return value;
    }

    public void roll() {
        this.value = Randomizer.getInstance().nextRandom();
    }
}
