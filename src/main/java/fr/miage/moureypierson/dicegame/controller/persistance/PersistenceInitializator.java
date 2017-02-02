package fr.miage.moureypierson.dicegame.controller.persistance;

/**
 * Initialize the persistence unit.
 */
public abstract class PersistenceInitializator {

    /**
     * Initialize the persistence unit.
     * @return The initialed persistence unit.
     */
    public abstract Persistence initiatePersistence();
}
