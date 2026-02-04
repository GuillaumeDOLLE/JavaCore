package javacore.chapter02.condition.exercise;

public class CoinChangerV2 {

    public static void main(String[] args) {

        // variables for conditions & calculations
        final int FIFTY_EUROS = 50;
        final int TWENTY_EUROS = 20;
        final int TEN_EUROS = 10;
        final int TWO_EUROS = 2;
        final int ONE_EURO = 1;

        int totalBill = 11;

        int amountPaid = 50;

        // For the v2, these variables become the stock
        // For the purpose of the exercise, I add some stock, I will modify the stock when the program is good to run
        // to test multiple behaviors
        int stockOfFiftyEuroNotes = 1;
        int stockOfTwentyEuroNotes = 1;
        int stockOfTenEuroNotes = 2;
        int stockOfTwoEuroCoins = 4;
        int stockOfOneEuroCoins = 7;

        // required notes to complete the change
        int requiredFiftyEuroNotes = 0;
        int requiredTwentyEuroNotes = 0;
        int requiredTenEuroNotes = 0;
        int requiredTwoEuroCoins = 0;
        int requiredOneEuroCoins = 0;

        // given notes & coins
        int givenFiftyEuroNotes = 0;
        int givenTwentyEuroNotes = 0;
        int givenTenEuroNotes = 0;
        int givenTwoEuroCoins = 0;
        int givenOneEuroCoins = 0;

        // V2 variables for conditions | All stocks
        int maxAmountChange =
            (stockOfFiftyEuroNotes * FIFTY_EUROS) +
            (stockOfTwentyEuroNotes * TWENTY_EUROS) +
            (stockOfTenEuroNotes * TEN_EUROS) +
            (stockOfTwoEuroCoins * TWO_EUROS) +
            (stockOfOneEuroCoins * ONE_EURO);

        boolean insufficientChange;
        boolean insufficientDenominations;

        // change due by the machine to the client
        int amountChange = amountPaid - totalBill;
        int remainingAmountChange = amountChange;

        // remaining amount left to pay by the client to equal/exceed the bill amount
        int amountDue = totalBill - amountPaid;

        String insufficientDenominationsMessage = "Sorry, I do not have the correct denominations for that, do you have smaller denominations ?";

        if (totalBill == amountPaid) {
            System.out.printf("There is no change, have a good day. :)%n");
        }

        if (totalBill > amountPaid) {
            System.out.printf("You're short, I still need %d euros please.%n", amountDue);
        }

        // If there is due change to give back to the client
        if (totalBill < amountPaid) {

            // Does the machine have enough denominations ?
            if (maxAmountChange < remainingAmountChange) { // No

                insufficientChange = true;
                System.out.println("Sorry, I do not have the change for that.");

            } else { // Yes
                // I start with the highest note which is fifty in our case
                if (remainingAmountChange >= FIFTY_EUROS) {

                    // if stock of 50 is higher or equal than 1
                    if (stockOfFiftyEuroNotes >= 1) {

                        // I divide the amount change by the note to get the number of this note type the machine will try to give back
                        // It is an int
                        requiredFiftyEuroNotes = remainingAmountChange / FIFTY_EUROS;

                        // is there enough in stock ?
                        if (stockOfFiftyEuroNotes >= requiredFiftyEuroNotes) { // Yes
                            // Machine gives the required notes
                            givenFiftyEuroNotes = requiredFiftyEuroNotes;
                            // Remaining amount change is reduced by the given notes
                            remainingAmountChange %= FIFTY_EUROS;


                        } else { // No
                            // Machine gives what's left in stock
                            givenFiftyEuroNotes = stockOfFiftyEuroNotes;
                            // Remaining amount change is reduced by what's left in stock
                            remainingAmountChange -= (FIFTY_EUROS * stockOfFiftyEuroNotes);

                        }
                        // The stock is modified
                        stockOfFiftyEuroNotes -= givenFiftyEuroNotes;

                    }

                    if (stockOfTwentyEuroNotes >= 1) {

                        requiredTwentyEuroNotes = remainingAmountChange / TWENTY_EUROS;

                        if (stockOfTwentyEuroNotes >= requiredTwentyEuroNotes) {

                            givenTwentyEuroNotes = requiredTwentyEuroNotes;
                            remainingAmountChange %= TWENTY_EUROS;

                        } else {
                            givenTwentyEuroNotes = stockOfTwentyEuroNotes;
                            remainingAmountChange -= (TWENTY_EUROS * stockOfTwentyEuroNotes);

                        }

                        stockOfTwentyEuroNotes -= givenTwentyEuroNotes;

                    }

                    if (stockOfTenEuroNotes >= 1) {

                        requiredTenEuroNotes = remainingAmountChange / TEN_EUROS;

                        if (stockOfTenEuroNotes >= requiredTenEuroNotes) {

                            givenTenEuroNotes = requiredTenEuroNotes;
                            remainingAmountChange %= TEN_EUROS;

                        } else {
                            givenTenEuroNotes = stockOfTenEuroNotes;
                            remainingAmountChange -= (TEN_EUROS * stockOfTenEuroNotes);
                        }

                        stockOfTenEuroNotes -= givenTenEuroNotes;

                    }

                    if (stockOfTwoEuroCoins >= 1) {

                        requiredTwoEuroCoins = remainingAmountChange / TWO_EUROS;

                        if (stockOfTwoEuroCoins >= requiredTwoEuroCoins) {

                            givenTwoEuroCoins = requiredTwoEuroCoins;
                            remainingAmountChange %= TWO_EUROS;

                        } else {
                            givenTwoEuroCoins = stockOfTwoEuroCoins;
                            remainingAmountChange -= (TWO_EUROS * stockOfTwoEuroCoins);
                        }

                        stockOfTwoEuroCoins -= givenTwoEuroCoins;

                    }

                    if (stockOfOneEuroCoins >= 1) {

                        requiredOneEuroCoins = remainingAmountChange / ONE_EURO;

                        if (stockOfOneEuroCoins >= requiredOneEuroCoins) {

                            givenOneEuroCoins = requiredOneEuroCoins;
                            remainingAmountChange %= ONE_EURO;

                        } else {
                            givenOneEuroCoins = stockOfOneEuroCoins;
                            remainingAmountChange -= (ONE_EURO * stockOfOneEuroCoins);
                        }

                        stockOfOneEuroCoins -= givenOneEuroCoins;

                    } else {

                        System.out.println(insufficientDenominationsMessage);

                    }

                }

                if (remainingAmountChange >= TWENTY_EUROS) {

                    if (stockOfTwentyEuroNotes >= 1) {

                        requiredTwentyEuroNotes = remainingAmountChange / TWENTY_EUROS;

                        if (stockOfTwentyEuroNotes >= requiredTwentyEuroNotes) {

                            givenTwentyEuroNotes = requiredTwentyEuroNotes;
                            remainingAmountChange %= TWENTY_EUROS;

                        } else {

                            givenTwentyEuroNotes = stockOfTwentyEuroNotes;
                            remainingAmountChange -= (TWENTY_EUROS * stockOfTwentyEuroNotes);

                        }

                        stockOfTwentyEuroNotes -= givenTwentyEuroNotes;

                    }

                    if (stockOfTenEuroNotes >= 1) {

                        requiredTenEuroNotes = remainingAmountChange / TEN_EUROS;

                        if (stockOfTenEuroNotes >= requiredTenEuroNotes) {

                            givenTenEuroNotes = requiredTenEuroNotes;
                            remainingAmountChange %= TEN_EUROS;

                        } else {

                            givenTenEuroNotes = stockOfTenEuroNotes;
                            remainingAmountChange -= (TEN_EUROS * stockOfTenEuroNotes);

                        }

                        stockOfTenEuroNotes -= givenTenEuroNotes;

                    }

                    if (stockOfTwoEuroCoins >= 1) {

                        requiredTwoEuroCoins = remainingAmountChange / TWO_EUROS;

                        if (stockOfTwoEuroCoins >= requiredTwoEuroCoins) {

                            givenTwoEuroCoins = requiredTwoEuroCoins;
                            remainingAmountChange %= TWO_EUROS;


                        } else {

                            givenTwoEuroCoins = stockOfTwoEuroCoins;
                            remainingAmountChange -= (TWO_EUROS * stockOfTwoEuroCoins);

                        }

                        stockOfTwoEuroCoins -= givenTwoEuroCoins;

                    }

                    if (stockOfOneEuroCoins >= 1) {

                        requiredOneEuroCoins = remainingAmountChange / ONE_EURO;

                        if (stockOfOneEuroCoins >= requiredOneEuroCoins) {

                            givenOneEuroCoins = requiredOneEuroCoins;
                            remainingAmountChange %= ONE_EURO;

                        } else {
                            givenOneEuroCoins = stockOfOneEuroCoins;
                            remainingAmountChange -= (ONE_EURO * stockOfOneEuroCoins);
                        }

                        stockOfOneEuroCoins -= givenOneEuroCoins;

                    } else {

                        System.out.println(insufficientDenominationsMessage);

                    }

                }

                if (remainingAmountChange >= TEN_EUROS) {

                    if (stockOfTenEuroNotes >= 1) {

                        requiredTenEuroNotes = remainingAmountChange / TEN_EUROS;

                        if (stockOfTenEuroNotes >= requiredTenEuroNotes) {

                            givenTenEuroNotes = requiredTenEuroNotes;
                            remainingAmountChange %= TEN_EUROS;

                        } else {
                            givenTenEuroNotes = stockOfTenEuroNotes;
                            remainingAmountChange -= (TEN_EUROS * stockOfTenEuroNotes);
                        }

                        stockOfTenEuroNotes -= givenTenEuroNotes;

                    }

                    if (stockOfTwoEuroCoins >= 1) {

                        requiredTwoEuroCoins = remainingAmountChange / TWO_EUROS;

                        if (stockOfTwoEuroCoins >= requiredTwoEuroCoins) {

                            givenTwoEuroCoins = requiredTwoEuroCoins;
                            remainingAmountChange %= TWO_EUROS;

                        } else {
                            givenTwoEuroCoins = stockOfTwoEuroCoins;
                            remainingAmountChange -= (TWO_EUROS * stockOfTwoEuroCoins);
                        }

                        stockOfTwoEuroCoins -= givenTwoEuroCoins;
                    }

                    if (stockOfOneEuroCoins >= 1) {

                        requiredOneEuroCoins = remainingAmountChange / ONE_EURO;

                        if (stockOfOneEuroCoins >= requiredOneEuroCoins) {

                            givenOneEuroCoins = requiredOneEuroCoins;
                            remainingAmountChange %= ONE_EURO;

                        } else {
                            givenOneEuroCoins = stockOfOneEuroCoins;
                            remainingAmountChange -= (ONE_EURO * stockOfOneEuroCoins);
                        }

                        stockOfOneEuroCoins -= givenOneEuroCoins;

                    } else {

                        System.out.println(insufficientDenominationsMessage);

                    }

                }

                if (remainingAmountChange >= TWO_EUROS) {

                    if (stockOfTwoEuroCoins >= 1) {

                        requiredTwoEuroCoins = remainingAmountChange / TWO_EUROS;

                        if (stockOfTwoEuroCoins >= requiredTwoEuroCoins) {

                            givenTwoEuroCoins = requiredTwoEuroCoins;
                            remainingAmountChange %= TWO_EUROS;

                        } else {
                            givenTwoEuroCoins = stockOfTwoEuroCoins;
                            remainingAmountChange -= (TWO_EUROS * stockOfTwoEuroCoins);
                        }

                        stockOfTwoEuroCoins -= givenTwoEuroCoins;

                    }

                    if (stockOfOneEuroCoins >= 1) {

                        requiredOneEuroCoins = remainingAmountChange / ONE_EURO;

                        if (stockOfOneEuroCoins >= requiredOneEuroCoins) {

                            givenOneEuroCoins = requiredOneEuroCoins;
                            remainingAmountChange %= ONE_EURO;

                        } else {
                            givenOneEuroCoins = stockOfOneEuroCoins;
                            remainingAmountChange -= (ONE_EURO * stockOfOneEuroCoins);
                        }

                        stockOfOneEuroCoins -= givenOneEuroCoins;

                    } else {

                        System.out.println(insufficientDenominationsMessage);

                    }

                }

                if (remainingAmountChange >= ONE_EURO) {

                    if (stockOfOneEuroCoins >= 1) {

                        requiredOneEuroCoins = remainingAmountChange / ONE_EURO;

                        if (stockOfOneEuroCoins >= requiredOneEuroCoins) {

                            givenOneEuroCoins = requiredOneEuroCoins;
                            remainingAmountChange %= ONE_EURO;

                        } else {
                            givenOneEuroCoins = stockOfOneEuroCoins;
                            remainingAmountChange -= (ONE_EURO * stockOfOneEuroCoins);
                        }

                        stockOfOneEuroCoins -= givenOneEuroCoins;

                    } else {

                        System.out.println(insufficientDenominationsMessage);

                    }

                }

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
                        givenFiftyEuroNotes,
                        givenTwentyEuroNotes,
                        givenTenEuroNotes,
                        givenTwoEuroCoins,
                        givenOneEuroCoins,
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
