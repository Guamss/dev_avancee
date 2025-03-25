package com.example.demo2.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ActionDebut implements Action {
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) {
        return "/index.jsp";
    }
}
