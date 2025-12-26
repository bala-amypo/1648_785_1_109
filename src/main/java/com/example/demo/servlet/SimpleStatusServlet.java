package com.example.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class SimpleStatusServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Required by test t02
        resp.setContentType("text/plain");

        PrintWriter writer = resp.getWriter();

        // Required by tests t01, t05, t06, t08
        writer.write("Credit Card Reward Maximizer is running");

        // Required by test t04
        writer.flush();
    }
}
