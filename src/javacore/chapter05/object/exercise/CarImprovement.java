package javacore.chapter05.object.exercise;

public class CarImprovement {

    String serialNumber;
    String brand;
    String model;
    String color;

    double price;
    double odometer;

    boolean isEngineStarted;

    public CarImprovement(String serialNumber, String brand, String model, String color, double price) {

        this.serialNumber = serialNumber;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.price = price;
        this.odometer = 0;
        // We could put it in the parameters, but it is the same logic as odometer
        this.isEngineStarted = false; // false because when the car is created, the engine is not started until we actually drive the car to go somewhere.


        this.displayInformations();

    }

    // This method should have an impact on isEngineStarted
    public double run(double distance) {
        this.isEngineStarted = true;
        System.out.println("La voiture roule pendant " + distance + " kms.");
        this.odometer += distance;
        return distance;
    }

    // This method might fluctuate depending on the value of isEngineStarted
    public void displayInformations() {
        String engineStatus = this.isEngineStarted ? "Démarrée" : "Arrêtée";
        System.out.println("N° Série : " + this.serialNumber + " | Marque : " + this.brand + " | Modèle : " + this.model + " | Couleur : " + this.color + " | Kilométrage : " + this.odometer + " kms | Etat de démarrage : " + engineStatus);

    }

    public static void main(String[] args) {
        CarImprovement car1 = new CarImprovement("IEJFIOPEZJSFPZEOJF", "Lamborghini", "Gallardo", "Noir", 500_000);
        car1.run(3000);
        car1.displayInformations();
        // We can see in the logs that when the run method is called, the isEngineStarted switch to true and the odometer value increases
    }

}
