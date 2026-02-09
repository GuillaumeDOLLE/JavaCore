package javacore.chapter02.condition.exercise;

public class CoinChangerV2 {

    public static void main(String[] args) {

        // variables for conditions & calculations
        final int NOTES_EUROS_FIFTY = 50;
        final int NOTES_EUROS_TWENTY = 20;
        final int NOTES_EUROS_TEN = 10;
        final int COINS_EUROS_TWO = 2;
        final int COINS_EUROS_ONE = 1;

        int totalBill = 50;

        int amountPaid = 190;

        // For the v2, these variables become the stock
        // For the purpose of the exercise, I add some stock, I will modify the stock when the program is good to run
        // to test multiple behaviors
        int stockOfFiftyEuroNotes = 3;
        int stockOfTwentyEuroNotes = 0;
        int stockOfTenEuroNotes = 3;
        int stockOfTwoEuroCoins = 4;
        int stockOfOneEuroCoins = 3;

        // required notes to complete the change
        int requiredFiftyEuroNotes = 0;
        int requiredTwentyEuroNotes = 0;
        int requiredTenEuroNotes = 0;
        int requiredTwoEuroCoins = 0;
        int requiredOneEuroCoins = 0;

        // V2 variables for conditions | All stocks
        int maxAmountAvailable = // maxAmountAvailable
            (stockOfFiftyEuroNotes * NOTES_EUROS_FIFTY) +
            (stockOfTwentyEuroNotes * NOTES_EUROS_TWENTY) +
            (stockOfTenEuroNotes * NOTES_EUROS_TEN) +
            (stockOfTwoEuroCoins * COINS_EUROS_TWO) +
            (stockOfOneEuroCoins * COINS_EUROS_ONE);

        // change due by the machine to the client
        int amountChange = amountPaid - totalBill;
        int remainingAmountChange = amountChange;

        // remaining amount left to pay by the client to equal/exceed the bill amount
        int amountDue = totalBill - amountPaid;

        String insufficientDenominationsMessage = "Sorry, I do not have the correct denominations for that, do you have smaller denominations ?";

        if (totalBill == amountPaid) {
            System.out.printf("There is no change, have a good day. :)%n");
        }

        else if (totalBill > amountPaid) {
            System.out.printf("You're short, I still need %d euros please.%n", amountDue);
        }

        // If there is due change to give back to the client
        else {

            // Does the machine have enough denominations ?
            if (maxAmountAvailable < remainingAmountChange) { // No
                
                System.out.println("Sorry, I do not have the change for that.");

            } else { // Yes
                // How much fifty euro notes are required ?
                requiredFiftyEuroNotes = remainingAmountChange / NOTES_EUROS_FIFTY;
                // Does the machine have enough stock ?
                if (requiredFiftyEuroNotes > stockOfFiftyEuroNotes) {
                    // Gives full stock
                    requiredFiftyEuroNotes = stockOfFiftyEuroNotes;
                }
                // Remaining is the amount minus what's given
                remainingAmountChange -= (NOTES_EUROS_FIFTY * requiredFiftyEuroNotes);
                // stock of fifty is the base amount minus what's given
                stockOfFiftyEuroNotes -= requiredFiftyEuroNotes;

                requiredTwentyEuroNotes = remainingAmountChange / NOTES_EUROS_TWENTY;
                if (requiredTwentyEuroNotes > stockOfTwentyEuroNotes) {

                    requiredTwentyEuroNotes = stockOfTwentyEuroNotes;

                }
                remainingAmountChange -= (NOTES_EUROS_TWENTY * requiredTwentyEuroNotes);
                stockOfTwentyEuroNotes -= requiredTwentyEuroNotes;


                requiredTenEuroNotes = remainingAmountChange / NOTES_EUROS_TEN;
                if (requiredTenEuroNotes > stockOfTenEuroNotes) {

                    requiredTenEuroNotes = stockOfTenEuroNotes;

                }
                remainingAmountChange -= (NOTES_EUROS_TEN * requiredTenEuroNotes);
                stockOfTenEuroNotes -= requiredTenEuroNotes;

                requiredTwoEuroCoins = remainingAmountChange / COINS_EUROS_TWO;
                if (requiredTwoEuroCoins > stockOfTwoEuroCoins) {

                    requiredTwoEuroCoins = stockOfTwoEuroCoins;


                }
                remainingAmountChange -= (COINS_EUROS_TWO * requiredTwoEuroCoins);
                stockOfTwoEuroCoins -= requiredTwoEuroCoins;

                requiredOneEuroCoins = remainingAmountChange / COINS_EUROS_ONE;
                if (requiredOneEuroCoins > stockOfOneEuroCoins) {

                    requiredOneEuroCoins = stockOfOneEuroCoins;

                    System.out.println(insufficientDenominationsMessage);

                }
                remainingAmountChange -= (COINS_EUROS_ONE * requiredOneEuroCoins);
                stockOfOneEuroCoins -= requiredOneEuroCoins;

                System.out.printf("The total amount change is %d euros.%nHere is your change : %n" +
                        "50 euro notes = %d%n" +
                        "20 euro notes = %d%n" +
                        "10 euro notes = %d%n" +
                        "2 euro coins = %d%n" +
                        "1 euro coins = %d%n" +
                        "The remaining amount change is %d euros.%n" +
                        "My stock left is as followed : %n" +
                        "- 50 euro notes = %d%n" +
                        "- 20 euro notes = %d%n" +
                        "- 10 euro notes = %d%n" +
                        "- 2 euro coins = %d%n" +
                        "- 1 euro coins = %d%n",
                        amountChange,
                        requiredFiftyEuroNotes,
                        requiredTwentyEuroNotes,
                        requiredTenEuroNotes,
                        requiredTwoEuroCoins,
                        requiredOneEuroCoins,
                        remainingAmountChange,
                        stockOfFiftyEuroNotes,
                        stockOfTwentyEuroNotes,
                        stockOfTenEuroNotes,
                        stockOfTwoEuroCoins,
                        stockOfOneEuroCoins);

            }



        }

    }

}
