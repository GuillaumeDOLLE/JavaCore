package javacore.chapter05.object.exercise;

import java.util.Scanner;

public class VowelCounter {

    public static void main(String[] args) {

        String vowels = "aeiouy";

        String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        String loremIpsumLowerCasedAndTrimmed = loremIpsum.toLowerCase().trim();

        System.out.println("Voici le compteur de chaque voyelle présent dans le texte :");
        // Instead of looping through all the text, I only look for the vowels directly
        for (int index = 0; index < vowels.length(); index++) {
            char vowel = vowels.charAt(index);
            int countVowel = 0;
            // Get index of the first vowel
            int vowelIndex = loremIpsumLowerCasedAndTrimmed.indexOf(vowel);

            // Different from -1 so basically is there a vowel ?
            while (vowelIndex != -1) {
                countVowel++;
                // Update index based on last vowel index found
                vowelIndex = loremIpsumLowerCasedAndTrimmed.indexOf(vowel, vowelIndex + 1);

            }

            System.out.println("- " + vowel + " = " + countVowel);

        }


    }

}
