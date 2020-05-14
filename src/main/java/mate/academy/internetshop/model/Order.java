package mate.academy.internetshop.model;

import java.util.List;

public class Order {
    private Long userId;
    private List<Product> products;
    private Long orderId;

    public Order(Long userId, List<Product> products) {
        this.userId = userId;
        this.products = products;
    }

    public Order(Long userId, Long orderId, List<Product> products) {
        this.userId = userId;
        this.orderId = orderId;
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{"
                + "userId=" + userId
                + ", products=" + products
                + ", orderId=" + orderId
                + '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
