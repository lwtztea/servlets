package ru.natashalun.servlets;

import ru.natashalun.service.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String username = request.getParameter("username");
        final String password = request.getParameter("password");

        boolean isUserExist = UserStorage.isUserExist(username);
        boolean isPasswordCorrect = false;
        String message = "";

        if (isUserExist) {
            isPasswordCorrect = UserStorage.isPasswordCorrect(username, password);
            if (!isPasswordCorrect) {
                message = "incorrectPassword";
            }
        } else {
            message = "userNotExist";
        }

        request.setAttribute("username", username);
        request.setAttribute("message", message);

        if (isUserExist && isPasswordCorrect) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
