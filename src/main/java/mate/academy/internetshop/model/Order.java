package mate.academy.internetshop.model;

import java.util.List;

public class Order {
    private User user;
    private List<Item> items;
    private Long orderId;

    public Order(User user, List<Item> items, Long orderId) {
        this.user = user;
        this.items = items;
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
                + items + ", orderId=" + orderId + '}';
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
