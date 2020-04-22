package mate.academy.internetshop.service;

import mate.academy.internetshop.model.Bucket;

public interface BackedService {
    //crud
    Bucket addItem(Long bucketId, Long itemId);

}
