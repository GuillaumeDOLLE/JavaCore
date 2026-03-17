package javacore.chapter04.function.exercise;

public class CoinChangerV4 {

    // variables for conditions & calculations
    public static final int NOTES_EUROS_FIFTY_VALUE = 50;
    public static final int NOTES_EUROS_TWENTY_VALUE = 20;
    public static final int NOTES_EUROS_TEN_VALUE = 10;
    public static final int COINS_EUROS_TWO_VALUE = 2;
    public static final int COINS_EUROS_ONE_VALUE = 1;

    public static int getRequiredEuroNotesOrCoinsByValue(int remainingAmountChange, int stockByValue, int eurosValue) {
        int requiredEuros = remainingAmountChange / eurosValue;
        if (requiredEuros > stockByValue) {
            return stockByValue;
        }
        return requiredEuros;

//        return requiredEuros > stockByValue ? stockByValue : requiredEuros;
    }

    public static int getMaxAmountOfStockAvailable(int stockFifty, int stockTwenty, int stockTen, int stockTwo, int stockOne) {
        return stockFifty * NOTES_EUROS_FIFTY_VALUE +
                stockTwenty * NOTES_EUROS_TWENTY_VALUE +
                stockTen * NOTES_EUROS_TEN_VALUE +
                stockTwo * COINS_EUROS_TWO_VALUE +
                stockOne * COINS_EUROS_ONE_VALUE;
    }

    public static void main(String[] args) {

        int totalBill = 50;

        int amountPaid = 190;

        // For the v2, these variables become the stock
        // For the purpose of the exercise, I add some stock, I will modify the stock when the program is good to run
        // to test multiple behaviors
        int stockFiftyEuroNotes = 3;
        int stockTwentyEuroNotes = 0;
        int stockTenEuroNotes = 3;
        int stockTwoEuroCoins = 4;
        int stockOneEuroCoins = 3;

        // required notes to complete the change
        int requiredFiftyEuroNotes = 0;
        int requiredTwentyEuroNotes = 0;
        int requiredTenEuroNotes = 0;
        int requiredTwoEuroCoins = 0;
        int requiredOneEuroCoins = 0;

        // change due by the machine to the client
        int amountChange = amountPaid - totalBill;
        int remainingAmountChange = amountChange;

        // remaining amount left to pay by the client to equal/exceed the bill amount
        int amountDue = totalBill - amountPaid;

        // V2 variables for conditions | All stocks
        int maxAmountAvailable = getMaxAmountOfStockAvailable(stockFiftyEuroNotes, stockTwentyEuroNotes, stockTenEuroNotes,
                stockTwoEuroCoins, stockOneEuroCoins);

        if (totalBill == amountPaid) {
            System.out.printf("There is no change, have a good day. :)%n");
        }

        else if (totalBill > amountPaid) {
            System.out.printf("You're short, I still need %d euros please.%n", amountDue);
        }
        // If there is due change to give back to the client
        // Does the machine have enough denominations ?
        else if (maxAmountAvailable < remainingAmountChange) { // No
            System.out.println("Sorry, I do not have the change for that.");
        }

        else { // Yes
            requiredFiftyEuroNotes = getRequiredEuroNotesOrCoinsByValue(remainingAmountChange, stockFiftyEuroNotes, NOTES_EUROS_FIFTY_VALUE);
            // Remaining is the amount minus what's given
            remainingAmountChange -= (requiredFiftyEuroNotes * NOTES_EUROS_FIFTY_VALUE);
            // stock of fifty is the base amount minus what's given
            stockFiftyEuroNotes -= requiredFiftyEuroNotes;


            requiredTwentyEuroNotes = getRequiredEuroNotesOrCoinsByValue(remainingAmountChange, stockTwentyEuroNotes, NOTES_EUROS_TWENTY_VALUE);
            remainingAmountChange -= (requiredTwentyEuroNotes * NOTES_EUROS_TWENTY_VALUE);
            stockTwentyEuroNotes -= requiredTwentyEuroNotes;


            requiredTenEuroNotes = getRequiredEuroNotesOrCoinsByValue(remainingAmountChange, stockTenEuroNotes, NOTES_EUROS_TEN_VALUE);
            remainingAmountChange -= (requiredTenEuroNotes * NOTES_EUROS_TEN_VALUE);
            stockTenEuroNotes -= requiredTenEuroNotes;


            requiredTwoEuroCoins = getRequiredEuroNotesOrCoinsByValue(remainingAmountChange, stockTwoEuroCoins, COINS_EUROS_TWO_VALUE);
            remainingAmountChange -= (requiredTwoEuroCoins * COINS_EUROS_TWO_VALUE);
            stockTwoEuroCoins -= requiredTwoEuroCoins;


            requiredOneEuroCoins = getRequiredEuroNotesOrCoinsByValue(remainingAmountChange, stockOneEuroCoins, COINS_EUROS_ONE_VALUE);
            remainingAmountChange -= (requiredOneEuroCoins * COINS_EUROS_ONE_VALUE);
            stockOneEuroCoins -= requiredOneEuroCoins;


            if (remainingAmountChange > 0) {
                System.out.println("Sorry, I do not have the correct denominations for that, do you have smaller denominations ?");
            }

            else {
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
                        stockFiftyEuroNotes,
                        stockTwentyEuroNotes,
                        stockTenEuroNotes,
                        stockTwoEuroCoins,
                        stockOneEuroCoins);
            }

        }

    }

}
