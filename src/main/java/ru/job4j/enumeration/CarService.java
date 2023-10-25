package ru.job4j.enumeration;

public class CarService {
    public static void main(String[] args) {
        Status toyota = Status.FINISHED;
        Status volvo = Status.WAITING;
        System.out.println(toyota);
        System.out.println(volvo);
        Order order = new Order(1, "Mercedes", Status.IN_WORK);
        System.out.println(order.getCar() + order.getNumber() + order.getStatus().getInfo() + order.getStatus().getMessage());
        Status[] statuses = Status.values();
        for (Status s  : statuses) {
            System.out.println(s.name() + s.ordinal());
        }
    }
}
