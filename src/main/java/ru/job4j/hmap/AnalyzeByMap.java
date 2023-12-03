package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double score = 0;
        int totalSubjects = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
                totalSubjects++;
            }
        }
        return score / totalSubjects;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> lab = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double rsl = 0;
            for (Subject subject : pupil.subjects()) {
                rsl += subject.score();
            }
            Label label = new Label(pupil.name(), rsl / pupil.subjects().size());
            lab.add(label);
        }
        return lab;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> result = new LinkedList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), (oldValue, newValue) -> oldValue + subject.score());
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result.add(new Label(entry.getKey(), entry.getValue() / pupils.size()));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject sub : pupil.subjects()) {
                map.merge(pupil.name(), sub.score(), (oldValue, newValue) -> oldValue + sub.score());
            }
        }
        return getMaxLabel(map);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), (oldValue, newValue) -> oldValue + subject.score());
            }
        }
        return getMaxLabel(map);
    }

    public static Label getMaxLabel(Map<String, Integer> map) {
        Map.Entry<String, Integer> maxEntry = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }
        return new Label(maxEntry.getKey(), maxEntry.getValue());
    }
}
