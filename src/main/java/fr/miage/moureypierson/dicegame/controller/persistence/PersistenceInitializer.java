package fr.miage.moureypierson.dicegame.controller.persistence;

/**
 * Initialize the persistence unit.
 */
public abstract class PersistenceInitializer {

    /**
     * Initialize the persistence unit.
     *
     * @return The initialed persistence unit.
     */
    public abstract Persistence initiatePersistence();
}
