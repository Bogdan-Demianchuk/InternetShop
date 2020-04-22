package mate.academy.internetshop;

import java.math.BigDecimal;
import java.util.List;
import mate.academy.internetshop.lib.Injector;
import mate.academy.internetshop.model.Bucket;
import mate.academy.internetshop.model.Item;
import mate.academy.internetshop.service.BuckedService;
import mate.academy.internetshop.service.ItemService;
import mate.academy.internetshop.service.OrderService;
import mate.academy.internetshop.service.UserService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.academy.internetshop");

    public static void main(String[] args) {
        ItemService itemService = (ItemService) injector.getInstance(ItemService.class);
        BuckedService buckedService = (BuckedService) injector.getInstance(BuckedService.class);
        OrderService orderService = (OrderService) injector.getInstance(OrderService.class);
        UserService userService = (UserService) injector.getInstance(UserService.class);
        initializeDb(itemService, buckedService, orderService, userService);
        System.out.println(orderService.allOrders());
        System.out.println(buckedService.allBuckets());
        List<Item> allItems = itemService.getAll();
        allItems.forEach(System.out::println);
        itemService.delete(2L);
        Item item4 = new Item("Lens X30.3", BigDecimal.valueOf(30.3));
        item4.setItemId(3L);
        itemService.update(item4);
        allItems = itemService.getAll();
        System.out.println();
        allItems.forEach(System.out::println);
    }

    private static void initializeDb(ItemService itemService,
                                     BuckedService buckedService, OrderService orderService,
                                     UserService userService) {
        Item item1 = new Item("Lens X10", BigDecimal.valueOf(10));
        Item item2 = new Item("Lens X20", BigDecimal.valueOf(20));
        Item item3 = new Item("Lens X30", BigDecimal.valueOf(30));
        itemService.create(item1);
        itemService.create(item2);
        itemService.create(item3);
        Bucket bucket = new Bucket(userService.setName("Zina"));
        buckedService.addItem(bucket, item1.getItemId());
        orderService.makeOrder(bucket);
    }
}
