package javacore.chapter04.function.exercise.project.refactor;

public class FactorialCalculatorFunctionRefactor {

    public static long calculateFactorial(int number) {
        long result = 1;

        while (number > 1) {
            result += result * (number - 1);
            number--;
        }
        return result;
    }

    public static void displayFactorial(int number) {
        if (number < 0) {
            System.out.println("You can't calculate the factorial number if it is negative.");
        }
        else if (number == 0) {
            System.out.println("The factorial number of 0 is automatically 1.");
        }
        else {
            long result = calculateFactorial(number);
            System.out.printf("The factorial of %d is : %d.%n", number, result);
        }
    }

    public static void main(String[] args) {
        int number = 10;
        int tempNumber;
        tempNumber = number;

        displayFactorial(tempNumber);
    }
}
