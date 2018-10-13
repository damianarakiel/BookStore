package com.sda.hibernate.service;

import com.sda.hibernate.dao.BookDao;
import com.sda.hibernate.entity.Book;

import java.util.List;

public class BookService {

    private static BookDao bookDao;

    public BookService(){
        bookDao = new BookDao();
    }

    public void save(Book book){
        bookDao.openCurrentSession();
        bookDao.save(book);
        bookDao.closeCurrentSession();
    }

    public void update(Book book){
        bookDao.openCurrentSession();
        bookDao.update(book);
        bookDao.closeCurrentSession();
    }

    public void delete(int id){
        bookDao.openCurrentSession();
        Book book = bookDao.findById(id);
        bookDao.closeCurrentSession();
    }

    public void deleteAll(){
        bookDao.openCurrentSession();
        bookDao.deleteAll();
        bookDao.closeCurrentSession();
    }

    public Book findById(int id){
        bookDao.openCurrentSession();
        Book book = bookDao.findById(id);
        bookDao.closeCurrentSession();
        return book;
    }

    public List<Book> findAll(){
        bookDao.openCurrentSession();
        List<Book> bookList = bookDao.findAll();
        bookDao.closeCurrentSession();
        return bookList;
    }
}
