package fr.miage.moureypierson.dicegame.controller.persistence;

/**
 * Initialize the MariaDB persistence unit.
 */
public class MariaDBInitializator extends PersistenceInitializator {

    /**
     * Initialize the MariaDB persistence unit.
     *
     * @return The MariaDB persistence unit.
     */
    @Override
    public Persistence initiatePersistence() {
        return new MariaDB();
    }
}
