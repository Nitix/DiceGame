package fr.miage.moureypierson.dicegame.controller.persistence;

import fr.miage.moureypierson.dicegame.controller.HighScores;
import fr.miage.moureypierson.dicegame.model.Persistable;

/**
 * Handle the connection between the program and the persistence unit.
 * The persistence unit can be either a database or a file, or even.
 */
public interface Persistence {

    /**
     * Insert or update the row if it isn't present in the persistence unit.
     *
     * @param persistable the data to save
     */
    void save(Persistable persistable);

    /**
     * Retrieve all data
     */
    HighScores loadAll();
}
