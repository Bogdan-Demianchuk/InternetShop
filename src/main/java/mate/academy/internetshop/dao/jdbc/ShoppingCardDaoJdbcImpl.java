package mate.academy.internetshop.dao.jdbc;

import java.util.List;
import java.util.Optional;
import mate.academy.internetshop.dao.ShoppingCartDao;
import mate.academy.internetshop.lib.Dao;
import mate.academy.internetshop.model.ShoppingCart;

@Dao
public class ShoppingCardDaoJdbcImpl implements ShoppingCartDao {
    @Override
    public ShoppingCart create(ShoppingCart element) {
        return null;
    }

    @Override
    public Optional<ShoppingCart> get(Long elementId) {
        return Optional.empty();
    }

    @Override
    public List<ShoppingCart> getAll() {
        return null;
    }

    @Override
    public ShoppingCart update(ShoppingCart element) {
        return null;
    }

    @Override
    public boolean delete(Long elementId) {
        return false;
    }
}
