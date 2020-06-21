package bogdan.internetshop.service;

import bogdan.internetshop.model.Order;
import bogdan.internetshop.model.Product;
import java.util.List;

public interface OrderService extends GenericService<Order, Long> {
    Order completeOrder(List<Product> products, Long userId);

    List<Order> getUserOrders(Long userId);
}
