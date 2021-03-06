package mate.academy.internetshop.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.academy.internetshop.lib.Injector;
import mate.academy.internetshop.model.Product;
import mate.academy.internetshop.model.Role;
import mate.academy.internetshop.model.User;
import mate.academy.internetshop.service.ProductService;
import mate.academy.internetshop.service.UserService;

public class InjectDataController extends HttpServlet {
    private static final Injector INJECTOR = Injector.getInstance("mate.academy.internetshop");
    private UserService userService = (UserService) INJECTOR.getInstance(UserService.class);
    private ProductService productService =
            (ProductService) INJECTOR.getInstance(ProductService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (userService.findeByLogin("admin").isEmpty()) {
            User admin = new User("admin", "admin", "admin");
            admin.setRoles(Set.of(Role.of("ADMIN")));
            userService.create(admin);
            User user1 = new User("user", "user", "user");
            user1.setRoles(Set.of(Role.of("USER")));
            userService.create(user1);
        }
        Product nachosWithCheese = new Product("Nachos with cheese", new BigDecimal(20));
        productService.create(nachosWithCheese);
        Product nachosWithTomatoes = new Product("Nachos with tomatoes", new BigDecimal(15));
        productService.create(nachosWithTomatoes);
        req.getRequestDispatcher("/WEB-INF/views/injectData.jsp").forward(req, resp);
    }
}
