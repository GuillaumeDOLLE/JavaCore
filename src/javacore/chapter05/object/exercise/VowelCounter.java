package javacore.chapter05.object.exercise;

public class VowelCounter {

    public static void main(String[] args) {

        String vowels = "aeiouy";
        int vowelsACounter = 0;
        int vowelsECounter = 0;
        int vowelsICounter = 0;
        int vowelsOCounter = 0;
        int vowelsUCounter = 0;
        int vowelsYCounter = 0;


        String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        String loremIpsumCaseInsensitiveAndTrimmed = loremIpsum.toLowerCase().trim();
        System.out.println(loremIpsum);

        for (int index = 0; index < loremIpsumCaseInsensitiveAndTrimmed.length(); index++) {
            char cr = loremIpsumCaseInsensitiveAndTrimmed.charAt(index);
            for (int i = 0; i < vowels.length(); i++) {
                if (cr == vowels.charAt(i)) {
                    if (cr == 'a') {
                        vowelsACounter++;
                    }
                    if (cr == 'e') {
                        vowelsECounter++;
                    }
                    if (cr == 'i') {
                        vowelsICounter++;
                    }
                    if (cr == 'o') {
                        vowelsOCounter++;
                    }
                    if (cr == 'u') {
                        vowelsUCounter++;
                    }
                    if (cr == 'y') {
                        vowelsYCounter++;
                    }

                }
            }
        }

        System.out.println("Voici le compteur de chaque voyelle :\n- a = " + vowelsACounter + "\n- e = "
                + vowelsECounter + "\n- i = " + vowelsICounter + "\n- o = " + vowelsOCounter + "\n- u = " +
                vowelsUCounter + "\n- y = " + vowelsYCounter);

    }

}
