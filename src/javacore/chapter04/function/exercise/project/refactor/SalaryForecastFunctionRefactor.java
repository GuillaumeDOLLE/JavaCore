package javacore.chapter04.function.exercise.project.refactor;

public class SalaryForecastFunctionRefactor {

    public static void main(String[] args) {

        // dev france cadre 25€ brut / h
        int hourlyRate = 25;

        // travail 38.5h / sem => 7.7h / j
        float dailyRate = hourlyRate * 7.7F;
        System.out.println("Le salaire brut journalier de notre cher dev cadre francais est de : " + dailyRate + " euros.\n---------------------------------");

        // salaire hebdo brut
        float weeklyRate = dailyRate * 5;
        System.out.println("Le salaire brut hebdomadaire de notre cher dev cadre francais est de : " + weeklyRate + " euros.\n---------------------------------");

        // 1 mois de salaire brut : 4 semaines
        float monthlyGrossSalary = weeklyRate * 4;
        System.out.println("Le salaire brut mensuel de notre cher dev cadre francais est de : " + monthlyGrossSalary + " euros.\n---------------------------------");

        // salaire annuel brut
        float annualGrossSalary = monthlyGrossSalary * 12;
        System.out.println("Le salaire brut annuel de notre cher dev cadre francais est de : " + annualGrossSalary + " euros.\n---------------------------------");

        // 25% de cotisations sociales
        float socialContributionsRate = 0.75F;
        // 10.5% d'impots
        float taxesRate = 0.895F;

        float netTaxableMonthlySalary = calculateNetTaxableSalary(monthlyGrossSalary, socialContributionsRate);
        System.out.println("Le salaire net imposable mensuel de notre cher dev cadre francais est de : " + netTaxableMonthlySalary + " euros.\n---------------------------------");

        float netTaxableAnnualSalary = calculateNetTaxableSalary(annualGrossSalary, socialContributionsRate);
        System.out.println("Le salaire net imposable annuel de notre cher dev cadre francais est de : " + netTaxableAnnualSalary + " euros.\n---------------------------------");

        float netMonthlySalary = calculateNetSalary(netTaxableMonthlySalary, taxesRate);
        System.out.println("Le salaire net mensuel de notre cher dev cadre francais est de : " + netMonthlySalary + " euros.\n---------------------------------");

        float netAnnualSalary = calculateNetSalary(netTaxableAnnualSalary, taxesRate);
        System.out.println("Le salaire net annuel de notre cher dev cadre francais est de : " + netAnnualSalary + " euros.\n---------------------------------");

    }

    public static float calculateNetTaxableSalary(float salary, float socialContributionsRate) {
        return salary * socialContributionsRate;
    }

    public static float calculateNetSalary(float salary, float taxesRate) {
        return salary * taxesRate;
    }

}
