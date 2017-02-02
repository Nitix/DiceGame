package fr.miage.moureypierson.dicegame.controller.persistence;

/**
 * Initialize the MongoDB persistence unit.
 */
public class MongoDBInitializer extends PersistenceInitializer {

    /**
     * Initialize the MongoDB persistence unit.
     *
     * @return MongoDB persistence unit.
     */
    @Override
    public Persistence initiatePersistence() {
        return new MongoDB();
    }
}
