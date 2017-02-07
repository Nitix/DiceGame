package fr.miage.moureypierson.dicegame.controller.persistence;

import com.mongodb.QueryBuilder;
import fr.miage.moureypierson.dicegame.controller.HighScores;
import fr.miage.moureypierson.dicegame.model.Persistable;
import fr.miage.moureypierson.dicegame.model.Player;
import org.hibernate.*;

import java.util.List;

/**
 * MongoDB implementation of persistence unit.
 */
public class MongoDB implements Persistence {

    private final SessionFactory sessionFactory;

    public MongoDB(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Persistable persistable) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.delete(persistable);
            session.saveOrUpdate(persistable);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public HighScores loadAll() {
        Session session = null;
        HighScores highScores = new HighScores();
        try {
            session = sessionFactory.openSession();
            highScores.setPlayers(session.createSQLQuery("db.Player.find({})").addEntity(Player.class).list());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return highScores;
    }
}
