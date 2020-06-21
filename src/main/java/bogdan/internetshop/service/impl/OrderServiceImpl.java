package bogdan.internetshop.service.impl;

import bogdan.internetshop.dao.OrderDao;
import bogdan.internetshop.dao.ShoppingCartDao;
import bogdan.internetshop.lib.Inject;
import bogdan.internetshop.lib.Service;
import bogdan.internetshop.model.Order;
import bogdan.internetshop.model.Product;
import bogdan.internetshop.service.OrderService;
import bogdan.internetshop.service.ShoppingCartService;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Inject
    private OrderDao orderDao;

    @Inject
    private ShoppingCartService shoppingCartService;

    @Inject
    private ShoppingCartDao shoppingCartDao;

    @Override
    public Order completeOrder(List<Product> products, Long userId) {
        Order order = new Order(userId, products);
        shoppingCartService.clear(shoppingCartDao.getAll().stream()
                .filter(s -> s.getUserId().equals(userId))
                .findFirst().get());
        return orderDao.create(order);
    }

    @Override
    public List<Order> getUserOrders(Long userId) {
        return orderDao.getAll().stream()
                .filter(s -> s.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public Order get(Long orderId) {
        return orderDao.get(orderId).get();
    }

    @Override
    public List<Order> getAll() {
        return orderDao.getAll();
    }

    @Override
    public boolean delete(Long orderId) {
        return orderDao.delete(orderId);
    }
}
