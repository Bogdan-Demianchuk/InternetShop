package bogdan.internetshop.controller.product;

import bogdan.internetshop.lib.Injector;
import bogdan.internetshop.model.Product;
import bogdan.internetshop.service.ProductService;
import bogdan.internetshop.service.UserService;
import bogdan.internetshop.util.MenuForPage;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddProductToShopController extends HttpServlet {
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
        req.setAttribute("allProducts", allProducts);
        MenuForPage.menuSelection(req, USER_ID, userService);
        req.getRequestDispatcher("/WEB-INF/views/products/addproduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        productService.create(new Product(name, new BigDecimal(price)));
        List<Product> allProducts = productService.getAll();
        req.setAttribute("allProducts", allProducts);
        resp.sendRedirect(req.getContextPath() + "/products/add");
    }
}
