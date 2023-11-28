package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] first = o1.split("/");
        String[] second = o2.split("/");
        int result = second[0].compareTo(first[0]);
        if (result != 0) {
            return result;
        }
        for (int i = 1; i < Math.min(first.length, second.length); i++) {
            result = first[i].compareTo(second[i]);
            if (result != 0) {
                return result;
            }
        }
        return Integer.compare(first.length, second.length);
    }
}


