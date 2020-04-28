package mate.academy.internetshop.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.academy.internetshop.lib.Injector;
import mate.academy.internetshop.model.Product;
import mate.academy.internetshop.model.ShoppingCart;
import mate.academy.internetshop.model.User;
import mate.academy.internetshop.service.ProductService;
import mate.academy.internetshop.service.ShoppingCartService;
import mate.academy.internetshop.service.UserService;

public class InjectDataController extends HttpServlet {
    private static final Injector INJECTOR  = Injector.getInstance("mate.academy.internetshop");
    private UserService userService = (UserService) INJECTOR .getInstance(UserService.class);
    private ProductService productService = (ProductService) INJECTOR .getInstance(ProductService.class);
    private ShoppingCartService shoppingCartService =
            (ShoppingCartService) INJECTOR .getInstance(ShoppingCartService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Product product = new Product("Чебрек", 3);
        Product product2 = new Product("Катлета", 7);
        Product product3 = new Product("Суп", 11.02);
        Product product4 = new Product("Пюре", 3.50);
        productService.create(product);
        productService.create(product2);
        productService.create(product3);
        productService.create(product4);
        User user = new User("Kolia");
        userService.create(user);
        shoppingCartService.create(new ShoppingCart(user));
        User user1 = new User("Olia");
        userService.create(user1);
        shoppingCartService.create(new ShoppingCart(user1));
        User user2 = new User("Zoia");
        userService.create(user2);
        shoppingCartService.create(new ShoppingCart(user2));
        User user3 = new User("Lena");
        userService.create(user3);
        shoppingCartService.create(new ShoppingCart(user3));
        User user4 = new User("Roma");
        userService.create(user4);
        User user5 = new User("Kolia");
        shoppingCartService.create(new ShoppingCart(user4));
        userService.create(user5);
        shoppingCartService.create(new ShoppingCart(user5));
        req.getRequestDispatcher("/WEB-INF/views/InjectData.jsp").forward(req, resp);
    }
}
