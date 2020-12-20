package ru.natashalun.servlets;

import ru.natashalun.service.UserStorage;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String username = request.getParameter("username");
        final String password = request.getParameter("password");
        boolean isUserExist = UserStorage.isUserExist(username);
        boolean isPasswordCorrect = false;
        PrintWriter write = response.getWriter();

        if (isUserExist) {
            isPasswordCorrect = UserStorage.isPasswordCorrect(username, password);
        }

        request.setAttribute("username", username);

        if (!isUserExist) {
            write.println("User doesn't exist. Please, sign up to proceed");
        } else if (!isPasswordCorrect) {
            write.print("Invalid password. Try again.");
        } else {
            request.getRequestDispatcher("/success.jsp").forward(request, response);
        }
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
