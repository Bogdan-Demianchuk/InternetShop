package mate.academy.internetshop.dao;

import mate.academy.internetshop.model.Order;

import java.util.List;
import java.util.Optional;

public interface GenericDao <T, K> {
    T create(T element);

    Optional<T> get(K elementId);

    List<T> getAll();

    T update(T element);

    boolean delete(K elementId);
}
