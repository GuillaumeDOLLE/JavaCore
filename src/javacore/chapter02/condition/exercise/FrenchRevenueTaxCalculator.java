package javacore.chapter02.condition.exercise;

public class FrenchRevenueTaxCalculator {

    public static void main(String[] args) {

        // 5000, 15000, 50000, 125000, 200000, 250000 gross salary
        final double GROSS_SALARY = 200000;

        // employeeType for conditions
        boolean isWorker = true;

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
        final double BRACKET_2_PERCENT = 11.0;
        final double BRACKET_3_PERCENT = 30.0;
        final double BRACKET_4_PERCENT = 41.0;
        final double BRACKET_5_PERCENT = 45.0;

        // Upper bound of taxable brackets, I handle conditions with these.
        final int BRACKET_2_MIN = 11294;
        final int BRACKET_3_MIN = 28797;
        final int BRACKET_4_MIN = 82341;
        final int BRACKET_5_MIN = 177106;

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
        if (isWorker) {

            socialContributionsPercent = 23;

        } else {

            socialContributionsPercent = 25;

        }
        socialContributionsAmount = GROSS_SALARY * socialContributionsPercent / 100;

        netTaxableSalaryAfterSocialContributions = GROSS_SALARY - socialContributionsAmount;

        // Deduction rule
        netTaxableSalaryDeductionAmount = netTaxableSalaryAfterSocialContributions * netTaxableSalaryDeductionPercent / 100;

        if (netTaxableSalaryDeductionAmount >= 10000) {

            netTaxableSalaryDeductionAmount = 10000;

        }
        netTaxableSalaryAfterDeduction = netTaxableSalaryAfterSocialContributions - netTaxableSalaryDeductionAmount;

        // copy value
        double remainingNetTaxableSalary = netTaxableSalaryAfterDeduction;

        if (remainingNetTaxableSalary > BRACKET_5_MIN) {

            // taxable amount on fifth bracket
            double fifthBracketAmount = netTaxableSalaryAfterDeduction - BRACKET_5_MIN;

            // tax amount
            fifthTaxBracket = fifthBracketAmount * BRACKET_5_PERCENT / 100;

            // subtract remaining salary with the amount taxed in this bracket to go in the next if (cascade)
            remainingNetTaxableSalary = BRACKET_5_MIN;

        }

        if (remainingNetTaxableSalary > BRACKET_4_MIN) {

            double fourthBracketAmount = remainingNetTaxableSalary - BRACKET_4_MIN;

            fourthTaxBracket = fourthBracketAmount * BRACKET_4_PERCENT / 100;

            remainingNetTaxableSalary = BRACKET_4_MIN;

        }

        if (remainingNetTaxableSalary > BRACKET_3_MIN) {

            double thirdBracketAmount = remainingNetTaxableSalary - BRACKET_3_MIN;;

            thirdTaxBracket = thirdBracketAmount * BRACKET_3_PERCENT / 100;

            remainingNetTaxableSalary = BRACKET_3_MIN;

        }

        if (remainingNetTaxableSalary > BRACKET_2_MIN) {

            double secondBracketAmount = remainingNetTaxableSalary - BRACKET_2_MIN;

            secondTaxBracket = secondBracketAmount * BRACKET_2_PERCENT / 100;

        }

        if (netTaxableSalaryAfterDeduction > BRACKET_2_MIN) {

            // either that or totalTaxAmount += taxBracket for each if
            totalTaxAmount = fifthTaxBracket + fourthTaxBracket + thirdTaxBracket + secondTaxBracket;

            percentTaxAmount = totalTaxAmount * 100 / netTaxableSalaryAfterDeduction;

            System.out.printf("With a net taxable salary after deduction of %.2f euros, the total amount of income tax is : %.2f euros.%nThe percentage of this income tax is %.2f%%.%n", netTaxableSalaryAfterDeduction, totalTaxAmount, percentTaxAmount);

        } else {

            System.out.printf("With a salary of %.2f euros, you have no taxes to pay.%n", netTaxableSalaryAfterDeduction);

        }

    }

}
