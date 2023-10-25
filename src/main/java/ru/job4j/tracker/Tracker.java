package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[items.length];
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (key.equals(items[i].getName())) {
                result[counter] = items[i];
                counter++;
            }
        }
        return Arrays.copyOf(result, counter);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        boolean rsl = indexOf(id) != -1;
        if (rsl) {
            item.setId(id);
            items[indexOf(id)] = item;
            return true;
        }
        return false;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < size; i++) {
            if (items[i].getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    public void delete(int id) {
        boolean rsl = indexOf(id) != -1;
        if (rsl) {
            System.arraycopy(items, indexOf(id) + 1, items, indexOf(id), size - indexOf(id) - 1);
            items[size - 1] = null;
            size--;
        }
    }
}