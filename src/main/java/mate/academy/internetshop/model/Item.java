package mate.academy.internetshop.model;

import java.math.BigDecimal;

public class Item {
    private Long id;
    private String name;
    private BigDecimal price;
    private static Long count;

    public void setId(Long id) {
        this.id = count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Long getCount() {
        return count;
    }
}
