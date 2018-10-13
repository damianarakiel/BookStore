package com.sda.hibernate.service;

import com.sda.hibernate.dao.AuthorDao;
import com.sda.hibernate.entity.Author;

import java.util.List;

public class AuthorService {

    private static AuthorDao authorDao;

    public AuthorService() {
        authorDao = new AuthorDao();
    }

    public void save(Author author){
        authorDao.openCurrentSession();
        authorDao.save(author);
        authorDao.closeCurrentSession();
    }

    public void update(Author author){
        authorDao.openCurrentSession();
        authorDao.update(author);
        authorDao.closeCurrentSession();
    }

    public Author findById(int id){
        authorDao.openCurrentSession();
        Author author = authorDao.findById(id);
        authorDao.closeCurrentSession();
        return author;
    }

    public void delete(int id){
        authorDao.openCurrentSession();
        Author author = authorDao.findById(id);
        authorDao.closeCurrentSession();
    }

    public void deleteAll(){
        authorDao.openCurrentSession();
        authorDao.deleteAll();
        authorDao.closeCurrentSession();
    }

    public List<Author> findAll(){
        authorDao.openCurrentSession();
        List<Author> authorList = authorDao.findAll();
        authorDao.closeCurrentSession();
        return authorList;
    }
}
