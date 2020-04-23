package mate.academy.internetshop.dao;

import java.util.List;
import java.util.Optional;
import mate.academy.internetshop.model.ShoppingCart;

    public interface ShoppingCartDao {

        ShoppingCart create(ShoppingCart shoppingCart);

        Optional<ShoppingCart> get(Long shoppingCartId);

        List<ShoppingCart> getAll();

        ShoppingCart update(ShoppingCart shoppingCart);

        boolean delete(Long shoppingCartId);
    }
