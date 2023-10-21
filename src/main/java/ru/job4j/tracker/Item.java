package ru.job4j.tracker;

import java.sql.SQLOutput;
import java.time.LocalDateTime;

public class Item {
    private LocalDateTime created = LocalDateTime.now();
    private int id;
    private String name;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public class StartUI {

        public static void main(String[] args) {
            Item item = new Item();
            System.out.println(item.getCreated());

        }
    }
}
