package javacore.chapter05.object.exercise;

public class BasicStopwachV2 {

    int seconds;
    int minutes;
    int hours;


    public void launch(int seconds, int minutes, int hours, final int SECONDS_PER_MINUTE, final int MINUTES_PER_HOUR)
            throws InterruptedException {

        while(true) {
            Thread.sleep(1000);

            seconds++;
            if(seconds >= SECONDS_PER_MINUTE) {
                minutes++;
                seconds = 0;
                if (minutes >= MINUTES_PER_HOUR) {
                    hours++;
                    minutes = 0;
                }
            }
            displayTime(hours, minutes, seconds);
        }

    }

    public void displayTime(int hours, int minutes, int seconds) {

        String displaySeconds = seconds < 10 ? "0" + seconds : "" + seconds;
        String displayMinutes = minutes < 10 ? "0" + minutes : "" + minutes;
        String displayHours   = hours   < 10 ? "0" + hours   : "" + hours;

        System.out.println(displayHours + ":" + displayMinutes + ":" + displaySeconds);

    }

    public static void main(String[] args) throws InterruptedException {

        final int SECONDS_PER_MINUTE = 60;
        final int MINUTES_PER_HOUR = 60;

        BasicStopwachV2 basicStopwatch = new BasicStopwachV2();
        basicStopwatch.seconds = 0;
        basicStopwatch.minutes = 0;
        basicStopwatch.hours = 0;

        basicStopwatch.launch(basicStopwatch.seconds, basicStopwatch.minutes, basicStopwatch.hours, SECONDS_PER_MINUTE, MINUTES_PER_HOUR);

    }

}
