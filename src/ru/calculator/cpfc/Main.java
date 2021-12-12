package ru.calculator.cpfc;

import ru.calculator.cpfc.calculator.Calculator;
import ru.calculator.cpfc.helper.Helper;

public class Main {
    public static void main(String[] args) {
        Commands.start();
    }
}

class Commands {

    public static void start() {
        System.out.println("Программа для расчёта ккал и БЖУ");
        int answer = Helper.intInput("""
                Выберите пункт (введите цифру):\s
                1 - воспользоваться калькулятором\s
                2 - выйти\s
                """);
        while(answer < 1 || answer > 2) {
            answer = Helper.intInput("Введите корректную цифру: ");
        }
        if (answer == 1) {
            fillData();
        } else {
            System.exit(0);
        }
    }

    private static void fillData() {
        int intAnswer = Helper.intInput("""
                Ваш пол:\s
                1 - мужской\s
                2 - женский\s
                """);
        while(intAnswer < 1 || intAnswer > 2) {
            intAnswer = Helper.intInput("Введите корректную цифру: ");
        }
        boolean isFemale = intAnswer != 1;

        double doubleAnswer = Helper.doubleInput("Ваш вес (в кг): ");
        while(doubleAnswer < 20 || doubleAnswer > 300) {
            doubleAnswer = Helper.intInput("Введите корректное значение: ");
        }
        double weight = doubleAnswer;

        doubleAnswer = Helper.doubleInput("Ваш рост (в см): ");
        while(doubleAnswer < 80 || doubleAnswer > 250) {
            doubleAnswer = Helper.intInput("Введите корректное значение: ");
        }
        double height = doubleAnswer;

        intAnswer = Helper.intInput("Ваш возраст: ");
        while(intAnswer < 14 || intAnswer > 90) {
            intAnswer = Helper.intInput("Введите корректное значение: ");
        }
        int age = intAnswer;

        double activityFactor = 0;
        intAnswer = Helper.intInput("""
                Ваш образ жизни:\s
                1 - малоактивный (сидячий, малоподвижный образ жизни)\s
                2 - слабая активность (тренировки 1-3 раза в неделю)\s
                3 - средняя активность (тренировки 3-5 раза в неделю)\s
                4 - высокая активность (нагрузки каждый день)\s
                5 - экстремальная активность (постоянная нагрузка в течении дня)\s
                """);
        while(intAnswer < 1 || intAnswer > 5) {
            intAnswer = Helper.intInput("Введите корректную цифру: ");
        }
        switch (intAnswer) {
            case 1 -> activityFactor = 1.2;
            case 2 -> activityFactor = 1.375;
            case 3 -> activityFactor = 1.55;
            case 4 -> activityFactor = 1.7;
            case 5 -> activityFactor = 1.9;
        }

        int goal = 0;
        intAnswer = Helper.intInput("""
                Ваша цель:\s
                1 - сбросить вес\s
                2 - поддерживать вес\s
                3 - набрать вес\s
                """);
        while(intAnswer < 1 || intAnswer > 3) {
            intAnswer = Helper.intInput("Введите корректную цифру: ");
        }
        switch (intAnswer) {
            case 1 -> goal = -15;
            case 2 -> goal = 0;
            case 3 -> goal = 15;

        }

        Calculator calculator = new Calculator(isFemale, weight, height, age, activityFactor, goal);

        calculator.showAll();
    }
}