package mate.academy.internetshop.dao.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;
import mate.academy.internetshop.dao.BucketDao;
import mate.academy.internetshop.dao.Storage;
import mate.academy.internetshop.lib.Dao;
import mate.academy.internetshop.model.Bucket;

@Dao
public class BucketDaoImpl implements BucketDao {

    @Override
    public Bucket create(Bucket bucket) {
        Storage.addBucket(bucket);
        return bucket;
    }

    @Override
    public Bucket get(Long buckedId) {
        return Storage.buckets.stream()
                .filter(b -> b.getBucketId().equals(buckedId))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Can't find BU with id " + buckedId));
    }

    @Override
    public Bucket update(Bucket bucket) {
        IntStream.range(0, Storage.buckets.size())
                .filter(x -> bucket.getBucketId().equals(Storage.buckets.get(x).getBucketId()))
                .forEach(i -> Storage.buckets.set(i, bucket));
        return bucket;
    }

    @Override
    public boolean delete(Long bucketId) {
        return Storage.buckets.removeIf(b -> b.getBucketId().equals(bucketId));
    }

    @Override
    public boolean delete(Bucket bucket) {
        return Storage.buckets.remove(bucket);
    }

    @Override
    public List<Bucket> getAll() {
        return Storage.buckets;
    }
}
