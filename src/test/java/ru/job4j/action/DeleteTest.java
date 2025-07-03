package ru.job4j.action;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.*;

class DeleteTest {
    @Test
    void whenDeleteSuccessfully() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("name", 1));
        Input input = mock(Input.class);
        Delete delete = new Delete(out);
        when(input.askInt(any(String.class))).thenReturn(item.getId());
        delete.execute(input, tracker);
        assertThat(out.toString()).isEqualTo("=== Удаление заявки ===" + System.lineSeparator()
                + "Заявка удалена успешно." + System.lineSeparator());
    }

    @Test
    void whenDeleteUnsuccessfully() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("name", 1));
        Input input = mock(Input.class);
        Delete delete = new Delete(out);
        delete.execute(input, tracker);
        assertThat(out.toString()).isEqualTo("=== Удаление заявки ===" + System.lineSeparator()
                + "Ошибка удаления заявки." + System.lineSeparator());
    }
}