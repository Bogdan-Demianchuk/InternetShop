package mate.academy.internetshop.dao;

import java.util.List;
import mate.academy.internetshop.model.Bucket;

public interface BucketDao {
    Bucket create(Bucket bucket);

    Bucket get(Long buckedId);

    Bucket update(Bucket bucket);

    boolean delete(Long bucketId);

    boolean delete(Bucket bucket);

    List<Bucket> getAll();
}
