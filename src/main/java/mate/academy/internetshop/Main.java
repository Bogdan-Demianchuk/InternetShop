package mate.academy.internetshop;

import java.math.BigDecimal;
import mate.academy.internetshop.dao.Storage;
import mate.academy.internetshop.lib.Injector;
import mate.academy.internetshop.model.Product;
import mate.academy.internetshop.service.ProductService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.academy.internetshop");

    public static void main(String[] args) {
        ProductService productService = (ProductService) injector.getInstance(ProductService.class);
        initializeDb(productService);
        Storage.products.forEach(System.out::println);
        System.out.println();
        productService.delete(2L);
        Product product4 = new Product("Lens X30.3", 30.3);
        product4.setProductId(3L);
        productService.update(product4);
        System.out.println();
        Storage.products.forEach(System.out::println);
    }

    private static void initializeDb(ProductService productService) {
        Product product1 = new Product("Lens X10", 10);
        Product product2 = new Product("Lens X20", 20);
        Product product3 = new Product("Lens X30", 30);
        productService.create(product1);
        productService.create(product2);
        productService.create(product3);
    }
}
