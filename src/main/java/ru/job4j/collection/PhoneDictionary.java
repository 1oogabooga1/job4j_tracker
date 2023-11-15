package ru.job4j.collection;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person pers : persons) {
            if (pers.getName().contains(key)) {
                result.add(pers);
            }
            if (pers.getPhone().contains(key)) {
                result.add(pers);
            }
            if (pers.getAddress().contains(key)) {
                result.add(pers);
            }
            if (pers.getSurname().contains(key)) {
                result.add(pers);
            }
        }
        return result;
    }
}
