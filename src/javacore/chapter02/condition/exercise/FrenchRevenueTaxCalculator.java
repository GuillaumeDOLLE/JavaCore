package javacore.chapter02.condition.exercise;

public class FrenchRevenueTaxCalculator {

    public static void main(String[] args) {

        // 5000, 15000, 50000, 125000, 250000 net taxable salary
        // I could've added for exemple 12000 because the case is interesting to see when we had the deduction
        double salary = 12000;

        // BONUS - I add the deduction, I replace the salary by the net taxable salary after deduction in my
        // conditions and my calculations though I let the salary before deduction in prints.
        double netTaxableSalaryAfterDeduction;
        double deductionPercent = 90.0 / 100;
        netTaxableSalaryAfterDeduction = salary * deductionPercent;
        System.out.println(netTaxableSalaryAfterDeduction);

        // taxable rate for each bracket
        double secondTaxBracketPercent = 89.0 / 100;
        double thirdTaxBracketPercent = 70.0 / 100;
        double fourthTaxBracketPercent = 59.0 / 100;
        double fifthTaxBracketPercent = 55.0 / 100;


        // highest amount in euros for a full bracket, there probably is a one euro differential with the instructions
        // because I subtract the upper bound of the previous bracket (I think this is how it's usually done in public
        // administration, and it is more consistent with the final results).
        int firstBracketMaxTaxableAmount = 11294;
        int secondBracketMaxTaxableAmount = 17503;
        int thirdBracketMaxTaxableAmount = 53544;
        int fourthBracketMaxTaxableAmount = 94765;

        // Upper bound of taxable brackets, I handle my conditions with these.
        int firstBracketUpperBound = 11294;
        int secondBracketUpperBound = 28797;
        int thirdBracketUpperBound = 82341;
        int fourthBracketUpperBound = 177106;

        // highest tax if full bracket
        int firstTaxBracketFull = 0;
        double secondTaxBracketFull = 1925.22;
        double thirdTaxBracketFull = 16062.9;
        double fourthTaxBracketFull = 38853.24;

        // taxable amount per bracket
        double secondTaxBracket;
        double thirdTaxBracket;
        double fourthTaxBracket;
        double fifthTaxBracket;

        // total taxable amount compared to the net taxable salary
        double totalTaxAmount;

        // percent of the total  taxable amount compared to the net taxable salary
        double percentTaxAmount;

        // variables for display purposes
        String noTaxesMessage = "With a salary of %.2f euros, there is no taxes.%n";
        String salaryAndTotalTaxesMessage = "With a salary of %.2f euros, the total amount of income tax is : %.2f euros.%n";
        String salaryAndPercentTaxesMessage = "With a salary of %.2f euros, the percentage of income tax is : %.2f%%.%n";

        if (netTaxableSalaryAfterDeduction <= firstBracketUpperBound) {
            System.out.printf(noTaxesMessage, salary);
        }
        else if (netTaxableSalaryAfterDeduction <= secondBracketUpperBound) {

            // calculation of the taxable amount on the second taxable bracket
            double secondBracketAmount;
            secondBracketAmount = netTaxableSalaryAfterDeduction - firstBracketMaxTaxableAmount;

            // calculation of the actual tax on the last taxable bracket
            secondTaxBracket = secondBracketAmount - (secondBracketAmount * secondTaxBracketPercent);

            // calculation of the taxable amount with a salary higher than 11294 euros
            totalTaxAmount = firstTaxBracketFull + secondTaxBracket;
            System.out.printf(salaryAndTotalTaxesMessage, salary, totalTaxAmount);

            // percent of total taxes compared to the net taxable salary
            percentTaxAmount = totalTaxAmount * 100 / netTaxableSalaryAfterDeduction;
            System.out.printf(salaryAndPercentTaxesMessage, salary, percentTaxAmount);

        }
        else if (netTaxableSalaryAfterDeduction <= thirdBracketUpperBound) {

            // calculation of the taxable amount on the third taxable bracket
            double thirdBracketAmount;
            thirdBracketAmount = netTaxableSalaryAfterDeduction - (firstBracketMaxTaxableAmount + secondBracketMaxTaxableAmount);

            // calculation of the actual tax on the third taxable bracket
            thirdTaxBracket = thirdBracketAmount - (thirdBracketAmount * thirdTaxBracketPercent);

            // calculation of the taxable amount with a salary higher than 28797 euros
            totalTaxAmount = firstTaxBracketFull + secondTaxBracketFull + thirdTaxBracket;
            System.out.printf(salaryAndTotalTaxesMessage, salary, totalTaxAmount);

            // percent of total taxes compared to the net taxable salary
            percentTaxAmount = totalTaxAmount * 100 / netTaxableSalaryAfterDeduction;
            System.out.printf(salaryAndPercentTaxesMessage, salary, percentTaxAmount);

        }
        else if (netTaxableSalaryAfterDeduction <= fourthBracketUpperBound) {

            // calculation of the taxable amount on the fourth taxable bracket
            double fourthBracketAmount;
            fourthBracketAmount = netTaxableSalaryAfterDeduction - (firstBracketMaxTaxableAmount + secondBracketMaxTaxableAmount + thirdBracketMaxTaxableAmount);

            // calculation of the actual tax on the fourth taxable bracket
            fourthTaxBracket = fourthBracketAmount - (fourthBracketAmount * fourthTaxBracketPercent);

            // calculation of the taxable amount with a salary higher than 82341 euros
            totalTaxAmount = firstTaxBracketFull + secondTaxBracketFull + thirdTaxBracketFull + fourthTaxBracket;
            System.out.printf(salaryAndTotalTaxesMessage, salary, totalTaxAmount);

            // percent of total taxes compared to the net taxable salary
            percentTaxAmount = totalTaxAmount * 100 / netTaxableSalaryAfterDeduction;
            System.out.printf(salaryAndPercentTaxesMessage, salary, percentTaxAmount);

        }
        else {
            // netTaxableSalaryAfterDeduction > fourthBracketUpperBound

            // calculation of the taxable amount on the last taxable bracket
            double fifthBracketAmount;
            fifthBracketAmount = netTaxableSalaryAfterDeduction - (firstBracketMaxTaxableAmount + secondBracketMaxTaxableAmount + thirdBracketMaxTaxableAmount + fourthBracketMaxTaxableAmount);

            // calculation of the actual tax on the last taxable bracket
            fifthTaxBracket  = fifthBracketAmount - (fifthBracketAmount * fifthTaxBracketPercent);

            // calculation of the taxable amount with a salary higher than 177106 euros
            totalTaxAmount = firstTaxBracketFull + secondTaxBracketFull + thirdTaxBracketFull + fourthTaxBracketFull + fifthTaxBracket;
            System.out.printf(salaryAndTotalTaxesMessage, salary, totalTaxAmount);

            // percent of total taxes compared to the net taxable salary
            percentTaxAmount = totalTaxAmount * 100 / netTaxableSalaryAfterDeduction;
            System.out.printf(salaryAndPercentTaxesMessage, salary, percentTaxAmount);

        }



        // I did it again only with ifs

        if (netTaxableSalaryAfterDeduction > fourthBracketUpperBound) {

            // calculation of the taxable amount on the last taxable bracket
            double fifthBracketAmount;
            fifthBracketAmount = netTaxableSalaryAfterDeduction - fourthBracketUpperBound;

            // calculation of the actual tax on the last taxable bracket
            fifthTaxBracket = fifthBracketAmount - (fifthBracketAmount * fifthTaxBracketPercent);

            // calculation of the taxable amount with a salary higher than 177106 euros
            totalTaxAmount = fifthTaxBracket + fourthTaxBracketFull + thirdTaxBracketFull + secondTaxBracketFull + firstTaxBracketFull;
            System.out.printf(salaryAndTotalTaxesMessage, salary, totalTaxAmount);

            // percent of total taxes compared to the net taxable salary
            percentTaxAmount = totalTaxAmount * 100 / netTaxableSalaryAfterDeduction;
            System.out.printf(salaryAndPercentTaxesMessage, salary, percentTaxAmount);
        }

        if (netTaxableSalaryAfterDeduction > thirdBracketUpperBound && netTaxableSalaryAfterDeduction <= fourthBracketUpperBound) {

            // calculation of the taxable amount on the fourth taxable bracket
            double fourthBracketAmount;
            fourthBracketAmount = netTaxableSalaryAfterDeduction - thirdBracketUpperBound;

            // calculation of the actual tax on the fourth taxable bracket
            fourthTaxBracket = fourthBracketAmount - (fourthBracketAmount * fourthTaxBracketPercent);

            // calculation of the taxable amount with a salary higher than 82341 and lower or equal than 177106 euros
            totalTaxAmount = fourthTaxBracket + thirdTaxBracketFull + secondTaxBracketFull + firstTaxBracketFull;
            System.out.printf(salaryAndTotalTaxesMessage, salary, totalTaxAmount);

            // percent of total taxes compared to the net taxable salary
            percentTaxAmount = totalTaxAmount * 100 / netTaxableSalaryAfterDeduction;
            System.out.printf(salaryAndPercentTaxesMessage, salary, percentTaxAmount);
        }

        if (netTaxableSalaryAfterDeduction > secondBracketUpperBound && netTaxableSalaryAfterDeduction <= thirdBracketUpperBound) {

            // calculation of the taxable amount on the third taxable bracket
            double thirdBracketAmount;
            thirdBracketAmount = netTaxableSalaryAfterDeduction - secondBracketUpperBound;

            // calculation of the actual tax on the last taxable bracket
            thirdTaxBracket = thirdBracketAmount - (thirdBracketAmount * thirdTaxBracketPercent);

            // calculation of the taxable amount with a salary higher than 28797 and lower or equal than 82341 euros
            totalTaxAmount = thirdTaxBracket + secondTaxBracketFull + firstTaxBracketFull;
            System.out.printf(salaryAndTotalTaxesMessage, salary, totalTaxAmount);

            // percent of total taxes compared to the net taxable salary
            percentTaxAmount = totalTaxAmount * 100 / netTaxableSalaryAfterDeduction;
            System.out.printf(salaryAndPercentTaxesMessage, salary, percentTaxAmount);
        }

        if (netTaxableSalaryAfterDeduction > firstBracketUpperBound && netTaxableSalaryAfterDeduction <= secondBracketUpperBound) {

            // calculation of the taxable amount on the third taxable bracket
            double secondBracketAmount;
            secondBracketAmount = netTaxableSalaryAfterDeduction - firstBracketUpperBound;

            // calculation of the actual tax on the last taxable bracket
            secondTaxBracket = secondBracketAmount - (secondBracketAmount * secondTaxBracketPercent);

            // calculation of the taxable amount with a salary higher than 11294 and lower or equal than 28797 euros
            totalTaxAmount = secondTaxBracket + firstTaxBracketFull;
            System.out.printf(salaryAndTotalTaxesMessage, salary, totalTaxAmount);

            // percent of total taxes compared to the net taxable salary
            percentTaxAmount = totalTaxAmount * 100 / netTaxableSalaryAfterDeduction;
            System.out.printf(salaryAndPercentTaxesMessage, salary, percentTaxAmount);
        }

        if (netTaxableSalaryAfterDeduction <= firstBracketUpperBound) {
            System.out.printf(noTaxesMessage, salary);
        }

    }

}
