package ru.job4j.poly;

public interface Transport {
    void driving();

    void passengers(int pas);

    int fuel(int fuel, int price);
}
