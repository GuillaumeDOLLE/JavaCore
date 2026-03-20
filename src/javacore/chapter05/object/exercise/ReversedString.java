package javacore.chapter05.object.exercise;

public class ReversedString {

    public static void main(String[] args) {

        String text = "! ecicrexe'l issuér zeva suov ,ovarB";
        String reversedText = "";
        for (int index = 0; index < text.length(); index++) {

            reversedText += text.charAt(text.length() - index - 1);

        }

        System.out.println(reversedText);

    }

}
