package javacore.chapter05.object.practice;

public class PracticeObject {

    public static void main(String[] args) {

        PracticeObjectCar car1 = new PracticeObjectCar("ERIOJ3IORFHJ3F", "Ferrari", "F458", "rouge", 260_000);
        car1.run(2_000);
        car1.displayInformations();

        PracticeObjectCar car2 = new PracticeObjectCar("POIQHRDJEG934J", "Ford", "Mustang", "jaune", 120_000);
        car2.run(4_000);
        car2.displayInformations();

    }

    public static double run(double distance) {

        System.out.println("La voiture roule pendant " + distance + " kms.");

        return distance;
    }

}
