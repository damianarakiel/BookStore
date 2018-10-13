package com.sda.bookstore.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

@WebServlet("/")
public class RootServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.addCookie(new Cookie("title", "title"));
//        resp.addCookie(new Cookie("ISBN", "ISBN"));
        Cookie[] cookies = Optional.ofNullable(req.getCookies()).orElse(new Cookie[]{});
        String titleValue = Stream.of(cookies).filter(n -> "title".equals(n.getName())).map(Cookie::getValue).findAny().orElse("default");
        req.setAttribute("titleValue", titleValue);
        req.getRequestDispatcher("form.jsp").forward(req, resp);
    }
}
