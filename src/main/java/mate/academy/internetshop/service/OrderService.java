package mate.academy.internetshop.service;

import mate.academy.internetshop.model.Order;
import mate.academy.internetshop.model.Product;
import java.util.List;

public interface OrderService extends GenericService<Order, Long> {
    Order completeOrder(List<Product> products, Long userId);

    List<Order> getUserOrders(Long userId);
}
