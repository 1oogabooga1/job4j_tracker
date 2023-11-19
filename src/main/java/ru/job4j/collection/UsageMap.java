package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("dmitrijdobrydin@gmail.com", "Dobrydin Dmitri Pavlovich");
        map.put("dmitrijdobrydin@gmail.com", "Ivan Ivanovich Ivanov");
        map.put("stepanov@gmail.com", "Dobrydin Dmitri Pavlovich");
        map.put("dmitrijdobrydin@rambler.com", "Dobrydin Dmitri Pavlovich");
        map.put("ivanov@gmail.com", "Michail Stepanovich Stepanov");
        map.put("12345678@gmail.com", "Petya Petrovich Petrov");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(value);
        }
    }
}
