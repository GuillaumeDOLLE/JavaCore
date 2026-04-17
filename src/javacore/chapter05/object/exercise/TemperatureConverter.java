package javacore.chapter05.object.exercise;

import java.sql.SQLOutput;

public class TemperatureConverter {

    public static String celsiusUnit = "°C";
    public static String fahrenheitUnit = "°F";
    public static String kelvinUnit = "K";

    public static void main (String[] args) {
        double celsiusTemperature = 27.5;

        double fahrenheitTemperature = TemperatureConverter.celsiusToFahrenheit(celsiusTemperature);

        System.out.println("FarhenheitTemperatureFromCelsius : " + fahrenheitTemperature + TemperatureConverter.fahrenheitUnit);

        System.out.println("CelsiusTemperatureFromFahrenheit : " + TemperatureConverter.fahrenheitToCelsius(fahrenheitTemperature) + TemperatureConverter.celsiusUnit);

        double kelvinTemperature = TemperatureConverter.celsiusToKelvin(celsiusTemperature);

        System.out.println("KelvinTemperatureFromCelsius : " + TemperatureConverter.celsiusToKelvin(celsiusTemperature) + TemperatureConverter.kelvinUnit);

        System.out.println("CelsiusTemperatureFromKelvin : " + TemperatureConverter.kelvinToCelsius(kelvinTemperature) + TemperatureConverter.celsiusUnit);

        System.out.println("KelvinTemperatureFromFahrenheit : " + TemperatureConverter.fahrenheitToKelvin(fahrenheitTemperature) + TemperatureConverter.kelvinUnit);

        System.out.println("FahrenheitTemperatureFromKelvin : " + TemperatureConverter.kelvinToFahrenheit(kelvinTemperature) + TemperatureConverter.fahrenheitUnit);
    }

    public static double celsiusToFahrenheit(double celsiusTemperature) {
        return celsiusTemperature * 1.8f + 32;

    }

    public static double fahrenheitToCelsius(double fahrenheitTemperature) {
        return (fahrenheitTemperature - 32) * 5 / 9;
    }

    public static double celsiusToKelvin(double celsiusTemperature) {
        return celsiusTemperature + 273.15;
    }

    public static double kelvinToCelsius(double kelvinTemperature) {
        return kelvinTemperature - 273.15;
    }

    public static double fahrenheitToKelvin(double fahrenheitTemperature) {
        return (fahrenheitTemperature + 459.67) / 1.8;
    }

    public static double kelvinToFahrenheit(double kelvinTemperature) {
        return kelvinTemperature * 1.8 - 459.67;
    }

    /*
    Question 6. Pas besoin d'instancier car on n'a pas besoin de garder en mémoire le résultat de la conversion ou de faire des calculs complexes.
    Réponse IA -> Le convertisseur ne possède ni données internes persistantes, ni comportement dépendant d'un contexte. Convertir 20°C en Fahrenheit donnera toujours le même résultat (logique fonctionnelle).
    Intention de code, une méthode static indique que le comportement ne dépend d'aucun état interne. Fonction utilitaire.
     */

}
