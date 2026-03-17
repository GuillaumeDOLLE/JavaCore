package javacore.chapter05.object.exercise;

public class Pen {

    String name = "Pen";
    String color = "Blue";
    String manufacturer = "Bic";


    double price = 2.50; // €
    double weight = 15; // g

    int quantity = 10;

    public void displayInformations() {
        System.out.println("Name : " + name + " | Color : " + color + " | Price : " + price + "€ | Quantity : " + quantity + " | Manufacturer : " + manufacturer + " | Weight : " + weight + "g.");
    }

    public static void main(String[] args) {

        Pen pen1 = new Pen();
        pen1.displayInformations();

    }

}
