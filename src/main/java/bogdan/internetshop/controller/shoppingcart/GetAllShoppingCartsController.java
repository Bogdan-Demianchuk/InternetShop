package bogdan.internetshop.controller.shoppingcart;

import bogdan.internetshop.lib.Injector;
import bogdan.internetshop.model.ShoppingCart;
import bogdan.internetshop.service.ShoppingCartService;
import bogdan.internetshop.service.UserService;
import bogdan.internetshop.util.MenuForPage;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetAllShoppingCartsController extends HttpServlet {
    private static final String USER_ID = "user_id";
    private static final Injector INJECTOR = Injector.getInstance("mate.academy");
    private ShoppingCartService shoppingCartService =
            (ShoppingCartService) INJECTOR.getInstance(ShoppingCartService.class);
    private UserService userService =
            (UserService) INJECTOR.getInstance(UserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<ShoppingCart> allShoppingCarts = shoppingCartService.getAll();
        req.setAttribute("allShoppingCarts", allShoppingCarts);
        MenuForPage.menuSelection(req, USER_ID, userService);
        req.getRequestDispatcher("/WEB-INF/views/shoppingcart/allcards.jsp").forward(req, resp);
    }
}
