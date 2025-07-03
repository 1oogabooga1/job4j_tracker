package ru.job4j.action;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.*;

class FindByNameTest {

    @Test
    void whenFindByNameSuccessfully() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        Input input = mock(Input.class);
        Item item = tracker.add(new Item("name", 1));
        FindByName findByName = new FindByName(out);
        when(input.askStr(any(String.class))).thenReturn(item.getName());
        findByName.execute(input, tracker);
        assertThat(out.toString()).isEqualTo("=== Вывод заявок по имени ===" + System.lineSeparator()
                + item + System.lineSeparator());
    }

    @Test
    void whenNameIsNullThenThrowsException() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        Input input = mock(Input.class);
        tracker.add(new Item("name", 1));
        FindByName findByName = new FindByName(out);
        assertThrows(NullPointerException.class, () -> findByName.execute(input, tracker));
    }
}