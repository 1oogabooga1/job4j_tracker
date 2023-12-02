package ru.job4j.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FunctionCalculatorTest {
    @Test
    void whenLinearFunctionFirst() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenLinearFunctionSecond() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(1, 4, x -> 5 * x + 70);
        List<Double> expected = Arrays.asList(75D, 80D, 85D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenLinearFunctionThird() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(2, 5, x -> 3 * x + 7);
        List<Double> expected = Arrays.asList(13D, 16D, 19D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenSquareFunctionFirst() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(-2, 3, x -> 2 * Math.pow(x, 2) + 1);
        List<Double> expected = Arrays.asList(9D, 3D, 1D, 3D, 9D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenSquareFunctionSecond() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(1, 6, x -> 2 * Math.pow(x, 2) + 1);
        List<Double> expected = Arrays.asList(3D, 9D, 19D, 33D, 51D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenLSquareFunctionThird() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(8, 14, x -> 7 * Math.pow(x, 2) + 5);
        List<Double> expected = Arrays.asList(453D, 572D, 852D, 1013D, 1188D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenShowingFunctionFirst() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(1, 4, x -> 7 * Math.pow(x, x) + 5);
        List<Double> expected = Arrays.asList(12D, 33D, 194D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenShowingFunctionSecond() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(4, 8, x -> 7 * Math.pow(x, x) + 5);
        List<Double> expected = Arrays.asList(1797D, 21880D, 326597D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenShowingFunctionThird() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(-3, 0, x -> 4 * Math.pow(x, x) + 1);
        List<Double> expected = Arrays.asList(0.8518518518518519D, 2D, -3D);
        assertThat(result).containsAll(expected);
    }
}