package com.sda.hibernate.dao;

import com.sda.hibernate.config.HibernateUtils;
import com.sda.hibernate.entity.Category;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.util.List;

public class CategoryDao implements DaoInterface<Category> {

    private Session currentSession;
    private Transaction currentTransaction;

    public CategoryDao() {
    }

    public Session getCurrentSession(){
        return currentSession;
    }

    public synchronized Session openCurrentSession(){
        if(currentSession == null){
        currentSession = HibernateUtils.getSession();
        currentTransaction = currentSession.beginTransaction();
        }
        return currentSession;
    }

    public synchronized void closeCurrentSession(){
        if(currentTransaction.getStatus().equals(TransactionStatus.ACTIVE)) {
            currentTransaction.commit();
        }
    }

    public Category save(Category entity) {
        try{
            getCurrentSession().save(entity);
        }catch (HibernateException e){
            e.printStackTrace();
        }
        return entity;
    }

    public void update(Category entity) {
        getCurrentSession().update(entity);
    }

    public Category findById(int id) {
//        TODO zabezpieczenie przed nullpointer
        Category category = getCurrentSession().get(Category.class, id);
        return category;
    }

    public void delete(Category entity) {
//        TODO zabezpieczenie przed usuwaniem rekordu który nie istnieje
        getCurrentSession().delete(entity);
    }

    public void deleteAll() {
        String sql = "delete from Category";
        Query query = getCurrentSession().createQuery(sql);
        query.executeUpdate();
    }

    public List<Category> findAll() {
        List<Category> categoryList = getCurrentSession().createQuery("FROM " + Category.class.getName()).list();
        return categoryList;
    }
}
