package mate.academy.internetshop.service.impl;

import java.util.List;
import mate.academy.internetshop.dao.BucketDao;
import mate.academy.internetshop.dao.ItemDao;
import mate.academy.internetshop.dao.Storage;
import mate.academy.internetshop.lib.Inject;
import mate.academy.internetshop.lib.Service;
import mate.academy.internetshop.model.Bucket;
import mate.academy.internetshop.service.BuckedService;

@Service
public class BuckedServiceImpl implements BuckedService {
    @Inject
    private BucketDao bucketDao;
    @Inject
    private ItemDao itemDao;

    @Override
    public Bucket addItem(Bucket bucket, Long itemId) {
        bucketDao.create(bucket);
        bucket.getItems().add(itemDao.get(itemId).get());
        return bucketDao.update(bucket);
    }

    @Override
    public List<Bucket> allBuckets() {
        return Storage.buckets;
    }
}
