package mate.academy.internetshop.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import mate.academy.internetshop.dao.UserDao;
import mate.academy.internetshop.exeptions.DataProcessingException;
import mate.academy.internetshop.lib.Dao;
import mate.academy.internetshop.model.Role;
import mate.academy.internetshop.model.User;
import mate.academy.internetshop.util.ConnectionUtil;

@Dao
public class UserDaoJdbcImpl implements UserDao {
    @Override
    public Optional<User> findeByLogin(String login) {
        String query = "SELECT * FROM users WHERE user_login=?;";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(new User(resultSet.getLong("user_id"),
                        resultSet.getString("user_name"),
                        resultSet.getString("user_login"),
                        resultSet.getString("user_password"),
                        getUsersRole(resultSet.getLong("user_id"))));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't fine login", e);
        }
    }

    private Set<Role> getUsersRole(Long userId) {
        Set<Role> userRoles = new HashSet<>();
        String query = "SELECT roles.role_name FROM users_roles "
                + "INNER JOIN roles ON  users_roles.role_id=roles.role_id "
                + "WHERE users_roles.user_id = ?;";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                userRoles.add(Role.of(resultSet.getString("role_name")));
            }
            return userRoles;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get users roles", e);
        }
    }

    @Override
    public User create(User user) {
        String query = "INSERT INTO users (user_name, user_login, user_password) VALUES (?, ?, ?);";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setUserId(resultSet.getLong(1));
                for (Role role : user.getRoles()) {
                    query = "INSERT INTO users_roles (user_id, role_id) values(?,?);";
                    statement = connection.prepareStatement(query);
                    statement.setLong(1, user.getUserId());
                    if (role.getId() == null) {
                        role.setId(getRoleId(role.getRoleName(), connection));
                    }
                    statement.setLong(2, role.getId());
                    statement.executeUpdate();
                }
            }
            return user;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't create the product", e);
        }
    }

    private Long getRoleId(Role.RoleName roleName, Connection connection) throws SQLException {
        String query = "SELECT role_id FROM roles WHERE role_name = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, roleName.toString());
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        return resultSet.getLong("role_id");
    }

    @Override
    public Optional<User> get(Long userId) {
        String query = "SELECT * FROM users WHERE user_id = ?;";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(new User(resultSet.getLong("user_id"),
                        resultSet.getString("user_name"),
                        resultSet.getString("user_login"),
                        resultSet.getString("user_password"),
                        getUsersRole(resultSet.getLong("user_id"))));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get user with this id", e);
        }
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users;";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                users.add(new User(resultSet.getLong("user_id"),
                        resultSet.getString("user_name"),
                        resultSet.getString("user_login"),
                        resultSet.getString("user_password"),
                        getUsersRole(resultSet.getLong("user_id"))));
            }
            return users;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get list of all users ", e);
        }
    }

    @Override
    public User update(User user) {
        String query = "UPDATE users SET user_name=?, user_login=?, user_password=?"
                + "WHERE user_id=?;";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.setLong(4, user.getUserId());
            statement.executeUpdate();
            deleteRolesOfUser(user);
            addRolesForUser(user);
            return user;
        } catch (SQLException e) {
            throw new DataProcessingException("Cant update the user", e);
        }
    }

    private void addRolesForUser(User user) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            for (Role role : user.getRoles()) {
                String query = "INSERT INTO users_roles (user_id, role_id) values(?,?);";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setLong(1, user.getUserId());
                statement.setLong(2, role.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't add role to user", e);
        }
    }

    private void deleteRolesOfUser(User user) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            String query = "DELETE FROM users_roles WHERE user_id=?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, user.getUserId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete roles user", e);
        }
    }

    @Override
    public boolean delete(Long userId) {
        String query = "DELETE FROM users WHERE user_id=?;";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, userId);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete user", e);
        }
    }
}
