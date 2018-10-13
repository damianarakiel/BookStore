package com.sda.bookstore.web.servlet;

import com.sda.bookstore.entity.Author;
import com.sda.bookstore.entity.Book;
import com.sda.bookstore.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet("/book")
public class BookServlet extends HttpServlet {

    BookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Book book = bookService.findAll().iterator().next();
//        req.setAttribute("title", book.getTitle());
//        req.setAttribute("ISBN", book.getIsbn());
        HttpSession session = req.getSession();
        req.setAttribute("title", session.getAttribute("title"));
        req.setAttribute("ISBN", session.getAttribute("ISBN"));
        req.getRequestDispatcher("book.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String titleParam = req.getParameter("title");
        session.setAttribute("title", titleParam);
        String isbnParam = req.getParameter("ISBN");
        session.setAttribute("ISBN", isbnParam);

        resp.addCookie(new Cookie("title",titleParam));
        resp.addCookie(new Cookie("ISBN", isbnParam));
//        Book book = new Book(req.getParameter("title"), req.getParameter("ISNB"));
//        book.setAuthorSet(Collections.singleton(new Author("Marcin", "Lis")));
//        bookService.save(book);
        resp.sendRedirect("book");
    }
}
