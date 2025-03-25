package com.example.demo2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "hello-servlet", value = "*.do")
public class DispatcherServlet extends HttpServlet {

    private final Factory factory = new Factory();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            String path = request.getServletPath();
            String outPage = factory.getClasse(path).perform(request, response);
            request.getRequestDispatcher(outPage).forward(request, response);

        } catch (InstantiationException | IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            String path = request.getServletPath();
            String outPage = factory.getClasse(path).perform(request, response);
            request.getRequestDispatcher(outPage).forward(request, response);

        } catch (InstantiationException | IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }

    public void destroy() {
    }
}