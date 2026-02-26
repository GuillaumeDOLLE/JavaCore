package javacore.chapter03.loop.exercise;

public class BasicStopwatch {

    public static void main(String[] args) throws InterruptedException {

        int i = 0;
        int seconds = 0;
        int minutes = 0;
        int hours = 0;


        /*
         * Une boucle while qui itèrera 100x grâce à l'incrémentation de la variable i (à la fin de la boucle)
         */
        while(i < 86400) {

            /*
             * Effectue une "pause" de 1000 millisecondes / 1 seconde
             */
            Thread.sleep(1000);
            System.out.println("1 seconde s'est écoulée");

            seconds++;
            if (seconds == 60) {
                minutes++;
                seconds = 0;
            }
            if (minutes == 60) {
                hours++;
                minutes = 0;
            }

            String displaySeconds = seconds < 10 ? "0" + seconds : "" + seconds;
            String displayMinutes = minutes < 10 ? "0" + minutes : "" + minutes;
            String displayHours   = hours   < 10 ? "0" + hours   : "" + hours;

            System.out.println(displayHours + ":" + displayMinutes + ":" + displaySeconds);

            /*
             * Incrémente "i = i + 1;" pour atteindre la condition de la boucle while
             */
            i++;
        }


    }

}
