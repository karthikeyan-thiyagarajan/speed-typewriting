package com.karthikeyan;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Scanner;

import static com.karthikeyan.utils.Utils.*;

/**
 * @author Karthikeyan on 24/07/20
 */

public class TypeWritter {
    String[] words;
    Scanner scanner = new Scanner(System.in);

    public TypeWritter() {
        words = generateRandomWords();
    }

    protected void getWPM() {
        Arrays.stream(words).forEach(s -> System.out.print(s + " "));
        System.out.println("");
        long startTime = LocalTime.now().toNanoOfDay();
        String userWords = scanner.nextLine();
        long endTime = LocalTime.now().toNanoOfDay();
        int accuracy = calculateAccuracy(Arrays.toString(words), userWords);
        if (accuracy != 0) {
            calculateGrossWPM(startTime, userWords.replace(" ", ""), endTime);
        }
    }

    private void calculateGrossWPM(long startTime, String userWords, long endTime) {
        double computedTime = computeTime(startTime, endTime);
        long calculateWPM = calculateWPM(userWords.length(), computedTime);
        System.out.println("Your Word Per Minute (WPM) is : "+calculateWPM);
    }

}
