package mate.academy.internetshop.dao.impl;

import mate.academy.internetshop.dao.ItemDao;
import mate.academy.internetshop.dao.Storage;
import mate.academy.internetshop.model.Item;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ItemDaoImpl implements ItemDao {
    @Override
    public Item create(Item item) {
        Storage.items.add(item);
        return item;
    }

    @Override
    public Optional<Item> get(Long id) {
        return Storage.items.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                ;
    }

    @Override
    public List<Item> getAll() {
        return Storage.items;
    }

    @Override
    public Item update(Item item) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(Item item) {

    }
}
