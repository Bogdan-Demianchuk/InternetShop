package mate.academy.internetshop.service.impl;

import java.util.List;
import mate.academy.internetshop.dao.OrderDao;
import mate.academy.internetshop.dao.Storage;
import mate.academy.internetshop.lib.Inject;
import mate.academy.internetshop.lib.Service;
import mate.academy.internetshop.model.Bucket;
import mate.academy.internetshop.model.Order;
import mate.academy.internetshop.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Inject
    private OrderDao orderDao;

    @Override
    public Order makeOrder(Bucket bucket) {
        Order order = new Order(bucket.getUser(), bucket.getItems(), bucket.getBucketId());
        orderDao.create(order);
        order.setItems(bucket.getItems());
        order.setUser(bucket.getUser());
        return order;
    }

    @Override
    public List<Order> allOrders() {
        return Storage.orders;
    }
}
