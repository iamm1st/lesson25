package Servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain; charset=UTF-8");

        String username = (String) request.getSession().getAttribute("username");
        String role = (String) request.getSession().getAttribute("role");

        PrintWriter writer = response.getWriter();

        if (username == null || role == null) {
            writer.println("Сюда нельзя :) Сначала выполните вход.");
            return;
        }

        writer.println("Добро пожаловать на Home page");
        writer.println("В систему вошёл: " + username);
        writer.println("Роль: " + role); }}