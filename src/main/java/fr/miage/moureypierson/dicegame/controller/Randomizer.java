package fr.miage.moureypierson.dicegame.controller;

/**
 * Created by Asus on 08/01/2017.
 */
public class Randomizer {
    private static Randomizer instance;

    private Randomizer(){ }

    public synchronized static Randomizer getInstance(){
        if(instance == null){
            instance = new Randomizer();
        }
        return instance;
    }

    public int nextRandom() {
        return (int)(Math.random() * (12-2)) + 2;
    }
}