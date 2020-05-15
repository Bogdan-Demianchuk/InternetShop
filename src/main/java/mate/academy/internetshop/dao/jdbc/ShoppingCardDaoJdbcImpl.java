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
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get user with this id", e);
        }
        return Optional.empty();
    }

    private List<Product> getProductsOfCart(Long id) {
        String query = "SELECT products.product_id, products.product_name, products.product_price "
                + "FROM shopping_carts_products "
                + " INNER JOIN products ON shopping_carts_products.product_id=products.product_id "
                + "WHERE shopping_carts_products.cart_id = ?;";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            List<Product> products = new ArrayList<>();
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
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            List<ShoppingCart> allShoppingCarts = new ArrayList<>();
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
        deleteProductsFromShoppingCartProducts(shoppingCart.getShoppingCartId());
        addProductToShoppingCart(shoppingCart);
        return shoppingCart;
    }

    private void addProductToShoppingCart(ShoppingCart shoppingCart) {
        String query = "INSERT INTO  shopping_carts_products(cart_id, product_id) values(?, ?);";
        try (Connection connection = ConnectionUtil.getConnection()) {
            for (Product product : shoppingCart.getProducts()) {
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setLong(1, shoppingCart.getShoppingCartId());
                statement.setLong(2, product.getProductId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't add the products to shopping cart", e);
        }
    }

    private void deleteProductsFromShoppingCartProducts(Long ShoppingCartId) {
        String query = "DELETE FROM shopping_carts_products WHERE cart_id = ?;";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, ShoppingCartId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete products from shopping cart", e);
        }
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
