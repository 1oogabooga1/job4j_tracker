package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public boolean isEquals(String originText, String duplicateText) {
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String st : origin) {
            check.add(st);
            }
        for (String str : text) {
            if (!check.contains(str)) {
                return false;
            }
        }
        return true;
    }
}
