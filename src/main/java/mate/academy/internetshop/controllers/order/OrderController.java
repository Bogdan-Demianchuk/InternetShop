package mate.academy.internetshop.controllers.order;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.academy.internetshop.lib.Injector;
import mate.academy.internetshop.model.Order;
import mate.academy.internetshop.model.Product;
import mate.academy.internetshop.service.OrderService;
import mate.academy.internetshop.service.ShoppingCartService;
import mate.academy.internetshop.service.UserService;

public class OrderController extends HttpServlet {
    private static final Long USER_ID = 1L;
    private static final Injector INJECTOR = Injector.getInstance("mate.academy");
    private final ShoppingCartService shoppingCartService =
            (ShoppingCartService) INJECTOR.getInstance(ShoppingCartService.class);
    private final UserService userService =
            (UserService) INJECTOR.getInstance(UserService.class);
    private final OrderService orderService =
            (OrderService) INJECTOR.getInstance(OrderService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Order order = orderService.completeOrder(shoppingCartService
                .getByUserId(USER_ID).getProducts(), userService.get(USER_ID));
        String userName = userService.get(USER_ID).getName();
        Long orderId = order.getOrderId();
        List<Product> allProductsInOrder = order.getProducts();
        req.setAttribute("orderId", orderId);
        req.setAttribute("userName", userName);
        req.setAttribute("allProductsInOrder", allProductsInOrder);
        req.getRequestDispatcher("/WEB-INF/views/orders/order.jsp").forward(req, resp);
    }
}
