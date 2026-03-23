package javacore.chapter05.object.exercise;

public class LongestWordFinder {

    public static void main(String[] args) {

        String text = "a bb ccc ddddddddddd eeeeeeeeee fffffffff gggg hhhhh iiiiiiiiiiii jjjjjj kkkkkkk mmmmmmmm";
        String regex = " ";
        String[] arrayTexts = text.split(regex);

        for (String str : arrayTexts) {
            int countChar = 0;
            for (int index = 0; index < str.length(); index++) {
                countChar++;
            }
            System.out.println(str + " : " + countChar);
        }

    }

}
