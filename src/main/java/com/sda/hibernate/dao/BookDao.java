package com.sda.hibernate.dao;

import com.sda.hibernate.config.HibernateUtils;
import com.sda.hibernate.entity.Book;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BookDao implements DaoInterface<Book> {

    private Session currentSession;
    private Transaction currentTransaction;

    public BookDao() {
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

    public Book save(Book entity) {
        try {
            getCurrentSession().save(entity);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return entity;
    }

    public void update(Book entity) {
        getCurrentSession().update(entity);
    }

    public Book findById(int id) {
        //        TODO zabezpieczenie przed nullpointer
        Book book = getCurrentSession().get(Book.class, id);
        return book;
    }

    public void delete(Book entity) {
        //        TODO zabezpieczenie przed usuwaniem rekordu który nie istnieje
        getCurrentSession().delete(entity);

    }

    public void deleteAll() {
        String sql = "delete from Book";
        Query query = getCurrentSession().createQuery(sql);
        query.executeUpdate();
    }

    public List<Book> findAll() {
        List<Book> bookList = getCurrentSession().createQuery("FROM " + Book.class.getName()).list();
        return bookList;
    }
}
