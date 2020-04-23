package mate.academy.internetshop.model;

import java.util.List;

public class Order {
    private User user;
    private List<Product> products;
    private Long orderId;

    public Order(User user, List<Product> products, Long orderId) {
        this.user = user;
        this.products = products;
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" + "user=" + user + ", items="
                + products + ", orderId=" + orderId + '}';
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
