package mate.academy.internetshop.service;

import java.util.List;

import mate.academy.internetshop.model.Order;
import mate.academy.internetshop.model.Product;

public interface ProductService extends GenericService<Product, Long> {
    Product create(Product product);

    Product update(Product product);
}
