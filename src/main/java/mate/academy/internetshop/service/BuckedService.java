package mate.academy.internetshop.service;

import java.util.List;
import mate.academy.internetshop.model.Bucket;

public interface BuckedService {
    Bucket addItem(Bucket bucket, Long itemId);

    List<Bucket> allBuckets();

}
