package mate.academy.internetshop.service;

import java.util.List;
import mate.academy.internetshop.model.Product;

public interface ItemService {
    Product create(Product product);

    Product update(Product product);

    boolean delete(Long id);

    boolean delete(Product product);

    Product get(Long id);

    List<Product> getAllProducts();

}
