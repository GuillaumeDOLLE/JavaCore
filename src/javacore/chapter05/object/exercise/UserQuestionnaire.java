package javacore.chapter05.object.exercise;

import java.sql.SQLOutput;
import java.util.Scanner;

public class UserQuestionnaire {

    String userName;
    int userAge;
    float userAnswerDivision;
    double userSalary;

    public UserQuestionnaire(String userName, int userAge) {
        this.userName = userName;
        this.userAge = userAge;
    }

    public void setDivisionResult(float userAnswerDivision) {
        this.userAnswerDivision = userAnswerDivision;
    }

    public void setSalary(double userSalary) {
        this.userSalary = userSalary;
    }

    public void displayUserInformations() {

        System.out.println("Merci d'avoir répondu à ce questionnaire !\nVoici vos informations :\n- Prénom : " + userName + "\n- Âge : " + userAge);

        if (userAnswerDivision == 5.0 / 2.0) {
            System.out.println("- Résultat de la division : " + userAnswerDivision);
        }

        if (userSalary > 0) {
            System.out.println("- Salaire : " + userSalary);
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Veuillez entrer votre prénom : ");
        String userName = sc.nextLine();

        System.out.print("Veuillez maintenant entrer votre âge : ");
        int userAge = sc.nextInt();

        UserQuestionnaire user = new UserQuestionnaire(userName, userAge);

        System.out.print("Voulez-vous continuer à répondre aux questions ? ");
        String userAnswer = sc.next();

        if (userAnswer.equals("non") || userAnswer.equals("Non")) {
            user.displayUserInformations();
        }
        else {
            System.out.print("Veuillez entrer le résultat de l'opération suivante : 5 / 2 = ");
            float userAnswerDivision = sc.nextFloat();

            if (userAnswerDivision != 2.5F) {
                System.out.print("Ce n'est pas le bon résultat, merci d'avoir participé à ce questionnaire !");
                user.displayUserInformations();
            }
            else {
                user.setDivisionResult(userAnswerDivision);

                System.out.print("Veuillez entrer votre salaire : ");
                double userSalary = sc.nextDouble();
                user.setSalary(userSalary);

                user.displayUserInformations();


            }

        }

        sc.close();
    }

}
