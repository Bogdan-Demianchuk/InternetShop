package mate.academy.internetshop.dao.impl;

import mate.academy.internetshop.dao.BucketDao;
import mate.academy.internetshop.dao.Storage;
import mate.academy.internetshop.model.Bucket;

import java.util.NoSuchElementException;

public class BuckedDaoImpl implements BucketDao {
    @Override
    public Bucket create(Bucket bucket) {
        return null;
    }

    @Override
    public Bucket get(Long buckedId) {
        return Storage.buckets.stream()
                .filter(b -> b.getId().equals(buckedId))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Can't find bucket with id "+ buckedId));
    }

    @Override
    public Bucket update(Bucket bucket) {
        return null;
    }
}
