package mate.academy.internetshop.model;

public class User {
    private Long userId;
    private String name;
    private String login;
    private String password;

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public User(String name) {
        this.name = name;
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
