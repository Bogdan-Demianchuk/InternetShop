package bogdan.internetshop.service.impl;

import bogdan.internetshop.dao.ProductDao;
import bogdan.internetshop.lib.Inject;
import bogdan.internetshop.lib.Service;
import bogdan.internetshop.model.Product;
import bogdan.internetshop.service.ProductService;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Inject
    private ProductDao productDao;

    @Override
    public Product create(Product product) {
        return productDao.create(product);
    }

    @Override
    public Product get(Long productId) {
        return productDao.get(productId).get();
    }

    @Override
    public Product update(Product product) {
        return productDao.update(product);
    }

    @Override
    public boolean delete(Long productId) {
        return productDao.delete(productId);
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }
}
