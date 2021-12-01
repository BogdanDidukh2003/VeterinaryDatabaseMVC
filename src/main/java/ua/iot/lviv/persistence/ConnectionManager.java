package ua.iot.lviv.persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionManager {
    private static final SessionFactory ourSessionFactory;
    private static Session session = null;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();

        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        if (session == null) {
            session = ourSessionFactory.openSession();
        }
        return session;
    }

    public static void closeSession() throws HibernateException {
        if (session != null) {
            session.close();
            session = null;
        }
    }

    public static void closeSessionFactory() throws HibernateException {
        ourSessionFactory.close();
    }
}
