package ru.job4j.inheritance;

public class Programmer extends Profession {
    private String programLang;

    public Programmer(String programLang, boolean degree, int experience) {
        super(experience, degree);
        this.programLang = programLang;
    }
}

