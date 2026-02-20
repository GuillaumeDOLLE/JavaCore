package javacore.chapter03.loop.exercise;

public class CoinChangerV3 {

    public static void main(String[] args) {

        int totalBill = 137;

        int amountPaid = 500;

        int requiredFiftyEuroNotes = 0;
        int requiredTwentyEuroNotes = 0;
        int requiredTenEuroNotes = 0;
        int requiredTwoEuroCoins = 0;
        int requiredOneEuroCoins = 0;

        final int NOTES_EUROS_FIFTY_VALUE = 50;
        final int NOTES_EUROS_TWENTY_VALUE = 20;
        final int NOTES_EUROS_TEN_VALUE = 10;
        final int COINS_EUROS_TWO_VALUE = 2;
        final int COINS_EUROS_ONE_VALUE = 1;

        // change due by the machine to the client
        int amountChange = amountPaid - totalBill;
        // copy
        int remainingAmount = amountChange;

        // remaining amount left to pay by the client to equal/exceed the bill amount
        int amountDue = totalBill - amountPaid;

        if (totalBill == amountPaid) {
            System.out.println("There is no change, have a good day. :)");
        }

        else if (totalBill > amountPaid) {
            System.out.printf("You're short, I still need %d euros please.%n", amountDue);
        }

        else {
            // loop to reduce the remaining amount with priority on highest notes
            while (remainingAmount >= NOTES_EUROS_FIFTY_VALUE) {
                remainingAmount -= NOTES_EUROS_FIFTY_VALUE;
                requiredFiftyEuroNotes++;
            }

            while (remainingAmount >= NOTES_EUROS_TWENTY_VALUE) {
                remainingAmount -= NOTES_EUROS_TWENTY_VALUE;
                requiredTwentyEuroNotes++;
            }

            while (remainingAmount >= NOTES_EUROS_TEN_VALUE) {
                remainingAmount -= NOTES_EUROS_TEN_VALUE;
                requiredTenEuroNotes++;
            }

            while (remainingAmount >= COINS_EUROS_TWO_VALUE) {
                remainingAmount -= COINS_EUROS_TWO_VALUE;
                requiredTwoEuroCoins++;
            }

            while (remainingAmount >= COINS_EUROS_ONE_VALUE) {
                remainingAmount -= COINS_EUROS_ONE_VALUE;
                requiredOneEuroCoins++;
            }
        }
        System.out.println("Amount change : " + amountChange);
        System.out.println("Remaining amount : " + remainingAmount);
        System.out.printf("Details :%n- %d Fifty Euro notes.%n" +
                "- %d Twenty Euro Notes.%n" +
                "- %d Ten Euro Notes.%n" +
                "- %d Two Euro Coins.%n" +
                "- %d One Euro Coins.%n",
                requiredFiftyEuroNotes,
                requiredTwentyEuroNotes,
                requiredTenEuroNotes,
                requiredTwoEuroCoins,
                requiredOneEuroCoins);
    }

}
