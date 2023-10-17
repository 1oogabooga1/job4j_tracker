package ru.job4j.oop;

public class Cat {
    private String food;

    public void show() {
        System.out.println(this.food);
        System.out.println(this.name);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.eat("kotleta");
        Cat black = new Cat();
        black.eat("fish");
        gav.giveNick("Gav");
        black.giveNick("Black");
        System.out.println("There are black's food.");
        black.show();
        System.out.println("There are gav's food.");
        gav.show();
    }

    private String name;

    public void giveNick(String nick) {
        this.name = nick;
    }
}
