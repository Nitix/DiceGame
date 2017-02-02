package fr.miage.moureypierson.dicegame.controller.persistance;

import fr.miage.moureypierson.dicegame.model.Persistable;

/**
 * MongoDB implementation of persistence unit.
 */
public class MongoDB implements Persistence {

    @Override
    public long save(Persistable persistable) {
        return 0;
    }

    @Override
    public void delete(Persistable persistable) {

    }
}
