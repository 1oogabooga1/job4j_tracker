package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"1"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu: ");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenManyValidInputs() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"1", "7"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu: ");
        assertThat(selected).isEqualTo(1);
        selected = input.askInt("Enter menu: ");
        assertThat(selected).isEqualTo(7);

    }

    @Test
    public void whenNegativeInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"-1"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu: ");
        assertThat(selected).isEqualTo(-1);
    }
}