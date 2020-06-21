package bogdan.internetshop.controller.shoppingcart;

import bogdan.internetshop.lib.Injector;
import bogdan.internetshop.service.ProductService;
import bogdan.internetshop.service.ShoppingCartService;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddProductToShoppingCartController extends HttpServlet {
    private static final String USER_ID = "user_id";
    private static final Injector INJECTOR = Injector.getInstance("mate.academy.internetshop");
    private ShoppingCartService shoppingCartService =
            (ShoppingCartService) INJECTOR.getInstance(ShoppingCartService.class);
    private ProductService productService =
            (ProductService) INJECTOR.getInstance(ProductService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long userId = (Long) req.getSession().getAttribute(USER_ID);
        Long productId = Long.valueOf(req.getParameter("id"));
        shoppingCartService.addProduct(shoppingCartService
                .getByUserId(userId), productService.get(productId));
        resp.sendRedirect(req.getContextPath() + "/products");
    }
}
