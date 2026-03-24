package javacore.chapter05.object.exercise;

public class LongestWordFinder {

    public static void main(String[] args) {

        String text = "a bb ccc ddddddddddd eeeeeeeeee fffffffff gggg hhhhh iiiiiiiiiiii jjjjjj kkkkkkk mmmmmmmm";

        String longestWord = "";
        String currentWord = "";
        char space = ' ';

        // loop text
        for (int charIndex = 0; charIndex < text.length(); charIndex++) {

            // get char with index
            char currentChar = text.charAt(charIndex);

            // check currentChar
            if (currentChar != space) {
                // build word
                currentWord += currentChar;
            }
            else {
                // new word after the space
                currentWord = "";
            }

            // check length here to acknowledge the last word even with no space after it
            if (currentWord.length() > longestWord.length()) {
                longestWord = currentWord;
            }

        }

        System.out.println("The longest word in the text is : \"" + longestWord + "\" it has " + longestWord.length() + " characters.");

    }

}
