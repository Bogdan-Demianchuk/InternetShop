package mate.academy.internetshop.model;

import java.util.List;

public class Bucket {
    private User user;
    private List<Item> items;
    private Long orderId;

    public void setId(Long id) {
        this.id = id;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }

    public Long getOrderId() {
        return orderId;
    }
}
