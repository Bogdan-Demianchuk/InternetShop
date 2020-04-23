package mate.academy.internetshop;

import java.math.BigDecimal;
import mate.academy.internetshop.lib.Injector;
import mate.academy.internetshop.model.Bucket;
import mate.academy.internetshop.model.Item;
import mate.academy.internetshop.service.ItemService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.academy.internetshop");

    public static void main(String[] args) {
        ItemService itemService = (ItemService) injector.getInstance(ItemService.class);
        initializeDb(itemService);
        itemService.getAllItems().forEach(System.out::println);
        System.out.println();
        itemService.delete(2L);
        Item item4 = new Item("Lens X30.3", BigDecimal.valueOf(30.3));
        item4.setItemId(3L);
        itemService.update(item4);
        System.out.println();
        itemService.getAllItems().forEach(System.out::println);
    }

    private static void initializeDb(ItemService itemService) {
        Item item1 = new Item("Lens X10", BigDecimal.valueOf(10));
        Item item2 = new Item("Lens X20", BigDecimal.valueOf(20));
        Item item3 = new Item("Lens X30", BigDecimal.valueOf(30));
        itemService.create(item1);
        itemService.create(item2);
        itemService.create(item3);

    }
}
