package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
    }

    @Test
    void whenNotFound() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Vasya", "Rybkin", "45325423", "Moscow"));
        ArrayList<Person> persons = phones.find("Ivan");
        ArrayList<Person> expected = new ArrayList<>();
        assertThat(persons).isEqualTo(expected);
    }
}