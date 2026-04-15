package javacore.chapter05.object.exercise;

import java.util.Arrays;

public class BubbleSorting {

    public static void main(String[] args) {

        int[] numbers = {30, 25, 85, 6, 43, 58, 97, 78, 94, 27, 9, 38, 41, 35, 52, 10, 16, 22, 96, 74, 44, 55, 82, 28, 83, 69, 90, 89, 26, 7, 47, 98, 50, 42, 68, 91, 70, 65, 79, 4, 75, 49, 61, 39, 48, 72, 36, 18, 1, 15, 77, 99, 33, 24, 13, 19, 73, 17, 14, 86, 54, 45, 76, 21, 100, 63, 60, 56, 93, 87, 81, 8, 29, 34, 53, 37, 71, 67, 57, 66, 11, 46, 95, 20, 88, 64, 59, 84, 12, 92, 80, 40, 23, 3, 2, 32, 31, 5, 62, 51};

        for (int i = 0; i < numbers.length; i++) {

            for (int index = 0; index < numbers.length - 1; index++) {
                if (numbers[index] >= numbers[index + 1]) {
                    int tempValue = numbers[index];
                    numbers[index] = numbers[index + 1];
                    numbers[index + 1] = tempValue;
                }
            }

        }

        System.out.println(Arrays.toString(numbers));
    }

}
