package com.sda.hibernate.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static SessionFactory sf = new Configuration().configure().buildSessionFactory();

    private static Session session = sf.openSession();

    public synchronized static Session getSession(){
        if(session == null){
            System.out.println("Otwieram sesję");
            session = (Session) new HibernateUtils();
        }
        return session;
    }

    public static SessionFactory getSessionFactory(){
        if(sf == null){
            sf = (SessionFactory) new HibernateUtils();
        }
        return sf;
    }

    public static void closeConnection(){
        session.close();
        sf.close();
    }
}
