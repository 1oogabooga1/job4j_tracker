package ru.job4j.lombok;

public class LombokUsage {
    public static void main(String[] args) {
        var permission = Permission.of()
                .id(1)
                .name("Test name")
                .rules("First rule")
                .rules("Second rule")
                .build();
        System.out.println(permission);
    }
}
