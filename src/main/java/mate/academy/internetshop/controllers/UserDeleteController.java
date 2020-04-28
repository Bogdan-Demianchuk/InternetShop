package mate.academy.internetshop.controllers;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.academy.internetshop.lib.Injector;
import mate.academy.internetshop.service.UserService;

public class UserDeleteController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("mate.academy.internetshop");
    UserService userService = (UserService) injector.getInstance(UserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String useriId = req.getParameter("id");
        Long id = Long.valueOf(useriId);
        userService.delete(id);
        resp.sendRedirect(req.getContextPath() + "/users/all");
    }
}
