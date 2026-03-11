package javacore.chapter04.function.exercise.project.refactor;

public class FrenchRevenueTaxCalculatorFunctionRefactor {

    static final double MAX_DEDUCTION_AMOUNT = 10000;

    // taxable percent for each bracket
    static final double BRACKET_1_PERCENT = 0.0;
    static final double BRACKET_2_PERCENT = 11.0;
    static final double BRACKET_3_PERCENT = 30.0;
    static final double BRACKET_4_PERCENT = 41.0;
    static final double BRACKET_5_PERCENT = 45.0;

    // Upper bound of taxable brackets, I handle conditions with these.
    static final int BRACKET_1_MIN = 0;
    static final int BRACKET_2_MIN = 11294;
    static final int BRACKET_3_MIN = 28797;
    static final int BRACKET_4_MIN = 82341;
    static final int BRACKET_5_MIN = 177106;

    // total taxable amount compared to the net taxable salary
    static double totalTaxAmount = 0;
    // percent of the total  taxable amount compared to the net taxable salary
    static double percentTaxAmount = 0;

    static double lastBracketTaxAmount;

    public static int getSocialContributionRateByStatus(boolean isWorker) {
        return isWorker ? 23 : 25;
    }

    public static double getSocialContributionAmount(double salary, int socialContributionRate) {
        return salary * socialContributionRate / 100;
    }

    public static double getDeductionAmount(double salary, double deductionPercent) {
        return salary >= MAX_DEDUCTION_AMOUNT ? MAX_DEDUCTION_AMOUNT : salary * deductionPercent / 100;
    }

    public static double getTaxBracketAmount(double remainingSalary, double minBracketAmount, double bracketPercentTax) {

        if (remainingSalary > minBracketAmount) {
            double bracketAmount = remainingSalary - minBracketAmount;
            lastBracketTaxAmount = bracketAmount * bracketPercentTax / 100;
            return minBracketAmount;
        }
        return remainingSalary;
    }

    public static void getPercentTaxAmount(double netTaxableSalaryAfterDeduction) {
        percentTaxAmount = totalTaxAmount * 100 / netTaxableSalaryAfterDeduction;
    }

    public static void main(String[] args) {

        // 5000, 15000, 50000, 125000, 200000, 250000 gross salary
        double GROSS_ANNUAL_SALARY = 200000;

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

        // taxable amount per bracket
        double firstTaxBracket = 0;
        double secondTaxBracket = 0;
        double thirdTaxBracket = 0;
        double fourthTaxBracket = 0;
        double fifthTaxBracket = 0;

        // socialContributions rule
        int socialContributionRate = getSocialContributionRateByStatus(isWorker);

        socialContributionsAmount = getSocialContributionAmount(GROSS_ANNUAL_SALARY, socialContributionRate);

        netTaxableSalaryAfterSocialContributions = GROSS_ANNUAL_SALARY - socialContributionsAmount;

        netTaxableSalaryDeductionAmount = getDeductionAmount(netTaxableSalaryAfterSocialContributions, netTaxableSalaryDeductionPercent);

        netTaxableSalaryAfterDeduction = netTaxableSalaryAfterSocialContributions - netTaxableSalaryDeductionAmount;

        // copy value
        double remainingNetTaxableSalary = netTaxableSalaryAfterDeduction;

        remainingNetTaxableSalary = getTaxBracketAmount(remainingNetTaxableSalary, BRACKET_5_MIN, BRACKET_5_PERCENT);
        fifthTaxBracket = lastBracketTaxAmount;

        remainingNetTaxableSalary = getTaxBracketAmount(remainingNetTaxableSalary, BRACKET_4_MIN, BRACKET_4_PERCENT);
        fourthTaxBracket = lastBracketTaxAmount;

        remainingNetTaxableSalary = getTaxBracketAmount(remainingNetTaxableSalary, BRACKET_3_MIN, BRACKET_3_PERCENT);
        thirdTaxBracket = lastBracketTaxAmount;

        remainingNetTaxableSalary = getTaxBracketAmount(remainingNetTaxableSalary, BRACKET_2_MIN, BRACKET_2_PERCENT);
        secondTaxBracket = lastBracketTaxAmount;

        getTaxBracketAmount(remainingNetTaxableSalary, BRACKET_1_MIN, BRACKET_1_PERCENT);
        firstTaxBracket = lastBracketTaxAmount;

        totalTaxAmount = fifthTaxBracket + fourthTaxBracket + thirdTaxBracket + secondTaxBracket + firstTaxBracket;
        getPercentTaxAmount(netTaxableSalaryAfterDeduction);

        System.out.printf("With a net taxable salary after deduction of %.2f euros, the total amount of income tax is : %.2f euros.%nThe percentage of this income tax is %.2f%%.%n", netTaxableSalaryAfterDeduction, totalTaxAmount, percentTaxAmount);

    }

}
