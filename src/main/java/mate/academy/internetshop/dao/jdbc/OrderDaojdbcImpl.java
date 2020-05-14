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
import mate.academy.internetshop.dao.OrderDao;
import mate.academy.internetshop.exeptions.DataProcessingException;
import mate.academy.internetshop.lib.Dao;
import mate.academy.internetshop.model.Order;
import mate.academy.internetshop.model.Product;
import mate.academy.internetshop.util.ConnectionUtil;

@Dao
public class OrderDaojdbcImpl implements OrderDao {
    @Override
    public Order create(Order order) {
        String queryCre = "INSERT INTO orders(user_id) values(?);";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement(queryCre, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, order.getUserId());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                order.setOrderId(resultSet.getLong(1));
                for (Product product : order.getProducts()) {
                    String queryAddProduct = "INSERT INTO order_products(order_id, product_id) "
                            + "values(?,?);";
                    statement = connection.prepareStatement(queryAddProduct);
                    statement.setLong(1, order.getOrderId());
                    statement.setLong(2, product.getProductId());
                    statement.executeUpdate();
                }
            }
            return order;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't create the order", e);
        }
    }

    @Override
    public Optional<Order> get(Long orderId) {
        String query = "SELECT * FROM orders WHERE order_id = ?;";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, orderId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(new Order(resultSet.getLong("user_id"), orderId,
                        getProductsOfOrder(orderId)));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get user with this id", e);
        }
        return Optional.empty();
    }

    private List<Product> getProductsOfOrder(Long orderId) {
        String query = "SELECT products.product_id, products.product_name, products.product_price "
                + "FROM order_products INNER JOIN products ON  order_products.product_id = products.product_id "
                + "WHERE order_products.order_id = ?;";
        List<Product> products = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, orderId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long productId = resultSet.getLong("product_id");
                String name = resultSet.getString("product_name");
                BigDecimal price = resultSet.getBigDecimal("product_price");
                products.add(new Product(productId, name, price));
            }
            return products;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get products list in order", e);
        }
    }

    @Override
    public List<Order> getAll() {
        String query = "SELECT * FROM orders;";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            List<Order> orders = new ArrayList<>();
            while (resultSet.next()) {
                orders.add(new Order(resultSet.getLong("user_id"), resultSet.getLong("order_id"),
                        getProductsOfOrder(resultSet.getLong("order_id"))));
            }
            return orders;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get all orders list", e);
        }
    }

    @Override
    public Order update(Order order) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            String queryDel = "DELETE FROM order_products WHERE order_id = ?;";
            PreparedStatement statement = connection.prepareStatement(queryDel);
            statement.setLong(1, order.getOrderId());
            statement.executeUpdate();
            for (Product product : order.getProducts()) {
                String queryAdd = "INSERT INTO order_products(order_id, product_id) "
                        + "values(?,?);";
                statement = connection.prepareStatement(queryAdd);
                statement.setLong(1, order.getOrderId());
                statement.setLong(2, product.getProductId());
                statement.executeUpdate();
            }
            return order;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't update order", e);
        }
    }

    @Override
    public boolean delete(Long orderId) {
        String query = "DELETE FROM orders WHERE order_id = ?;";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, orderId);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete order", e);
        }
    }
}

