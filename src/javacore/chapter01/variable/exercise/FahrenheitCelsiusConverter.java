package javacore.chapter01.variable.exercise;

public class FahrenheitCelsiusConverter {

    public static void main(String[] args) {

    float temperatureFahrenheit = 70.5f;
    float temperatureCelsius = (temperatureFahrenheit - 32) * 5 / 9;
    System.out.println("La température en fahrenheit d'une valeur de : " + temperatureFahrenheit + "°F" + " équivaut à une température en celsius d'une valeur de : " + temperatureCelsius + " °C.");

    }

}
