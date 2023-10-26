package ru.job4j.cast;

public class Main {
    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle train = new Train();
        Vehicle air = new Airplane();
        Vehicle[] veh = new Vehicle[]{bus, train, air};
        for (Vehicle a: veh) {
            a.move();
        }
    }
}
