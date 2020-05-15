package mate.academy.internetshop.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private Long productId;
    private String name;
    private BigDecimal price;

    public Product(String name, double price) {
        this.name = name;
        this.price = BigDecimal.valueOf(price);
    }

    public Product(Long productId, String name, BigDecimal price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return productId.equals(product.productId)
                && name.equals(product.name)
                && price.equals(product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, name, price);
    }

    @Override
    public String toString() {
        return "Poduct{" + "id=" + productId + ", name='" + name + '\'' + ", price=" + price + '}';
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long id) {
        this.productId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
