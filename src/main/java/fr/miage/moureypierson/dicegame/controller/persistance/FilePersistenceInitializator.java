package fr.miage.moureypierson.dicegame.controller.persistance;

/**
 * Initialize the File persistence unit.
 */
public class FilePersistenceInitializator extends PersistenceInitializator {

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
