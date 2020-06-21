package bogdan.internetshop.controller;

import static bogdan.internetshop.util.MenuForPage.menuSelection;

import bogdan.internetshop.lib.Injector;
import bogdan.internetshop.model.Product;
import bogdan.internetshop.model.Role;
import bogdan.internetshop.model.User;
import bogdan.internetshop.service.ProductService;
import bogdan.internetshop.service.UserService;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InjectDataController extends HttpServlet {
    private static final String USER_ID = "user_id";
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
        Product junior = new Product("Java developer", new BigDecimal(800));
        productService.create(junior);
        menuSelection(req, USER_ID, userService);
        req.getRequestDispatcher("/WEB-INF/views/InjectData.jsp").forward(req, resp);

    }
}
