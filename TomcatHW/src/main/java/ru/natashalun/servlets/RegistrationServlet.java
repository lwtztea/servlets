package ru.natashalun.servlets;

import ru.natashalun.service.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String username = request.getParameter("username");
        final String password = request.getParameter("password");

        if (isValidUser(username)) {
            request.getRequestDispatcher("/registration.jsp").forward(request, response);
        } else {
            UserStorage.add(username, password);
            response.sendRedirect("/login.jsp");
        }
    }

    private boolean isValidUser(String username) {

        if (username.equals("admin")) {
            return false;
        }
        return UserStorage.isUserExist(username);
    }
}
