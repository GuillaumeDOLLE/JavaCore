package javacore.chapter01.variable.exercise;

public class SalaryForecast {

    public static void main(String[] args) {

        // dev france cadre 25€ brut / h
        int hourlyRate = 25;

        // travail 38.5h / sem => 7.7h / j
        float dailyRate = hourlyRate * 7.7F;
        System.out.println("Le salaire brut journalier de notre cher dev cadre francais est de : " + dailyRate + " euros.");
        System.out.println("---------------------------------");

        // salaire hebdo brut
        float weeklyRate = dailyRate * 5;
        System.out.println("Le salaire brut hebdomadaire de notre cher dev cadre francais est de : " + weeklyRate + " euros.");
        System.out.println("---------------------------------");

        // 1 mois de salaire brut : 4 semaines
        float monthlyGrossSalary = weeklyRate * 4;
        System.out.println("Le salaire brut mensuel de notre cher dev cadre francais est de : " + monthlyGrossSalary + " euros.");
        System.out.println("---------------------------------");

        // salaire annuel brut
        float annualGrossSalary = monthlyGrossSalary * 12;
        System.out.println("Le salaire brut annuel de notre cher dev cadre francais est de : " + annualGrossSalary + " euros.");
        System.out.println("---------------------------------");

        // 25% de cotisations sociales
        float socialContributionsRate = 0.75F;
        // 10.5% d'impots
        float taxesRate = 0.895F;

        float netTaxableMonthlySalary = monthlyGrossSalary * socialContributionsRate;
        System.out.println("Le salaire net imposable mensuel de notre cher dev cadre francais est de : " + netTaxableMonthlySalary + " euros.");
        System.out.println("---------------------------------");

        float netTaxableAnnualSalary = annualGrossSalary * socialContributionsRate;
        System.out.println("Le salaire net imposable annuel de notre cher dev cadre francais est de : " + netTaxableAnnualSalary + " euros.");
        System.out.println("---------------------------------");

        float netMonthlySalary = netTaxableMonthlySalary * taxesRate;
        System.out.println("Le salaire net mensuel de notre cher dev cadre francais est de : " + netMonthlySalary + " euros.");
        System.out.println("---------------------------------");

        float netAnnualSalary = netTaxableAnnualSalary * taxesRate;
        System.out.println("Le salaire net annuel de notre cher dev cadre francais est de : " + netAnnualSalary + " euros.");
        System.out.println("---------------------------------");

    }

}
