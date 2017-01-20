package fr.miage.moureypierson.dicegame.controller;

/**
 * Created by Asus on 08/01/2017.
 */
public class Randomizer {
    private static Randomizer instance;
    private static boolean created = false;
    private int maxValue = 12;

    private Randomizer(){ }

    public synchronized static Randomizer getInstance(){
        if(!created){
            instance = new Randomizer();
            created = true;
        }
        return instance;
    }

    public int nextRandom() {
        return (int) (Math.random()*maxValue);
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }
}