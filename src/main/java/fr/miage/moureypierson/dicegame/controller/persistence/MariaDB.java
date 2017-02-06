package fr.miage.moureypierson.dicegame.controller.persistence;

import fr.miage.moureypierson.dicegame.controller.HighScores;
import fr.miage.moureypierson.dicegame.model.Persistable;
import fr.miage.moureypierson.dicegame.model.Player;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * MariaDB implementation of persistence unit.
 */
public class MariaDB implements Persistence {

    private final SessionFactory sessionFactory;

    public MariaDB(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Persistable persistable) {
        Session session = null;
        Transaction tx = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(persistable);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
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
            Criteria criteria = session.createCriteria(Player.class);
            highScores.setPlayers((List<Player>) criteria.list());
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
