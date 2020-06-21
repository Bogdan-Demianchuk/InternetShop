package bogdan.internetshop.controller.shoppingcart;

import static bogdan.internetshop.util.MenuForPage.menuSelection;

import bogdan.internetshop.lib.Injector;
import bogdan.internetshop.model.Product;
import bogdan.internetshop.model.ShoppingCart;
import bogdan.internetshop.service.ShoppingCartService;
import bogdan.internetshop.service.UserService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetProductsFromShoppingCartController extends HttpServlet {
    private static final String USER_ID = "user_id";
    private static final Injector INJECTOR = Injector.getInstance("mate.academy");
    private ShoppingCartService shoppingCartService =
            (ShoppingCartService) INJECTOR.getInstance(ShoppingCartService.class);
    private UserService userService =
            (UserService) INJECTOR.getInstance(UserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long userId = Long.valueOf(req.getParameter("id"));
        ShoppingCart shoppingCart = shoppingCartService.getByUserId(userId);
        List<Product> allProducts = shoppingCart.getProducts();
        req.setAttribute("allProducts", allProducts);
        String userName = userService.get(userId).getName();
        req.setAttribute("userName", userName);
        menuSelection(req, USER_ID, userService);
        req.getRequestDispatcher("/WEB-INF/views/shoppingcart/shoppingcart.jsp").forward(req, resp);
    }

}
