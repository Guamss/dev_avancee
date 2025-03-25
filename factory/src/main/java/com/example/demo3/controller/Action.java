package com.example.demo3.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Action {
    String perform(HttpServletRequest request, HttpServletResponse response);
}
