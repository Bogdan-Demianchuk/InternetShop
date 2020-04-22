package mate.academy.internetshop.service;

import java.util.List;
import mate.academy.internetshop.model.Bucket;
import mate.academy.internetshop.model.Order;

public interface OrderService {
    Order makeOrder(Bucket bucket);

    List<Order> allOrders();
}
