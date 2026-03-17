package javacore.chapter05.object.exercise;

public class Pen {

    String name;
    String color;
    String manufacturer;


    double price; // €
    double weight; // g

    int quantity;

    public void displayInformations() {
        System.out.println("Name : " + name + " | Color : " + color + " | Price : " + price + "€ | Quantity : " + quantity + " | Manufacturer : " + manufacturer + " | Weight : " + weight + "g.");
    }

    public static void main(String[] args) {

        Pen pen1 = new Pen();

        pen1.name = "Pen";
        pen1.color = "Blue";
        pen1.manufacturer = "Bic";
        pen1.price = 2.5;
        pen1.weight = 15;
        pen1.quantity = 10;

        pen1.displayInformations();

    }

}
