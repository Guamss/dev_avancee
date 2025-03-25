package com.example.demo3.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DispatcherServlet extends HttpServlet {

    private final Factory factory = new Factory();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            String path = request.getServletPath().substring(1);
            String outPage = factory.getClasse(path).perform(request, response);
            request.getRequestDispatcher(outPage).forward(request, response);

        } catch (InstantiationException | IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }

    public void destroy() {
    }
}