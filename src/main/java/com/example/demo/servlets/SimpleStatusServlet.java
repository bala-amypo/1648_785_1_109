package com.example.demo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.io.IOException;

@SpringBootApplication
@ServletComponentScan
public class SimpleStatusServlet {

    public static void main(String[] args) {
        SpringApplication.run(SimpleStatusServlet.class, args);
    }

    // ===== STATUS SERVLET =====
    @WebServlet("/status")
    public static class StatusServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws IOException {

            resp.setContentType("text/plain");
            resp.getWriter().write("OK");
        }
    }
}
