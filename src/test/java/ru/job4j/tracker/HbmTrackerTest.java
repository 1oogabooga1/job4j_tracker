package ru.job4j.tracker;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import java.util.List;

class HbmTrackerTest {

    @Test
    void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    void whenAddItemAndDeleteThenFindByIdIsNull() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item("Test");
            int id = tracker.add(item).getId();
            tracker.delete(id);
            assertThat(tracker.findById(id)).isNull();
            assertThat(tracker.findByName("Test")).isEmpty();
        }
    }

    @Test
    void whenAddItemAndReplaceThanItHasNewName() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item("Test");
            int id = tracker.add(item).getId();
            Item newItem = new Item("Replaced Item");
            assertThat(tracker.replace(id, newItem)).isTrue();
            assertThat(tracker.findByName("Replaced Item").get(0).getId()).isEqualTo(id);
            assertThat(tracker.findById(id).getName()).isEqualTo(newItem.getName());
        }
    }

    @Test
    void whenCreateTwoItemsThenFindAll() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item first = tracker.add(new Item("first"));
            Item second = tracker.add(new Item("second"));
            assertThat(tracker.findAll()).usingRecursiveComparison().ignoringFields("created").isEqualTo(List.of(first, second));
            assertThat(tracker.findById(first.getId())).isEqualTo(first);
            assertThat(tracker.findById(second.getId())).isEqualTo(second);
            assertThat(tracker.findByName(first.getName()).get(0)).isEqualTo(first);
            assertThat(tracker.findByName(second.getName()).get(0)).isEqualTo(second);
        }
    }
}