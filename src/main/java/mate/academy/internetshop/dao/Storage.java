package mate.academy.internetshop.dao;

import java.util.ArrayList;
import java.util.List;
import mate.academy.internetshop.model.Bucket;
import mate.academy.internetshop.model.Item;
import mate.academy.internetshop.model.Order;
import mate.academy.internetshop.model.User;

public class Storage {
    public static final List<User> users = new ArrayList<>();
    public static final List<Bucket> buckets = new ArrayList<>();
    public static final List<Order> orders = new ArrayList<>();
    public static final List<Item> items = new ArrayList<>();
    public static Long userId = 0L;
    public static Long bucketId = 0L;
    public static Long orderId = 0L;
    public static Long itemId = 0L;

    public static void addItem(Item item) {
        itemId++;
        item.setItemId(itemId);
        items.add(item);
    }

    public static void addUser(User user) {
        userId++;
        user.setUserId(userId);
        users.add(user);
    }

    public static void addBucket(Bucket bucket) {
        bucketId++;
        bucket.setBucketId(bucketId);
        buckets.add(bucket);
    }

    public static void addOrder(Order order) {
        orderId++;
        order.setOrderId(orderId);
        orders.add(order);
    }
}
