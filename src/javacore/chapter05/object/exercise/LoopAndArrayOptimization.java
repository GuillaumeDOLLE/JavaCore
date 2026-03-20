package javacore.chapter05.object.exercise;

public class LoopAndArrayOptimization {

    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 4, 5};
        int[] results = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            results[i] = numbers[i] * 2 + 3;
            System.out.println(results[i]);
        }


    }

}
