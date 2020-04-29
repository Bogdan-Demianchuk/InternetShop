package mate.academy.internetshop.controller.order;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.academy.internetshop.lib.Injector;
import mate.academy.internetshop.model.Product;
import mate.academy.internetshop.service.OrderService;

public class OrderViewController extends HttpServlet {
    private static final Injector INJECTOR = Injector.getInstance("mate.academy");
    private OrderService orderService =
            (OrderService) INJECTOR.getInstance(OrderService.class);
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getParameter("id");
        String userName = orderService.get(Long.valueOf(id)).getUser().getName();
        List<Product> allProductsInOrder = orderService.get(Long.valueOf(id)).getProducts();
        req.setAttribute("allProductsInOrder", allProductsInOrder);
        req.setAttribute("userName", userName);
        req.setAttribute("orderId", id);
        req.getRequestDispatcher("/WEB-INF/views/orders/vieworder.jsp").forward(req, resp);
    }
}
