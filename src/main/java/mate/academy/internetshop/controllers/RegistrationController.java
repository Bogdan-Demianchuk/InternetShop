package mate.academy.internetshop.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("pwd");
        String passwordRe = req.getParameter("pwd-re");
        if (password.equals(passwordRe)) {
            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            req.setAttribute("massage", "Passwords are not the same, please write correct");
            req.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(req, resp);
        }
        System.out.println(login + " " + password + " " + passwordRe);
    }
}
