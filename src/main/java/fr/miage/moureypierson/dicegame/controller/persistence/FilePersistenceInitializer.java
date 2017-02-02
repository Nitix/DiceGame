package fr.miage.moureypierson.dicegame.controller.persistence;

/**
 * Initialize the File persistence unit.
 */
public class FilePersistenceInitializer extends PersistenceInitializer {

    /**
     * Initialize the file persistence unit.
     *
     * @return The file persistence unit.
     */
    @Override
    public Persistence initiatePersistence() {
        return new FilePersistence();
    }
}
