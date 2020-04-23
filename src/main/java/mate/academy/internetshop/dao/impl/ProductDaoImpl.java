package mate.academy.internetshop.dao.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import mate.academy.internetshop.dao.ProductDao;
import mate.academy.internetshop.dao.Storage;
import mate.academy.internetshop.lib.Dao;
import mate.academy.internetshop.model.Product;

@Dao
public class ProductDaoImpl implements ProductDao {
    @Override
    public Product create(Product product) {
        Storage.addProduct(product);
        return product;
    }

    @Override
    public Optional<Product> get(Long id) {
        return Storage.prodacts.stream()
                .filter(i -> i.getProductId().equals(id))
                .findFirst();
    }

    @Override
    public List<Product> getAll() {
        return Storage.prodacts;
    }

    @Override
    public Product update(Product product) {
        IntStream.range(0, Storage.prodacts.size())
                .filter(x -> product.getProductId().equals(Storage.prodacts.get(x).getProductId()))
                .forEach(i -> Storage.prodacts.set(i, product));
        return product;
    }

    @Override
    public boolean delete(Long productId) {
        return Storage.prodacts.removeIf(i -> i.getProductId().equals(productId));
    }
}
