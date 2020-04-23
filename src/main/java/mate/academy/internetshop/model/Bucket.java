package mate.academy.internetshop.model;

import java.util.ArrayList;
import java.util.List;

public class Bucket {
    private Long bucketId;
    private User user;
    private List<Product> products = new ArrayList<>();

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Bucket{" + "bucketId=" + bucketId + ", user="
                + user + ", items=" + products + ", orderId=" + '}';
    }
}
