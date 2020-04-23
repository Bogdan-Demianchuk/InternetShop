package mate.academy.internetshop.model;

import java.math.BigDecimal;

public class Product {
    private Long id;
    private String name;
    private BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Poduct{" + "id=" + id + ", name='" + name + '\'' + ", price=" + price + '}';
    }

    public Long getProductId() {
        return id;
    }

    public void setProductId(Long id) {
        this.id = id;
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
