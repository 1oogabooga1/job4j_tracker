package ru.job4j.action;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import ru.job4j.tracker.*;

class FindByIdTest {
    @Test
    void whenFindByIdSuccessfully() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("name", 1));
        FindById findById = new FindById(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        findById.execute(input, tracker);

        String ln = System.lineSeparator();

        assertThat(out.toString()).isEqualTo("=== Вывод заявки по id ===" + ln
                + item + ln);
    }

    @Test
    void whenFindByIdUnsuccessfully() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("name", 1));
        FindById findById = new FindById(out);

        Input input = mock(Input.class);

        findById.execute(input, tracker);

        String ln = System.lineSeparator();

        assertThat(out.toString()).isEqualTo("=== Вывод заявки по id ===" + ln
                + "Заявка с введенным id: " + 0 + " не найдена." + ln);
    }
}