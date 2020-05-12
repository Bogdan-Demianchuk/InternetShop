package mate.academy.internetshop.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import mate.academy.internetshop.dao.ProductDao;
import mate.academy.internetshop.exeptions.DataProcessingException;
import mate.academy.internetshop.lib.Dao;
import mate.academy.internetshop.model.Product;
import mate.academy.internetshop.util.ConnectionUtil;

@Dao
public class ProductDaoJdbcImpl implements ProductDao {

    @Override
    public Product create(Product element) {
        String query = "INSERT INTO products (product_name, product_price) VALUES (?, ?)";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, element.getName());
            statement.setBigDecimal(2, element.getPrice());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                Long productId = resultSet.getLong(1);
                element.setProductId(productId);
            }
            return element;
        } catch (SQLException ex) {
            throw new RuntimeException("Can't create the product", ex);
        }
    }

    @Override
    public Optional<Product> get(Long elementId) {
        String query = "SELECT * FROM products WHERE product_id = ?";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, elementId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(getProduct(resultSet));
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Can't get the product by id", ex);
        }
        return Optional.empty();
    }

    @Override
    public List<Product> getAll() {
        String query = "SELECT * FROM products";
        try (Connection connection = ConnectionUtil.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<Product> productList = new ArrayList<>();
            while (resultSet.next()) {
                productList.add(getProduct(resultSet));
            }
            return productList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product update(Product element) {
        String query =
                "UPDATE products SET product_name = ?, product_price = ? WHERE product_id = ?";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, element.getName());
            statement.setBigDecimal(2, element.getPrice());
            statement.setLong(3, element.getProductId());
            if (statement.executeUpdate() > 0) {
                return element;
            }
        } catch (SQLException e) {
            throw new DataProcessingException ("Can't to update product with id");
        }
        return element;
    }

    @Override
    public boolean delete(Long elementId) {
        String query = "DELETE FROM products WHERE product_id = ?";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, elementId);
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            throw new DataProcessingException ("Can't delete the product");
        }
    }

    private Product getProduct(ResultSet resultSet) throws SQLException {
        return new Product(resultSet.getLong("product_id"),
                resultSet.getString("product_name"),
                resultSet.getBigDecimal("product_price"));
    }
}
