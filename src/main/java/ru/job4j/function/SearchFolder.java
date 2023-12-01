package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFolder {
    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        List<Folder> rsl = new ArrayList<>();
        Predicate<Folder> pre = s -> s.getSize() > 100 || s.getName().contains("bug");
        for (Folder f : list) {
            if (pre.test(f)) {
                rsl.add(f);
            }
        }
        return rsl;
    }
}
