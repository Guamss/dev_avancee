package com.example.demo1.controller;

import java.io.*;

import com.example.demo1.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "hello-servlet", value = "*.do")
public class DispatcherServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = request.getServletPath();
        if (path.equals("/logout.do")) {
            HttpSession session = request.getSession();
            if (session != null) {
                session.invalidate();
            }
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = request.getServletPath();

        if (path.equals("/login.do")) {
            String login = request.getParameter("login");
            String password = request.getParameter("password");

            if (login.equals("admin") && password.equals("admin")) {
                HttpSession session = request.getSession(true);
                User user = new User();
                user.setLogin(login);
                session.setAttribute("user", user);
                request.getRequestDispatcher("/page1.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/erreur.jsp").forward(request, response);
            }
        } else if (path.equals("/action-un.do")) {
            String attribut1 = request.getParameter("attribut1");
            String attribut2 = request.getParameter("attribut2");

            if (attribut1 != null && attribut2 != null) {
                HttpSession session1 = request.getSession(false);
                User user = (User) session1.getAttribute("user");
                user.setAttribut1(attribut1);
                user.setAttribut2(attribut2);
                session1.setAttribute("user", user);
                request.getRequestDispatcher("/page1.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("/erreur.jsp").forward(request, response);
        }
    }

    public void destroy() {
    }
}