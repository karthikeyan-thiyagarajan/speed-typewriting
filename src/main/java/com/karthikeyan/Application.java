package com.karthikeyan;


import java.util.Scanner;

/**
 * @author Karthikeyan on 25/07/20
 */

public class Application {
    public static void main(String[] args) {
        String choice = "Y";
        while (choice.equals("Y")) {
            TypeWritter writer = new TypeWritter();
            writer.getWPM();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Do you want retry Yes (Y) / No (N) -> ");
            String userChoice = scanner.nextLine();
            if (userChoice.equalsIgnoreCase("N")) {
                choice = "N";
                System.out.println("Thank You !!!");
            } else if (!userChoice.equalsIgnoreCase("Y")) {
                System.out.println("Entered a invalid key :( -> Retrying.... ");
            }
        }
    }
}

