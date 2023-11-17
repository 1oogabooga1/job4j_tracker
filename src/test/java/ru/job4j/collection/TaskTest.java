package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class TaskTest {
    @Test
    public void extractNumber() {
        FullSearch fullSearch = new FullSearch();
        List<FullSearch> tasks = Arrays.asList(
                new FullSearch("1", "First desc"),
                new FullSearch("2", "Second desc"),
                new FullSearch("1", "First desc")
        );
        Set<String> expected = new HashSet<>(Arrays.asList("1", "2"));
        assertThat(fullSearch.extractNumber(tasks)).containsAll(expected);
    }
}