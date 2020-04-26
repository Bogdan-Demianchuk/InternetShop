package mate.academy.internetshop.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.internetshop.dao.OrderDao;
import mate.academy.internetshop.dao.ShoppingCartDao;
import mate.academy.internetshop.lib.Inject;
import mate.academy.internetshop.lib.Service;
import mate.academy.internetshop.model.Order;
import mate.academy.internetshop.model.Product;
import mate.academy.internetshop.model.User;
import mate.academy.internetshop.service.OrderService;
import mate.academy.internetshop.service.ShoppingCartService;

@Service
public class OrderServiceImpl implements OrderService {
    @Inject
    private OrderDao orderDao;

    @Inject
    private ShoppingCartService shoppingCartService;

    @Inject
    private ShoppingCartDao shoppingCartDao;

    @Override
    public Order completeOrder(List<Product> products, User user) {
        Order order = new Order(user, products);
        orderDao.create(order);
        shoppingCartService.clear(shoppingCartDao.getAll().stream()
                .filter(s -> s.getUser().equals(user))
                .findFirst().get());
        return null;
    }

    @Override
    public List<Order> getUserOrders(User user) {
        return orderDao.getAll().stream()
                .filter(s -> s.getUser().getUserId().equals(user.getUserId()))
                .collect(Collectors.toList());
    }

    @Override
    public Order get(Long orderId) {
        return orderDao.get(orderId).get();
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDao.getAll();
    }

    @Override
    public boolean delete(Long orderId) {
        return orderDao.delete(orderId);
    }
}
