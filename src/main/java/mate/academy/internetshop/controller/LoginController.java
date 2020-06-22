package mate.academy.internetshop.controller;

import static mate.academy.internetshop.util.MenuForPage.menuSelection;

import mate.academy.internetshop.exeptions.AuthenticationException;
import mate.academy.internetshop.lib.Injector;
import mate.academy.internetshop.model.User;
import mate.academy.internetshop.service.ProductService;
import mate.academy.internetshop.service.UserService;
import mate.academy.internetshop.service.security.AuthenticationService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet {
    private static final String USER_ID = "user_id";
    private static final Injector INJECTOR = Injector.getInstance("mate.academy.internetshop");
    private UserService userService = (UserService) INJECTOR.getInstance(UserService.class);
    private ProductService productService =
            (ProductService) INJECTOR.getInstance(ProductService.class);
    private AuthenticationService authenticationService =
            (AuthenticationService) INJECTOR.getInstance(AuthenticationService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        menuSelection(req, USER_ID, userService);
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String login = req.getParameter("login");
        String pwd = req.getParameter("pwd");
        try {
            User user = authenticationService.login(login, pwd);
            HttpSession session = req.getSession();
            session.setAttribute(USER_ID, user.getUserId());
        } catch (AuthenticationException e) {
            req.setAttribute("errorMsg", e.getMessage());
            menuSelection(req, USER_ID, userService);
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
            return;
        }
        resp.sendRedirect(req.getContextPath() + "/");
    }
}
