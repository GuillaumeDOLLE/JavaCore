package javacore.chapter01.variable.exercise;

public class CelsiusFahrenheitConverter {

    public static void main(String[] args) {

    float temperatureCelsius = 19.2f;
    float temperatureFahrenheit = (temperatureCelsius * 1.8f) + 32;
    System.out.println("La température en celsius d'une valeur de : " + temperatureCelsius + "°C" + " équivaut à une température en fahrenheit d'une valeur de : " + temperatureFahrenheit + " °F.");

    }

}
