package ru.calculator.cpfc.helper;

import java.util.Scanner;

public class Helper {

    private static final Scanner scanner = new Scanner(System.in);

    public static String strInput() {
        return scanner.nextLine();
    }

    public static String strInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int intInput() {
        return scanner.nextInt();
    }

    public static int intInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    public static double doubleInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextDouble();
    }
}
