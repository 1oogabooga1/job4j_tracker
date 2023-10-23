package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean Code", 100);
        Book tolstoy = new Book("Война и Мир", 2000);
        Book pushkin = new Book("Капитанская дочка", 500);
        Book lomonosov = new Book("Петр Великий", 1000);
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = tolstoy;
        books[2] = pushkin;
        books[3] = lomonosov;
        for (Book bo : books) {
            System.out.println(bo.getName() + " - " + bo.getPages());
        }
        System.out.println("Replace 0 and 3");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (Book bo : books) {
            System.out.println(bo.getName() + " - " + bo.getPages());
        }
        for (Book bo : books) {
            if (bo.getName().equals("Clean Code")) {
                System.out.println(bo.getName() + " - " + bo.getPages());
            }
        }
    }
}
