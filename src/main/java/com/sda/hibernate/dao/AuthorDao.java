package com.sda.hibernate.dao;

import com.sda.hibernate.config.HibernateUtils;
import com.sda.hibernate.entity.Author;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AuthorDao implements DaoInterface<Author> {

    private Session currentSession;
    private Transaction currentTransaction;

    public AuthorDao() {
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public Session openCurrentSession() {
        if (currentSession == null) {
            currentSession = HibernateUtils.getSession();
            currentTransaction = currentSession.beginTransaction();
        }
        return currentSession;
    }

    public void closeCurrentSession() {
        currentTransaction.commit();
    }


    public Author save(Author entity) {
        try {
            getCurrentSession().save(entity);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return entity;
    }

    public void update(Author entity) {
        getCurrentSession().update(entity);
    }

    public Author findById(int id) {
        //        TODO zabezpieczenie przed nullpointer
        Author author = getCurrentSession().get(Author.class, id);
        return author;
    }

    public void delete(Author entity) {
        //        TODO zabezpieczenie przed usuwaniem rekordu który nie istnieje
        getCurrentSession().delete(entity);

    }

    public void deleteAll() {
        String sql = "delete from Author";
        Query query = getCurrentSession().createQuery(sql);
        query.executeUpdate();
    }

    public List<Author> findAll() {
        List<Author> authorList = getCurrentSession().createQuery("FROM " + Author.class.getName()).list();
        return authorList;
    }
}
