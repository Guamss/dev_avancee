package com.example.basic_webapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/action-un")
public class ActionUn extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    }
}
