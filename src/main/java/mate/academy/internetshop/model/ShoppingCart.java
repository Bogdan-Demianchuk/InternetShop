package mate.academy.internetshop.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private Long shoppingCartId;
    private Long userId;
    private List<Product> products = new ArrayList<>();

    public ShoppingCart(Long shoppingCartId, Long userId, List<Product> products) {
        this.shoppingCartId = shoppingCartId;
        this.userId = userId;
        this.products = products;
    }

    public ShoppingCart(Long userId) {
        this.userId = userId;
    }

    public Long getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ShoppingCart{"
                + "shoppingCartId=" + shoppingCartId
                + ", userId=" + userId
                + ", products=" + products
                + '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
