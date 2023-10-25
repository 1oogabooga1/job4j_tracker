package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void driving() {
    }

    @Override
    public void passengers(int pas) {
    }

    @Override
    public int fuel(int fuel, int price) {
        return price;
    }
}
