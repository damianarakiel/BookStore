package com.sda.hibernate;

import com.sda.hibernate.config.HibernateUtils;
import com.sda.hibernate.entity.Author;
import com.sda.hibernate.entity.Book;
import com.sda.hibernate.entity.Category;
import com.sda.hibernate.service.AuthorService;
import com.sda.hibernate.service.BookService;
import com.sda.hibernate.service.CategoryService;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        CategoryService categoryService = new CategoryService();
        AuthorService authorService = new AuthorService();

        Category category = new Category();
        category.setName("ZDUPLIKWANA2");
        categoryService.save(category);

        Author author = new Author();
        author.setName("STARY2");
        author.setLastName("AUTOR2");

        authorService.save(author);

        BookService bookService = new BookService();

        Author author1 = new Author();
        author1.setName("JESZCZE2");
        author1.setLastName("STARSZY2");

        Set<Author> authorSet = new HashSet<>();
        authorSet.add(author);
        authorSet.add(author1);

        Category category1 = new Category();
        category1.setName("TESTOWA2");

        Book s = new Book();
        s.setCategory(category1);
        s.setAuthorSet(authorSet);
        s.setTitle("NOWY TYTUŁ");
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
