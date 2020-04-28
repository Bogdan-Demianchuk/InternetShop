package mate.academy.internetshop.controllers.shoppingcart;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.academy.internetshop.lib.Injector;
import mate.academy.internetshop.model.Product;
import mate.academy.internetshop.service.ShoppingCartService;
import mate.academy.internetshop.service.UserService;

public class ShoppingCartController extends HttpServlet {
    private static final Long USER_ID = 1L;
    private static final Injector INJECTOR = Injector.getInstance("mate.academy");
    private ShoppingCartService shoppingCartService =
            (ShoppingCartService) INJECTOR.getInstance(ShoppingCartService.class);
    private UserService userService =
            (UserService) INJECTOR.getInstance(UserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Product> allProducts =
                shoppingCartService.getAllProducts(shoppingCartService.getByUserId(USER_ID));
        req.setAttribute("allProducts", allProducts);
        String userName = userService.get(USER_ID).getName();
        req.setAttribute("userName", userName);
        req.getRequestDispatcher("/WEB-INF/views/shoppingcart/shoppingcart.jsp").forward(req, resp);
    }
}
