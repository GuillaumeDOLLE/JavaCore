package javacore.chapter05.object.exercise;

public class LibraryBook {

    String isbn;
    String title;
    String author;

    int publishedYear;

    boolean availability;

    public void displayInformations() {

        System.out.println("ISBN : " + isbn + " | title : " + title + " | author : " + author + " | published year : " + publishedYear + " | availability : " + availability);

    }

    public static void main(String[] args) {

        LibraryBook book1 = new LibraryBook();

        book1.isbn = "9782226199539";
        book1.title = "L'alliance des trois";
        book1.author = "Maxime Chattam";
        book1.publishedYear = 2009;
        book1.availability = true;
        book1.displayInformations();

    }

}
