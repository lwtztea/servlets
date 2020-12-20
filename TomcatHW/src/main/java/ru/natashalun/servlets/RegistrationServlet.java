package ru.natashalun.servlets;

import ru.natashalun.service.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String username = request.getParameter("username");
        final String password = request.getParameter("password");

        if (isValidUser(username, response)) {
            request.getRequestDispatcher("/registration.jsp").forward(request, response);
        } else {
            UserStorage.add(username, password);
            request.getRequestDispatcher("/success.jsp").forward(request, response);
        }
    }

    private boolean isValidUser(String username, HttpServletResponse response) throws IOException {

        if (username.equals("admin")) {
            PrintWriter write = response.getWriter();
            write.print("Login cannot be 'admin'");
            return false;
        }
        return UserStorage.isUserExist(username);
    }
}
