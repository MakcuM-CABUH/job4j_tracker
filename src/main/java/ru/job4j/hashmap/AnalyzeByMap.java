package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        if (pupils.isEmpty()) {
            return 0.0;
        }
        int totalScore = 0;
        int totalSubjects = 0;

        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();

            for (Subject subject : subjects) {
                totalScore += subject.score();
                totalSubjects++;
            }
        }
        double result = (double) totalScore / totalSubjects;
        if (totalSubjects == 0) {
            return 0.0;
        }
        return result;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();

        for (Pupil pupil : pupils) {
            String name = pupil.name();
            List<Subject> subjects = pupil.subjects();
            int totalScore = 0;
            int subjectCount = subjects.size();

            for (Subject subject : subjects) {
                totalScore += subject.score();
            }
            double averageScore = subjectCount > 0 ? (double) totalScore / subjectCount : 0.0;
            Label label = new Label(name, averageScore);
            result.add(label);
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> subjectScoresSum = new LinkedHashMap<>();
        int pupilCount = pupils.size();
        if (pupilCount == 0) {
            return List.of();
        }
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                String subjectName = subject.name();
                int score = subject.score();

                int currentSum = subjectScoresSum.getOrDefault(subjectName, 0);
                subjectScoresSum.put(subjectName, currentSum + score);
            }
        }
        List<Label> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : subjectScoresSum.entrySet()) {
            String subjectName = entry.getKey();
            int totalScore = entry.getValue();

            double averageScore = (double) totalScore / pupilCount;
            Label label = new Label(subjectName, averageScore);
            result.add(label);
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        if (pupils == null || pupils.isEmpty()) {
            return null;
        }
        List<Label> labels = new ArrayList<>();

        for (Pupil pupil : pupils) {
            String name = pupil.name();
            List<Subject> subjects = pupil.subjects();
            int totalScore = 0;

            for (Subject subject : subjects) {
                totalScore += subject.score();
            }
            Label label = new Label(name, totalScore);
            labels.add(label);
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        if (pupils == null || pupils.isEmpty()) {
            return null;
        }
        Map<String, Integer> subjectScoresSum = new LinkedHashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                String subjectName = subject.name();
                int score = subject.score();

                int currentSum = subjectScoresSum.getOrDefault(subjectName, 0);
                subjectScoresSum.put(subjectName, currentSum + score);
            }
        }
        if (subjectScoresSum.isEmpty()) {
            return null;
        }
        List<Label> labels = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : subjectScoresSum.entrySet()) {
            String subjectName = entry.getKey();
            int totalScore = entry.getValue();

            Label label = new Label(subjectName, totalScore);
            labels.add(label);
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}
