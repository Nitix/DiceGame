package fr.miage.moureypierson.dicegame.controller.persistance;

import fr.miage.moureypierson.dicegame.model.Persistable;

/**
 * Handle the connection between the program and the persistence unit.
 * The persistence unit can be either a database or a file, or even
 */
public interface Persistence {

    /**
     * Insert or update the row if it isn't present in the persistence unit
     * @param persistable the data to save
     * @return the id in the database or -1 if it's an update
     */
    long save(Persistable persistable);

    /**
     * Delete the row from the persistence unit
     * @param persistable the data to delete
     */
    void delete(Persistable persistable);
}
