package javacore.chapter02.condition.exercise;

public class CoinChangerV1 {

    public static void main(String[] args) {

        // 100, 50, 40, 30, 20, 11, 7, 4, 2
        int totalBill = 11;

        int amountPaid = 50;

        int numberOfFiftyEuroNotes;
        int numberOfTwentyEuroNotes;
        int numberOfTenEuroNotes;
        int numberOfTwoEuroCoins;
        int numberOfOneEuroCoins;

        // variables for conditions & calculations
        int fiftyEuros = 50;
        int twentyEuros = 20;
        int tenEuros = 10;
        int twoEuros = 2;
        int oneEuro = 1;

        // change due by the machine to the client
        int amountChange = amountPaid - totalBill;

        // remaining amount left to pay by the client to equal/exceed the bill amount
        int amountDue = totalBill - amountPaid;

        // messages to display
        String noChangeMessage = "There is no change, have a good day. :)%n";
        String amountDueMessage = "You're short, I still need %d euros please.%n";
        String amountChangeMessage = "The total amount change is %d euros.%nThe details are as follow :%n";
        String amountChangeDetailsMessage = "- Number of %s euro %s : %d.%n";

        if (totalBill == amountPaid) {

            System.out.printf(noChangeMessage);

        }

        if (totalBill > amountPaid) {

            System.out.printf(amountDueMessage, amountDue);

        }

        // If there is due change to give back to the client
        if (totalBill < amountPaid) {

            System.out.printf(amountChangeMessage, amountChange);
            // I start with the highest note which is fifty in our case
            if (amountChange >= fiftyEuros) {

                // I divide the amount change by the note to get the number of this note type the machine will give back
                numberOfFiftyEuroNotes = amountChange / fiftyEuros;
                System.out.printf(amountChangeDetailsMessage, "fifty", "notes", numberOfFiftyEuroNotes);
                // The amount change is reduced by the amount of the note type is given back
                amountChange = amountChange % fiftyEuros;

            }

            // if there is still change to give back then we continue in the conditions, and it is the same for the rest of them
            if (amountChange >= twentyEuros) {

                numberOfTwentyEuroNotes = amountChange / twentyEuros;
                System.out.printf(amountChangeDetailsMessage, "twenty", "notes", numberOfTwentyEuroNotes);
                amountChange = amountChange % twentyEuros;

            }

            if (amountChange >= tenEuros) {

                numberOfTenEuroNotes = amountChange / tenEuros;
                System.out.printf(amountChangeDetailsMessage, "ten", "notes", numberOfTenEuroNotes);
                amountChange = amountChange % tenEuros;

            }

            if (amountChange >= twoEuros) {

                numberOfTwoEuroCoins = amountChange / twoEuros;
                System.out.printf(amountChangeDetailsMessage, "two", "coins", numberOfTwoEuroCoins);
                amountChange = amountChange % twoEuros;

            }

            if (amountChange >= oneEuro) {

                numberOfOneEuroCoins = amountChange / oneEuro;
                System.out.printf(amountChangeDetailsMessage, "one", "coins", numberOfOneEuroCoins);

                // I put amountChange here aswell as before but in our case it is always 0, and I don't really use it but for the logic of the exercise it is here
                amountChange = amountChange % oneEuro;
            }
                // I feel like there might be a better way to display everything
        }
    }

}
