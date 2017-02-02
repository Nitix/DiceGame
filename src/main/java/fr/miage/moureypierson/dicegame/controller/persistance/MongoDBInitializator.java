package fr.miage.moureypierson.dicegame.controller.persistance;

/**
 * Initialize the MongoDB persistence unit.
 */
public class MongoDBInitializator extends PersistenceInitializator {

    /**
     * Initialize the MongoDB persistence unit.
     * @return MongoDB persistence unit.
     */
    @Override
    public Persistence initiatePersistence() {
        return new MongoDB();
    }
}
