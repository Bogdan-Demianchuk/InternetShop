package mate.academy.internetshop.model;

import java.util.Objects;

public class Role {
    private Long id;
    private RoleName roleName;

    public Role(RoleName roleName) {
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public static Role of(String roleName) {
        return new Role(RoleName.valueOf(roleName));
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Role role = (Role) o;
        return Objects.equals(id, role.id)
                && roleName == role.roleName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleName);
    }

    public enum RoleName {
        USER, ADMIN;
    }
}
