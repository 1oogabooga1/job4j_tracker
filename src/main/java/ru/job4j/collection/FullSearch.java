package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {
        private String number;
        private String description;

        public FullSearch(String number, String description) {
            this.number = number;
            this.description = description;
        }

        public FullSearch() {
        }

        public String getNumber() {
            return number;
        }

        public HashSet<String> extractNumber(List<FullSearch> list) {
            HashSet<String> numbers = new HashSet<>();
            for (FullSearch fullSearch : list) {
                numbers.add(fullSearch.getNumber());
            }
            return numbers;
        }
}

