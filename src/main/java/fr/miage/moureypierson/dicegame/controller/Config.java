package fr.miage.moureypierson.dicegame.controller;

import fr.miage.moureypierson.dicegame.controller.persistence.*;

import java.util.Random;

/**
 * Created by Guillaume on 06/02/2017.
 */
public class Config {
    private static Config ourInstance = new Config();

    public static Config getInstance() {
        return ourInstance;
    }

    private Type typeSave = Type.RANDOM;

    private Config() {
    }

    public PersistenceInitializer getPersistanceInitializer() {
        switch (typeSave){
            case FILE:
                return new FilePersistenceInitializer();
            case MARIADB:
                return new MariaDBInitializer();
            case MONGODB:
                return new MongoDBInitializer();
            default:
                switch ((int) (Math.random() * 3)){
                    case 1:
                        return new MariaDBInitializer();
                    case 2:
                        return new MongoDBInitializer();
                    default:
                        return new FilePersistenceInitializer();
                }
        }
    }


    public Type getTypeSave() {
        return typeSave;
    }

    public void setTypeSave(Type typeSave) {
        this.typeSave = typeSave;
    }

    public enum Type {
        MONGODB,
        MARIADB,
        FILE,
        RANDOM
    }
}
