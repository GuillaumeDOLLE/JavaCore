package javacore.chapter05.object.exercise;

public class FirstArrays {

    public static void displayArray(int[] array) {

        System.out.print("Valeurs du tableau = ");
        for (int index = 0; index < array.length; index++) {
            System.out.print(array[index]);
            if (index < array.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {

        int[] integerArray = new int[10];

        integerArray[0] = 1;

        for (int index = 0; index < integerArray.length; index++) {
            integerArray[index] = index + 1;
        }

        displayArray(integerArray);

        for (int index = 0; index < integerArray.length; index++) {
            integerArray[index] *= 3;
        }

        displayArray(integerArray);

        System.out.print("Valeurs du tableau = ");
        for (int index = 0; index < integerArray.length; index++) {
            if (integerArray[index] % 2 == 0) {
                System.out.print(integerArray[index]);
                if (index < integerArray.length - 1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println();

        for (int index = 0; index < integerArray.length; index++) {
            if (integerArray[index] % 3 == 0) {
                if (index == 0) {
                    integerArray[index] = 0;
                }
                else {
                    integerArray[index - 1] = 0;
                }
            }
        }

        displayArray(integerArray);

    }

}
