package mate.academy.internetshop.controller.shoppingcart;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.academy.internetshop.lib.Injector;
import mate.academy.internetshop.model.ShoppingCart;
import mate.academy.internetshop.service.ShoppingCartService;

public class GetAllShoppingCartsController extends HttpServlet {
    private static final Injector INJECTOR = Injector.getInstance("mate.academy");
    private ShoppingCartService shoppingCartService =
            (ShoppingCartService) INJECTOR.getInstance(ShoppingCartService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<ShoppingCart> allShoppingCarts = shoppingCartService.getAll();
        req.setAttribute("allShoppingCarts", allShoppingCarts);
        req.getRequestDispatcher("/WEB-INF/views/shoppingcard/allcards.jsp").forward(req, resp);
    }
}
