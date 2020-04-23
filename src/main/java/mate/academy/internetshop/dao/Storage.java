package mate.academy.internetshop.dao;

import java.util.ArrayList;
import java.util.List;
import mate.academy.internetshop.model.ShoppingCart;
import mate.academy.internetshop.model.Product;
import mate.academy.internetshop.model.Order;
import mate.academy.internetshop.model.User;

public class Storage {
    public static final List<User> users = new ArrayList<>();
    public static final List<ShoppingCart> shoppingCarts = new ArrayList<>();
    public static final List<Order> orders = new ArrayList<>();
    public static final List<Product> prodacts = new ArrayList<>();
    public static Long userId = 0L;
    public static Long shoppingCartId = 0L;
    public static Long orderId = 0L;
    public static Long productId = 0L;

    public static void addProduct(Product product) {
        productId++;
        product.setProductId(productId);
        prodacts.add(product);
    }

    public static void addUser(User user) {
        userId++;
        user.setUserId(userId);
        users.add(user);
    }

    public static void addShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartId++;
        shoppingCart.setShoppingCartId(shoppingCartId);
        shoppingCarts.add(shoppingCart);
    }

    public static void addOrder(Order order) {
        orderId++;
        order.setOrderId(orderId);
        orders.add(order);
    }
}
