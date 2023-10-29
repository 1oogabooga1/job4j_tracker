package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertThrows;

class FactTest {

    @Test
    void whenException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Fact.calc(-1);
        });
        assertThat(exception.getMessage()).isEqualTo("N could not be less than 0");
    }

    @Test
    void whenCorrectFact() {
        int n = 2;
        int expected = 2;
        int result = Fact.calc(n);
        assertThat(result).isEqualTo(expected);
    }

}