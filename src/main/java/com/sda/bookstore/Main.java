package com.sda.bookstore;

import com.sda.bookstore.config.HibernateUtils;
import com.sda.bookstore.entity.Author;
import com.sda.bookstore.entity.Book;
import com.sda.bookstore.entity.Category;
import com.sda.bookstore.service.AuthorService;
import com.sda.bookstore.service.BookService;
import com.sda.bookstore.service.CategoryService;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        CategoryService categoryService = new CategoryService();
        AuthorService authorService = new AuthorService();

        Category category = new Category();
        category.setName("qwer");
        categoryService.save(category);

        Author author = new Author();
        author.setName("tyui");
        author.setLastName("opas");

        authorService.save(author);

        BookService bookService = new BookService();

        Author author1 = new Author();
        author1.setName("dfgh");
        author1.setLastName("jklz");

        Set<Author> authorSet = new HashSet<>();
        authorSet.add(author);
        authorSet.add(author1);

        Category category1 = new Category();
        category1.setName("xcvb");

        Book s = new Book();
        s.setCategory(category1);
        s.setAuthorSet(authorSet);
        s.setTitle("nmqw");
        bookService.save(s);

//        CategoryService categoryService = new CategoryService();
//        Category category = new Category();
//        category.setName("NowaSiódma");
//        categoryService.save(category);
//
//        AuthorService authorService = new AuthorService();
//        Author author = new Author();
//        author.setName("1");
//        author.setLastName("2");
//        authorService.save(author);

//        CategoryService categoryService = new CategoryService();
//        System.out.println(categoryService.findAll());
//        System.out.println(categoryService.findById(19).getName());

        HibernateUtils.closeConnection();
    }
}
