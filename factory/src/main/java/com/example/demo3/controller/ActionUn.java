package com.example.demo3.controller;

import com.example.demo3.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ActionUn implements Action {
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) {
        String attribut1 = request.getParameter("attribut1");
        String attribut2 = request.getParameter("attribut2");

        if (attribut1 != null && attribut2 != null) {
            HttpSession session1 = request.getSession(false);
            User user = (User) session1.getAttribute("user");
            user.setAttribut1(attribut1);
            user.setAttribut2(attribut2);
            session1.setAttribute("user", user);
        }
        return "/page1.jsp";
    }
}
