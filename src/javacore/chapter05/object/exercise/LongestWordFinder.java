package javacore.chapter05.object.exercise;

public class LongestWordFinder {

    public static void main(String[] args) {

        String text = "a bb ccc ddddddddddd eeeeeeeeee fffffffff gggg hhhhh iiiiiiiiiiii jjjjjj kkkkkkk mmmmmmmm";

        String longestWord = "";
        String currentWord = "";
        char space = ' ';
        System.out.println(text.length());
        // loop text
        for (int charIndex = 0; charIndex < text.length(); charIndex++) {

            // get char with index
            char currentChar = text.charAt(charIndex);

            // check currentChar
            if (currentChar == space) {
                if (currentWord.length() > longestWord.length()) {
                    longestWord = currentWord;
                }
                // new word after the space
                currentWord = "";
            }
            else {
                // build word
                currentWord += currentChar;
                // check length here to acknowledge the last word of the text
                if (charIndex == text.length() - 1 && currentWord.length() > longestWord.length()) {
                    longestWord = currentWord;
                }

            }
        }

        System.out.println("The longest word in the text is : \"" + longestWord + "\" it has " + longestWord.length() + " characters.");

//        String text = "a bb ccc ddddddddddd eeeeeeeeee fffffffff gggg hhhhh iiiiiiiiiiii jjjjjj kkkkkkk mmmmmmmm";
//        String regex = " ";
//        String[] arrayTexts = text.split(regex);
//        String longestWord = "";
//
//        for (String str : arrayTexts) {
//            if (str.length() > longestWord.length()) {
//                longestWord = str;
//            }
//        }
//        System.out.println("The longest word in the text is : \"" + longestWord + "\" it has " + longestWord.length() + " characters.");
    }

}
