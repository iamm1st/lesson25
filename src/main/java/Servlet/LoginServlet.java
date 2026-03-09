package Servlet;

import Storage.UserStorage;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain; charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        PrintWriter writer = response.getWriter();

        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            writer.println("Нужно передать username и password");
            return;
        }

        if (UserStorage.isValidUser(username, password)) {
            String role = UserStorage.getRole(username);

            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("role", role);

            writer.println("Вход выполнен успешно");
            writer.println("Пользователь: " + username);
            writer.println("Роль: " + role);
        } else {
            writer.println("Пользователь не найден или пароль неверный"); }}}