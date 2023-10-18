package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
     this.active = active;
     this.status = status;
     this.message = message;
    }

    public void print() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.print();
        Error settings = new Error(true, 2, "привет");
        settings.print();
        Error another = new Error(false, 4, "Bye");
        another.print();
    }
}

