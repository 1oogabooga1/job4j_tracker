package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class JobTest {
    @Test
    void whenNameUp() {
        Comparator<Job> nameUp = new JobAscByName();
        int rsl = nameUp.compare(
                new Job("Hello", 0),
                new Job("Goodbye", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    void whenNameDown() {
        Comparator<Job> nameDown = new JobDescByName();
        int rsl = nameDown.compare(
                new Job("Hello", 0),
                new Job("Goodbye", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    void whenPriorityUp() {
        Comparator<Job> priorityUp = new JobAscByPriority();
        int rsl = priorityUp.compare(
                new Job("Hello", 0),
                new Job("Goodbye", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    void whenPriorityDown() {
        Comparator<Job> priorityDown = new JobDescByPriority();
        int rsl = priorityDown.compare(
                new Job("Hello", 0),
                new Job("Goodbye", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    void whenNameAndPriorityUp() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    void whenNameAndPriorityDown() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }
}