package javacore.chapter05.object.exercise;

public class ReferenceManipulation {

    String name;
    int counter;

    public ReferenceManipulation(String name) {

        this.name = name;
        this.counter = 0;

    }

    public static void displayReferenceName(String name, int counter) {

        System.out.println("Reference name : " + name + " counter : " + counter);

    }

    public static void updateCounter(ReferenceManipulation object) {

        object.counter++;

    }

    public static void main(String[] args) {

        ReferenceManipulation reference1 = new ReferenceManipulation("reference1");
        // 5.
        displayReferenceName(reference1.name, reference1.counter);

        ReferenceManipulation copy1 = reference1;
        // 7.
        displayReferenceName(copy1.name, copy1.counter);

        // 9.
        updateCounter(reference1);

        // 10.
        displayReferenceName(reference1.name, reference1.counter);

        // 11.
        displayReferenceName(copy1.name, copy1.counter);

        // 12.
        updateCounter(copy1);

        // 13.
        displayReferenceName(reference1.name, reference1.counter);
        displayReferenceName(copy1.name, copy1.counter);

        // 14.
        copy1 = new ReferenceManipulation("reference2");

        // 15.
        displayReferenceName(reference1.name, reference1.counter);
        displayReferenceName(copy1.name, copy1.counter);

        // 16.
        reference1 = new ReferenceManipulation("reference1");

        // 17.
        displayReferenceName(reference1.name, reference1.counter);
    }


}
