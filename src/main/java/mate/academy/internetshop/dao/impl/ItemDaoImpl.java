package mate.academy.internetshop.dao.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import mate.academy.internetshop.dao.ItemDao;
import mate.academy.internetshop.dao.Storage;
import mate.academy.internetshop.lib.Dao;
import mate.academy.internetshop.model.Item;

@Dao
public class ItemDaoImpl implements ItemDao {
    @Override
    public Item create(Item item) {
        Storage.addItem(item);
        return item;
    }

    @Override
    public Optional<Item> get(Long id) {
        return Storage.items.stream()
                .filter(i -> i.getItemId().equals(id))
                .findFirst();
    }

    @Override
    public List<Item> getAll() {
        return Storage.items;
    }

    @Override
    public Item update(Item item) {
        IntStream.range(0, Storage.items.size())
                .filter(x -> item.getItemId().equals(Storage.items.get(x).getItemId()))
                .forEach(i -> Storage.items.set(i, item));
        return item;
    }

    @Override
    public boolean delete(Long itemId) {
        return Storage.items.removeIf(i -> i.getItemId().equals(itemId));
    }

    @Override
    public boolean delete(Item item) {
        return Storage.items.remove(item);
    }
}
