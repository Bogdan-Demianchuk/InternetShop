package mate.academy.internetshop.model;

import java.util.ArrayList;
import java.util.List;

public class Bucket {
    private Long bucketId;
    private User user;
    private List<Item> items = new ArrayList<>();

    public Bucket(User user) {
        this.user = user;
    }

    public Long getBucketId() {
        return bucketId;
    }

    public void setBucketId(Long bucketId) {
        this.bucketId = bucketId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Bucket{" + "bucketId=" + bucketId + ", user="
                + user + ", items=" + items + ", orderId=" + '}';
    }
}
