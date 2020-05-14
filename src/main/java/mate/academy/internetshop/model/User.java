package mate.academy.internetshop.model;

import java.util.Set;

public class User {
    private Long userId;
    private String name;
    private String login;
    private String password;
    private Set<Role> roles;

    public User(Long userId, String name, String login, String password, Set<Role> roles) {
        this.userId = userId;
        this.name = name;
        this.login = login;
        this.password = password;
        this.roles = roles;
    }

    public User(String name) {
        this.name = name;
        this.login = name;
    }

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", userId=" + userId + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
