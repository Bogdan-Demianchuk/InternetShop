package bogdan.internetshop.controller.product;

import bogdan.internetshop.lib.Injector;
import bogdan.internetshop.model.Product;
import bogdan.internetshop.service.ProductService;
import bogdan.internetshop.service.UserService;
import bogdan.internetshop.util.MenuForPage;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetAllProductsController extends HttpServlet {
    private static final String USER_ID = "user_id";
    private static final Injector INJECTOR = Injector.getInstance("mate.academy.internetshop");
    private ProductService productService =
            (ProductService) INJECTOR.getInstance(ProductService.class);
    private UserService userService =
            (UserService) INJECTOR.getInstance(UserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Product> allProducts = productService.getAll();
        MenuForPage.menuSelection(req, USER_ID, userService);
        req.setAttribute("allProducts", allProducts);
        req.getRequestDispatcher("/WEB-INF/views/products/products.jsp").forward(req, resp);
    }
}
