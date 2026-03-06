package javacore.chapter04.function.exercise.project.refactor;

import java.util.Objects;

public class AgeCategorizationFunctionRefactor {

    public static void main(String[] args) {

        // 9, 10, 17, 18, 24, 25, 64, 65, 70
        int age = 70;

        int ageCategory = determineAgeCategory(age);
        String message = getAgeMessage(ageCategory);

        System.out.println("You are " + age + " years old, " + message);


    }

    // I return int numbers because I don't have access to methods to compare String at this time
    public static int determineAgeCategory(int age) {
        if (age < 10) return 0;    // child
        if (age < 18) return 1;    // teenager
        if (age < 25) return 2;    // young adult
        if (age < 65) return 3;    // adult
        return 4;                  // senior
    }

    public static String getAgeMessage(int ageCategory) {
        if (ageCategory == 0) return "you are still a child.";
        if (ageCategory == 1) return "you are a teenager.";
        if (ageCategory == 2) return "you are a young adult.";
        if (ageCategory == 3) return "you are an adult.";
        return "you are a senior.";
    }

}
