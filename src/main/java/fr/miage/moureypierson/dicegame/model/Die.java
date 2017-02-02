package fr.miage.moureypierson.dicegame.model;

import fr.miage.moureypierson.dicegame.controller.Randomizer;

/**
 * Represent a die.
 */
public class Die {

    /**
     * Total number of dice in the game.
     */
    private static int nbDes = 0;

    /**
     * Id of the die.
     */
    private int idDie;

    /**
     * Value of the die.
     */
    private int value;

    /**
     * Create a new die.
     */
    public Die() {
        nbDes++;
        this.idDie = nbDes;
        this.value = 0;
    }

    /**
     * Return the id of the die.
     *
     * @return id of the die.
     */
    public int getIdDie() {
        return idDie;
    }

    /**
     * Return the value of the die.
     *
     * @return value of the die.
     */
    public int getValue() {
        return value;
    }

    /**
     * Roll the die and thus generate a new value.
     */
    public void roll() {
        this.value = Randomizer.getInstance().nextRandom();
    }
}
