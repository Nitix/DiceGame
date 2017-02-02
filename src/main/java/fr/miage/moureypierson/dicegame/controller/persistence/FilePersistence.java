package fr.miage.moureypierson.dicegame.controller.persistence;

import fr.miage.moureypierson.dicegame.model.Persistable;

/**
 * File persistence implementation of persistence unit.
 */
public class FilePersistence implements Persistence {
    @Override
    public long save(Persistable persistable) {
        return 0;
    }

    @Override
    public void delete(Persistable persistable) {

    }
}
