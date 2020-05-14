package mate.academy.internetshop.dao.jdbc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import mate.academy.internetshop.dao.ShoppingCartDao;
import mate.academy.internetshop.exeptions.DataProcessingException;
import mate.academy.internetshop.lib.Dao;
import mate.academy.internetshop.model.Product;
import mate.academy.internetshop.model.ShoppingCart;
import mate.academy.internetshop.util.ConnectionUtil;

@Dao
public class ShoppingCardDaoJdbcImpl implements ShoppingCartDao {
    @Override
    public ShoppingCart create(ShoppingCart shoppingCart) {
        String query = "INSERT INTO shopping_carts(user_id) values(?);";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, shoppingCart.getUserId());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                shoppingCart.setShoppingCartId(resultSet.getLong(1));
            }
            return shoppingCart;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't create the shopping cart", e);
        }
    }

    @Override
    public Optional<ShoppingCart> get(Long shoppingCartId) {
        String query = "SELECT * FROM shopping_carts WHERE cart_id = ?;";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, shoppingCartId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(new ShoppingCart(shoppingCartId,
                        resultSet.getLong("user_id"),
                        getProductsOfCart(shoppingCartId)));
            }
        }
        catch (SQLException e) {
            throw new DataProcessingException("Can't get user with this id", e);
        }
        return Optional.empty();
    }

    private List<Product> getProductsOfCart(Long id) {
        String query = "SELECT products.product_id, products.name, products.price "
                + "FROM shopping_carts_products scp"
                + " INNER JOIN products p ON  scp.product_id=p.product_id "
                + "WHERE scp.cart_id = ?;";
        List<Product> products = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long productId = resultSet.getLong("product_id");
                String name = resultSet.getString("product_name");
                BigDecimal price = resultSet.getBigDecimal("product_price");
                products.add(new Product(productId, name, price));
            }
            return products;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get list all products in shopping cart", e);
        }
    }

    @Override
    public List<ShoppingCart> getAll() {
        String query = "SELECT * FROM shopping_carts;";
        List<ShoppingCart> allShoppingCarts = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                allShoppingCarts.add(new ShoppingCart(resultSet.getLong("cart_id"),
                        resultSet.getLong("user_id"),
                        getProductsOfCart(resultSet.getLong("cart_id"))));
            }
            return allShoppingCarts;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get list of all shopping carts ", e);
        }
    }

    @Override
    public ShoppingCart update(ShoppingCart shoppingCart) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            String queryDel = "DELETE FROM shopping_carts_products WHERE cart_id = ?;";
            PreparedStatement statement = connection.prepareStatement(queryDel);
            statement.setLong(1, shoppingCart.getShoppingCartId());
            statement.executeUpdate();
            for (Product product : shoppingCart.getProducts()) {
                String queryAdd = "INSERT INTO  shopping_carts_products(cart_id, product_id) values(?, ?);";
                statement = connection.prepareStatement(queryAdd);
                statement.setLong(1, shoppingCart.getShoppingCartId());
                statement.setLong(2, product.getProductId());
            }
        }
        catch (SQLException e) {
            throw new DataProcessingException("Can't delete products from shopping cart", e);
        }
        return shoppingCart;
    }

    @Override
    public boolean delete(Long shoppingCartId) {
        String query = "DELETE FROM shopping_carts WHERE cart_id = ?;";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, shoppingCartId);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete shopping cart ", e);
        }
    }
}
