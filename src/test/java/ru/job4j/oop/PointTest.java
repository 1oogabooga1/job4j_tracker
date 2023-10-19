package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class PointTest {

    @Test
    void when00to20then2() {
        Point first = new Point(0, 0);
        Point second = new Point(2, 0);
        first.distance(second);
        double expected = 2;
        assertThat(first.distance(second)).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void when11to22then1dot41() {
        Point first = new Point(1, 1);
        Point second = new Point(2, 2);
        first.distance(second);
        double expected = 1.41;
        assertThat(first.distance(second)).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void when32to11then2dot23() {
        Point first = new Point(3, 2);
        Point second = new Point(1, 1);
        first.distance(second);
        double expected = 2.23;
        assertThat(first.distance(second)).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void when42to32then1() {
        Point first = new Point(4, 2);
        Point second = new Point(3, 2);
        first.distance(second);
        double expected = 1;
        assertThat(first.distance(second)).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void when99to22then9dot89() {
        Point first = new Point(9, 9);
        Point second = new Point(2, 2);
        first.distance(second);
        double expected = 9.89;
        assertThat(first.distance(second)).isEqualTo(expected, withPrecision(0.01));
    }
}