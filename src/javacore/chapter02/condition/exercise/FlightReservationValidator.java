package javacore.chapter02.condition.exercise;

public class FlightReservationValidator {

    public static void main(String[] args) {

        boolean isLoggedIn = true; // Is the user logged in ?

        int age = 25; // User age

        int seatsAvailable = 30; // Seats available in the plane

        boolean isPremiumMember = false; // Is the user a VIP member ?

        boolean isVipFlight = true; // Is the flight reserved for VIPs ?



        if (isLoggedIn && age >= 18 && seatsAvailable > 0 && (!isVipFlight || isPremiumMember)) {
            seatsAvailable--;
            System.out.println("Reservation completed successfully !");
        }
        else if (!isLoggedIn) {
            System.out.println("Reservation failed, you are not logged in.");
        }
        else if (age < 18) {
            System.out.println("Reservation failed, you are not an adult.");
        }
        else if (seatsAvailable <= 0) {
            System.out.println("Reservation failed, there are no seats available.");
        }
        else if (isVipFlight || !isPremiumMember) {
            System.out.println("Reservation failed, this flight is reserved for VIPs.");
        }

        // On peut aussi le faire avec des nested if ?
        if (isLoggedIn) {
            if (age >= 18) {
                if (seatsAvailable > 0) {
                    if (!isVipFlight || isPremiumMember) {
                        seatsAvailable--;
                        System.out.println("Reservation completed successfully !");
                    }
                    else {
                        System.out.println("Reservation failed, this flight is reserved for VIPs.");
                    }
                }
                else {
                    System.out.println("Reservation failed, there are no seats available.");
                }
            }
            else {
                System.out.println("Reservation failed, you are not an adult.");
            }
        }
        else {
            System.out.println("Reservation failed, you are not logged in.");
        }

    }

}
