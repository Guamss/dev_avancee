package com.example.demo2.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Action {
    String perform(HttpServletRequest request, HttpServletResponse response);
}
