package com.example.demo3.controller;

import com.example.demo3.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginAction implements Action {
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login.equals("admin") && password.equals("admin")) {
            HttpSession session = request.getSession(true);
            User user = new User();
            user.setLogin(login);
            session.setAttribute("user", user);
            return "/page1.jsp";
        }
        return "erreur.jsp";
    }
}
