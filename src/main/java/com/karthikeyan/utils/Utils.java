package com.karthikeyan.utils;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Karthikeyan on 24/07/20
 */

public class Utils {
    private static final SecureRandom random = new SecureRandom();
    private static int numberOfWords;

    private Utils() {
    }

    public static String[] generateRandomWords() {
        while (numberOfWords < 5) {
            numberOfWords = random.nextInt(10);
        }
        String[] randomStrings = new String[numberOfWords];
        for (int i = 0; i < numberOfWords; i++) {
            char[] word = new char[random.nextInt(8) + 3];
            for (int j = 0; j < word.length; j++) {
                word[j] = (char) ('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }
        return randomStrings;
    }


    public static double computeTime(long t1, long t2) {
        long elapsedTime = t2 - t1;
        return elapsedTime / 1000000000d;
    }

    public static long calculateWPM(int length, double time) {
        double perSec = length / time;
        return Math.round(perSec * 60);
    }

    private static List<String> preProcessing(String input) {
        List<String> list = new ArrayList<>();
        input = input.toLowerCase();
        int strlen = input.length();
        strlen = strlen - 3;
        for (int i = 0; i <= strlen; i++)
            list.add(input.substring(i, i + 3));
        return list;
    }

    private static int matchProcessing(List<String> source, List<String> target) {
        int matchCount = 0;
        int totalCount = Math.max(source.size(), target.size());
        for (String sourceText : source) {
            if (target.contains(sourceText)) {
                matchCount++;
            }
        }
        return (matchCount * 100) / totalCount;
    }

    public static int calculateAccuracy(String src, String target) {
        src = src.replace("]", "").replace("[", "").replace(",", "");
        target = target.replace("]", "").replace("[", "").replace(",", "");
        int match = matchProcessing(preProcessing(src), preProcessing(target));
        System.out.println("Accuracy = " + match + " %");
        return match;
    }


}
