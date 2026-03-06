package javacore.chapter04.function.exercise.project.refactor;

public class SalaryForecastFunctionRefactor {

    public static void main(String[] args) {

        // dev france cadre 25€ brut / h
        int hourlyRate = 25;

        // travail 38.5h / sem => 7.7h / j
        float dailyRate = hourlyRate * 7.7F;
        displaySalaryForecast("Le salaire brut journalier de notre cher dev cadre francais est de : ", dailyRate);

        // salaire hebdo brut
        float weeklyRate = dailyRate * 5;
        displaySalaryForecast("Le salaire brut hebdomadaire de notre cher dev cadre francais est de : ", weeklyRate);

        // 1 mois de salaire brut : 4 semaines
        float monthlyGrossSalary = weeklyRate * 4;
        displaySalaryForecast("Le salaire brut mensuel de notre cher dev cadre francais est de : ", monthlyGrossSalary);

        // salaire annuel brut
        float annualGrossSalary = monthlyGrossSalary * 12;
        displaySalaryForecast("Le salaire brut annuel de notre cher dev cadre francais est de : ", annualGrossSalary);

        // 25% de cotisations sociales
        float socialContributionsRate = 0.75F;
        // 10.5% d'impots
        float taxesRate = 0.895F;

        float netTaxableMonthlySalary = monthlyGrossSalary * socialContributionsRate;
        displaySalaryForecast("Le salaire net imposable mensuel de notre cher dev cadre francais est de : ", netTaxableMonthlySalary);

        float netTaxableAnnualSalary = annualGrossSalary * socialContributionsRate;
        displaySalaryForecast("Le salaire net imposable annuel de notre cher dev cadre francais est de : ", netTaxableAnnualSalary);

        float netMonthlySalary = netTaxableMonthlySalary * taxesRate;
        displaySalaryForecast("Le salaire net mensuel de notre cher dev cadre francais est de : ", netMonthlySalary);

        float netAnnualSalary = netTaxableAnnualSalary * taxesRate;
        displaySalaryForecast("Le salaire net annuel de notre cher dev cadre francais est de : ", netAnnualSalary);


    }

    public static void displaySalaryForecast(String message, float value) {
        System.out.println(message + value + " euros.");
        System.out.println("---------------------------------");
    }

}
