package javacore.chapter05.object.practice;

public class PracticeObjectCar {

    String serialNumber;
    String brand;
    String model;
    String color;

    double price;
    double odometer;

    public PracticeObjectCar(String serialNumber, String brand, String model, String color, double price) {

        this.serialNumber = serialNumber;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.price = price;
        this.odometer = 0;

        this.displayInformations();

    }

    public double run(double distance) {
        System.out.println("La voiture roule pendant " + distance + " kms.");
        odometer += distance;
        return distance;
    }

    public void displayInformations() {

         System.out.println("N° Série : " + this.serialNumber + " | Marque : " + this.brand + " | Modèle : " + this.model + " | Couleur : " + this.color + " | Kilométrage : " + this.odometer + " kms.");

    }

}
