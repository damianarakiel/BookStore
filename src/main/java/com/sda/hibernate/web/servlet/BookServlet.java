package com.sda.hibernate.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

}
