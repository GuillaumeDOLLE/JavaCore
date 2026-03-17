package javacore.chapter04.function.exercise;

public class RecursiveFactorial {

    public static long getFactorial(int number, long result) {

        if (number > 1) {
            return getFactorial(number - 1, result * number);
        }

        return result;
    }

    public static void main(String[] args) {

        int number = 6;
        int tempNumber = number;
        long result = 1;

        if (tempNumber < 0) {
            System.out.println("You can't calculate the factorial number if it is negative.");
        }
        else if (tempNumber == 0) {
            System.out.println("The factorial number of 0 is automatically 1.");
        }
        else {
            result = getFactorial(tempNumber, result);
            System.out.printf("The factorial of %d is : %d.%n", number, result);
        }
    }

}
