package fr.miage.moureypierson.dicegame.model;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Represent a player.
 */
public class Player implements Persistable {

    /**
     * Scores of the player.
     */
    private ArrayList<Integer> scores = new ArrayList<>();

    /**
     * Last name of the player.
     */
    private String lastName;

    /**
     * First name of the player.
     */
    private String firstName;

    /**
     * Points of the current party.
     */
    private int pointsParty = 0;

    /**
     * Current turn.
     */
    private int currentTurn = 0;

    /**
     * Create a new player.
     *
     * @param lastName Last name of the player.
     * @param firstName First name of the player.
     */
    public Player(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    /**
     * Return the last name of the player.
     * @return Last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Return the last name of the player.
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Return scores of the player.
     * @return scores.
     */
    public ArrayList<Integer> getScores() {
        return scores;
    }

    /**
     * Set the last name of the player.
     * @param lastName last name of the player.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Set the first name of the player.
     *
     * @param firstName first name of the player.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Add current dice value to the player.
     * If it's equal to 7 it adds 10 points.
     *
     * @param value Sum of the dice
     */
    public void addPoints(int value) {
        if (value == 7) {
            this.pointsParty += 10;
        }
    }

    /**
     * Add a new score to the player.
     * @param value score of the player.
     * @return true?.
     */
    public boolean addScore(int value) {
        if (this.scores.size() >= 15) {
            int index = 0;
            for (int score : scores) {
                if (value > score) {
                    this.scores.set(index, value);
                    order();
                    return true;
                }
                index++;
            }
        } else {
            this.scores.add(value);
        }
        order();
        return true;
    }

    /**
     * Order the score list.
     */
    public void order() {
        scores.sort(Comparator.reverseOrder());
    }

    /**
     * Get the current turn.
     * @return current turn.
     */
    public int getTurn() {
        return currentTurn;
    }

    /**
     * Add one turn to the player.
     */
    public void upTurn() {
        this.currentTurn++;
    }

    /**
     * Return the points of the party.
     * @return points of the party.
     */
    public int getPointsParty() {
        return pointsParty;
    }
}