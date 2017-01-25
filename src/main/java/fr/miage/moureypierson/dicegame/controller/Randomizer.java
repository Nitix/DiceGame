package fr.miage.moureypierson.dicegame.controller;

/**
 * Created by Asus on 08/01/2017.
 */
public class Randomizer {
    private static Randomizer instance;
    private int maxValue = 12;

    private Randomizer(){ }

    public synchronized static Randomizer getInstance(){
        if(instance == null){
            instance = new Randomizer();
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