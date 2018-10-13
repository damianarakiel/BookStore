package com.sda.bookstore.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/book")
public class BookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", req.getParameter("title"));
        req.setAttribute("ISBN", req.getParameter("ISBN"));
        req.getRequestDispatcher("book.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setAttribute("title", req.getParameter("title"));
        req.setAttribute("ISBN", req.getParameter("ISBN"));
        req.getRequestDispatcher("hello.jsp").forward(req, resp);
    }

}
