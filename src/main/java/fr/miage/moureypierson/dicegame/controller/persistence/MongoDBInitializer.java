package fr.miage.moureypierson.dicegame.controller.persistence;

import fr.miage.moureypierson.dicegame.model.Player;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.ogm.cfg.OgmConfiguration;

import javax.persistence.EntityManager;

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

        SessionFactory sessionFactory = null;
        // A SessionFactory is set up once for an application!
        StandardServiceRegistry registry = null;
        try {
            Configuration configuration = new OgmConfiguration().configure(getClass().getResource("/mongodb.hibernate.cfg.xml"));
            configuration.addAnnotatedClass(Player.class);
            registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(registry);
        } catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            if (registry != null)
                StandardServiceRegistryBuilder.destroy(registry);
            e.printStackTrace();
        }
        return new MongoDB(sessionFactory);
    }
}
