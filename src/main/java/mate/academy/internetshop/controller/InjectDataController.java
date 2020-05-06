package mate.academy.internetshop.controller;

import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.academy.internetshop.lib.Injector;
import mate.academy.internetshop.model.Product;
import mate.academy.internetshop.model.Role;
import mate.academy.internetshop.model.ShoppingCart;
import mate.academy.internetshop.model.User;
import mate.academy.internetshop.service.ProductService;
import mate.academy.internetshop.service.ShoppingCartService;
import mate.academy.internetshop.service.UserService;

public class InjectDataController extends HttpServlet {
    private static final Injector INJECTOR = Injector.getInstance("mate.academy.internetshop");
    private UserService userService = (UserService) INJECTOR.getInstance(UserService.class);
    private ProductService productService =
            (ProductService) INJECTOR.getInstance(ProductService.class);
    private ShoppingCartService shoppingCartService =
            (ShoppingCartService) INJECTOR.getInstance(ShoppingCartService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Product product = new Product("Чебрек", 13);
        Product product2 = new Product("Котлета", 17);
        Product product3 = new Product("Суп", 11.20);
        Product product4 = new Product("Пюре", 3.50);
        Product product5 = new Product("Мороженое", 3.50);
        productService.create(product);
        productService.create(product2);
        productService.create(product3);
        productService.create(product4);
        productService.create(product5);

        User user = new User("Kolia");
        user.setRoles(Set.of(Role.of("USER")));
        userService.create(user);

        User admin = new User("admin", "admin", "1");
        admin.setRoles(Set.of(Role.of("ADMIN")));
        userService.create(admin);
        shoppingCartService.create(new ShoppingCart(admin));

        User user1 = new User("Olia");
        user1.setRoles(Set.of(Role.of("USER")));
        userService.create(user1);
        shoppingCartService.create(new ShoppingCart(user1));
        User user2 = new User("Zoia");
        user2.setRoles(Set.of(Role.of("USER")));
        userService.create(user2);
        shoppingCartService.create(new ShoppingCart(user2));
        User user3 = new User("Lena");
        user3.setRoles(Set.of(Role.of("USER")));
        userService.create(user3);
        shoppingCartService.create(new ShoppingCart(user3));
        User user4 = new User("Roma");
        user4.setRoles(Set.of(Role.of("USER")));
        userService.create(user4);
        User user5 = new User("Kolia");
        user5.setRoles(Set.of(Role.of("USER")));
        shoppingCartService.create(new ShoppingCart(user4));
        userService.create(user5);
        shoppingCartService.create(new ShoppingCart(user5));
        req.getRequestDispatcher("/WEB-INF/views/InjectData.jsp").forward(req, resp);
    }
}
