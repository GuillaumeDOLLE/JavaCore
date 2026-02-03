package javacore.chapter02.condition.exercise;

public class FrenchRevenueTaxCalculator {

    public static void main(String[] args) {

        // 5000, 15000, 50000, 125000, 200000, 250000 gross salary
        double grossSalary = 15000;

        // employeeType for conditions
        String employeeType = "Worker"; // or Executive
        double socialContributionsPercent = 0;
        double socialContributionsAmount = 0;

        // initialize
        double netTaxableSalaryAfterSocialContributions = 0;

        // BONUS - I add the deduction, I replace the salary by the net taxable salary after deduction in my
        // conditions and my calculations though I let the salary before deduction in prints.
        double netTaxableSalaryAfterDeduction;
        double netTaxableSalaryDeductionPercent = 10;
        double netTaxableSalaryDeductionAmount = 0;

        // taxable percent for each bracket
        double secondTaxBracketPercent = 11.0;
        double thirdTaxBracketPercent = 30.0;
        double fourthTaxBracketPercent = 41.0;
        double fifthTaxBracketPercent = 45.0;

        // Upper bound of taxable brackets, I handle conditions with these.
        int firstBracketUpperBound = 11294;
        int secondBracketUpperBound = 28797;
        int thirdBracketUpperBound = 82341;
        int fourthBracketUpperBound = 177106;

        // taxable amount per bracket
        double secondTaxBracket = 0;
        double thirdTaxBracket = 0;
        double fourthTaxBracket = 0;
        double fifthTaxBracket = 0;

        // total taxable amount compared to the net taxable salary
        double totalTaxAmount = 0;

        // percent of the total  taxable amount compared to the net taxable salary
        double percentTaxAmount = 0;

        // socialContributions rule
        if (employeeType.equals("Worker")) {

            socialContributionsPercent = 23;
            socialContributionsAmount = grossSalary * socialContributionsPercent / 100;
            netTaxableSalaryAfterSocialContributions = grossSalary - socialContributionsAmount;


        } else if (employeeType.equals("Executive")) {

            socialContributionsPercent = 25;
            socialContributionsAmount = grossSalary * socialContributionsPercent / 100;
            netTaxableSalaryAfterSocialContributions = grossSalary - socialContributionsAmount;

        }

        // Deduction rule
        if (netTaxableSalaryAfterSocialContributions >= 100000) {

            netTaxableSalaryDeductionAmount = 10000;
            netTaxableSalaryAfterDeduction = netTaxableSalaryAfterSocialContributions - netTaxableSalaryDeductionAmount;

        } else {

            netTaxableSalaryDeductionAmount = netTaxableSalaryAfterSocialContributions * netTaxableSalaryDeductionPercent / 100;
            netTaxableSalaryAfterDeduction = netTaxableSalaryAfterSocialContributions - netTaxableSalaryDeductionAmount;

        }

        // copy to keep the base value intact
        double remainingNetTaxableSalary = netTaxableSalaryAfterDeduction;

        if (remainingNetTaxableSalary > fourthBracketUpperBound) {

            // taxable amount on fifth bracket
            double fifthBracketAmount;
            fifthBracketAmount = netTaxableSalaryAfterDeduction - fourthBracketUpperBound;

            // tax amount
            fifthTaxBracket = fifthBracketAmount * fifthTaxBracketPercent / 100;

            // subtract remaining salary with the amount taxed in this bracket to go in the next if (cascade)
            remainingNetTaxableSalary -= fifthBracketAmount;

        }

        if (remainingNetTaxableSalary > thirdBracketUpperBound) {

            double fourthBracketAmount;
            fourthBracketAmount = remainingNetTaxableSalary - thirdBracketUpperBound;

            fourthTaxBracket = fourthBracketAmount * fourthTaxBracketPercent / 100;

            remainingNetTaxableSalary -= fourthBracketAmount;

        }

        if (remainingNetTaxableSalary > secondBracketUpperBound) {

            double thirdBracketAmount;
            thirdBracketAmount = remainingNetTaxableSalary - secondBracketUpperBound;

            thirdTaxBracket = thirdBracketAmount * thirdTaxBracketPercent / 100;

            remainingNetTaxableSalary -= thirdBracketAmount;

        }

        if (remainingNetTaxableSalary > firstBracketUpperBound) {

            double secondBracketAmount;
            secondBracketAmount = remainingNetTaxableSalary - firstBracketUpperBound;

            secondTaxBracket = secondBracketAmount * secondTaxBracketPercent / 100;

        }

        if (netTaxableSalaryAfterDeduction > firstBracketUpperBound) {

            // either that or totalTaxAmount += taxBracket for each if
            totalTaxAmount = fifthTaxBracket + fourthTaxBracket + thirdTaxBracket + secondTaxBracket;
            percentTaxAmount = totalTaxAmount * 100 / netTaxableSalaryAfterDeduction;
            System.out.printf("With a net taxable salary after deduction of %.2f euros, the total amount of income tax is : %.2f euros.%nThe percentage of this income tax is %.2f%%.%n", netTaxableSalaryAfterDeduction, totalTaxAmount, percentTaxAmount);

        } else {

            System.out.printf("With a salary of %.2f euros, you have no taxes to pay.%n", netTaxableSalaryAfterDeduction);

        }

    }

}
