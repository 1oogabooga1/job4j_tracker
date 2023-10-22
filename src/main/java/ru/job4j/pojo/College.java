package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setDate("10 февраля");
        student.setNs("Иван Иванович Иванов");
        student.setGroup(10);
        System.out.println("Номер группы:" + " " + student.getGroup()
                + System.lineSeparator() + "Дата поступления:" + " " + student.getDate()
                + System.lineSeparator() + "ФИО:" + " " + student.getNs());
    }
}
