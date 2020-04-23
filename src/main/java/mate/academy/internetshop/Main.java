package mate.academy.internetshop;

import java.math.BigDecimal;
import mate.academy.internetshop.lib.Injector;
import mate.academy.internetshop.model.Product;
import mate.academy.internetshop.service.ItemService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.academy.internetshop");

    public static void main(String[] args) {
        ItemService itemService = (ItemService) injector.getInstance(ItemService.class);
        initializeDb(itemService);
        itemService.getAllProducts().forEach(System.out::println);
        System.out.println();
        itemService.delete(2L);
        Product product4 = new Product("Lens X30.3", BigDecimal.valueOf(30.3));
        product4.setProductId(3L);
        itemService.update(product4);
        System.out.println();
        itemService.getAllProducts().forEach(System.out::println);
    }

    private static void initializeDb(ItemService itemService) {
        Product product1 = new Product("Lens X10", BigDecimal.valueOf(10));
        Product product2 = new Product("Lens X20", BigDecimal.valueOf(20));
        Product product3 = new Product("Lens X30", BigDecimal.valueOf(30));
        itemService.create(product1);
        itemService.create(product2);
        itemService.create(product3);

    }
}
