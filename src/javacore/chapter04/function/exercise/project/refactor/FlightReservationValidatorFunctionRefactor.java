package javacore.chapter04.function.exercise.project.refactor;

public class FlightReservationValidatorFunctionRefactor {

    static final int ACCEPTED = 0;
    static final int ERR_NOT_LOGGED_IN = 1;
    static final int ERR_UNDERAGE = 2;
    static final int ERR_NO_SEAT = 3;
    static final int ERR_NO_PREMIUM_AND_VIP_FLIGHT = 4;

    public static void main(String[] args) {

        boolean isLoggedIn = true; // Is the user logged in ?
        int age = 25; // User age
        int seatsAvailable = 30; // Seats available in the plane
        boolean isPremiumMember = false; // Is the user a VIP member ?
        boolean isVipFlight = false; // Is the flight reserved for VIPs ?

        int reservationStatus = validateFlightReservation(isLoggedIn, age, seatsAvailable, isPremiumMember, isVipFlight);
        String displayReservationStatus = displayReservationStatus(reservationStatus);
        System.out.println(displayReservationStatus);
    }

    public static int validateFlightReservation(boolean loggedIn, int age, int seatsAvailable, boolean premiumMember, boolean vipFlight) {
        if (!loggedIn) return 1;
        if (age < 18) return 2;
        if (seatsAvailable <= 0) return 3;
        if (vipFlight && !premiumMember) return 4;
        return 0;
    }

    public static String displayReservationStatus(int reservationStatus) {
        if (reservationStatus == 1) return "Reservation failed, you are not logged in.";
        if (reservationStatus == 2) return "Reservation failed, you are not an adult.";
        if (reservationStatus == 3) return "Reservation failed, there are no seats available.";
        if (reservationStatus == 4) return "Reservation failed, this flight is reserved for VIPs.";
        return "Reservation completed successfully !";
    }

}
