package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class JobTest {
    @Test
    void whenNameUp() {
        Comparator<Job> nameUp = new NameUp();
        int rsl = nameUp.compare(
                new Job("Hello", 0),
                new Job("Goodbye", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    void whenNameDown() {
        Comparator<Job> nameDown = new NameDown();
        int rsl = nameDown.compare(
                new Job("Hello", 0),
                new Job("Goodbye", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    void whenPriorityUp() {
        Comparator<Job> priorityUp = new PriorityUp();
        int rsl = priorityUp.compare(
                new Job("Hello", 0),
                new Job("Goodbye", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    void whenPriorityDown() {
        Comparator<Job> priorityDown = new PriorityDown();
        int rsl = priorityDown.compare(
                new Job("Hello", 0),
                new Job("Goodbye", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    void whenNameAndPriorityUp() {
        Comparator<Job> cmpNamePriority = new NameDown().thenComparing(new PriorityDown());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    void whenNameAndPriorityDown() {
        Comparator<Job> cmpNamePriority = new NameUp().thenComparing(new PriorityUp());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}