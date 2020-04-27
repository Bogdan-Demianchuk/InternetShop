package mate.academy.internetshop.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import mate.academy.internetshop.lib.Injector;
import mate.academy.internetshop.model.User;
import mate.academy.internetshop.service.UserService;

public class InjectDataController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("mate.academy.internetshop");
    UserService userService = (UserService) injector.getInstance(UserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User("Kolia");
        User user1 = new User("Olia");
        User user2 = new User("Zoia");
        User user3 = new User("Lena");
        User user4 = new User("Roma");
        User user5 = new User("Kolia");
        userService.create(user);
        userService.create(user1);
        userService.create(user2);
        userService.create(user3);
        userService.create(user4);
        userService.create(user5);
        req.getRequestDispatcher("/WEB-INF/views/users/InjectData.jsp").forward(req, resp);
    }
}
