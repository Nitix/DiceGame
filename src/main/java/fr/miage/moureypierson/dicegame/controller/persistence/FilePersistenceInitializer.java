package fr.miage.moureypierson.dicegame.controller.persistence;

import java.io.IOException;
import java.util.Properties;

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
        Properties properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream("/file.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new FilePersistence(properties);
    }
}
