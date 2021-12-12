package ru.calculator.cpfc.calculator;

public class Calculator {

    private boolean isFemale;
    private double weight;
    private double height;
    private int age;
    private double activityFactor;
    private int goal; // -15 - сбросить, 0 - поддерживать, 15 - набрать

    public Calculator(boolean isFemale, double weight, double height, int age, double activityFactor, int goal) {
        this.isFemale = isFemale;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.activityFactor = activityFactor;
        this.goal = goal;
    }

    private int calculateBaseKcalByFirstFormula() {
        return (int) (isFemale ?
                (10 * weight + 6.25 * height - 5 * age - 161) * activityFactor:
                (10 * weight + 6.25 * height - 5 * age + 5) * activityFactor
                );
    }

    private int calculateBaseKcalBySecondFormula() {
        return (int) (isFemale ?
                (447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age)) * activityFactor :
                (88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age)) * activityFactor
                );
    }

    private int calculateRecommendedKcal() {
        return (int) (calculateBaseKcalByFirstFormula() + calculateBaseKcalByFirstFormula() / 100 * activityFactor + calculateBaseKcalByFirstFormula() / 100 * goal);
    }

    private int calculateProteinRate() {
        return (int) (calculateRecommendedKcal() * 0.3 / 4);
    }

    private int calculateFatRate() {
        double percentage = goal >= 0 ? 0.3 : 0.2;
        return (int) (calculateRecommendedKcal() * percentage / 9);
    }

    private int calculateCarbohydrateRate() {
        double percentage = goal >= 0 ? 0.4 : 0.5;
        return (int) (calculateRecommendedKcal() * percentage / 4);
    }

    public void showBaseKcal() {
        System.out.println("Суточная норма калорий:");
        System.out.println("По формуле Миффлина-Сан Жеора: " + calculateBaseKcalByFirstFormula() + " ккал");
        System.out.println("По формуле Харриса Бенедикта: " + calculateBaseKcalBySecondFormula() + " ккал");
    }

    public void showDietaryGuideline() {
        String guideline;

        if (goal == 15) {
            guideline = "набора мышечной массы";
        } else if (goal == 0) {
            guideline = "поддержания веса";
        } else {
            guideline = "сброса веса";
        }

        System.out.println("Ваш ориентир для " + guideline + ":");
        System.out.println("Суточная норма калорий c учётом ориентира: " + (calculateRecommendedKcal() - 2) + " ккал");
        System.out.println("Суточная норма белка: " + calculateProteinRate() + " г");
        System.out.println("Суточная норма жиров: " + calculateFatRate() + " г");
        System.out.println("Суточная норма углеводов: " + calculateCarbohydrateRate() + " г");
    }

    public void showAll() {
        showBaseKcal();
        System.out.println();
        showDietaryGuideline();
    }
}