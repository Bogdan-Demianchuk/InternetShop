package bogdan.internetshop.controller.user;

import bogdan.internetshop.lib.Injector;
import bogdan.internetshop.model.Role;
import bogdan.internetshop.model.ShoppingCart;
import bogdan.internetshop.model.User;
import bogdan.internetshop.service.ShoppingCartService;
import bogdan.internetshop.service.UserService;
import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationController extends HttpServlet {
    private static final Injector INJECTOR = Injector.getInstance("mate.academy.internetshop");
    private UserService userService = (UserService) INJECTOR.getInstance(UserService.class);
    private ShoppingCartService shoppingCartService =
            (ShoppingCartService) INJECTOR.getInstance(ShoppingCartService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("menus", "menunotlog.jsp");
        req.getRequestDispatcher("/WEB-INF/views/users/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("pwd");
        String passwordRe = req.getParameter("pwd-re");
        if (password.equals(passwordRe)) {
            User user = new User(login, login, password);
            user.setRoles(Set.of(Role.of("USER")));
            userService.create(user);
            shoppingCartService.create(new ShoppingCart(user.getUserId()));
            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            req.setAttribute("massage", "Passwords are not the same, please write correct");
            req.setAttribute("menus", "menunotlog.jsp");
            req.getRequestDispatcher("/WEB-INF/views/users/registration.jsp").forward(req, resp);
        }
    }
}