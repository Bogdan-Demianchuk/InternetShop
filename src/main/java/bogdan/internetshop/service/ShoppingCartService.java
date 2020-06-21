package bogdan.internetshop.service;

import bogdan.internetshop.model.Product;
import bogdan.internetshop.model.ShoppingCart;
import java.util.List;

public interface ShoppingCartService {
    ShoppingCart addProduct(ShoppingCart shoppingCart, Product product);

    boolean deleteProducts(ShoppingCart shoppingCart, Product product);

    void clear(ShoppingCart shoppingCart); //remove all products from the shoppingCart

    ShoppingCart getByUserId(Long userId);

    List<Product> getAllProducts(ShoppingCart shoppingCart);

    List<ShoppingCart> getAll();

    ShoppingCart create(ShoppingCart shoppingCart);
}