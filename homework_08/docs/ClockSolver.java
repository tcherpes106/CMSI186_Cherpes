/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  ClockSolver.java
 *  Purpose       :  Provides a class which illustrates a sting representaion of a given time
 *  Author        :  Timothy Cherpes
 *  Date          :  2020-05-04
 *  Description   :  This class provides what is needed to illustrate a given command line argument
 *                   formatted as HH:MM:SS as a string representation.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

public class ClockSolver {

    // Public fields for the program
    public String hours;
    public String minutes;
    public String seconds;

    /** Constructor for the class. Uses an array of ints and converts it into
      * binary strings.
      * @param time integer array of hours, minutes, seconds.                **/

    public ClockSolver(int[] time) {
        String[] stringTimes = new String[3];
        String string;
        int number;
        for (int i = 0; i < 3; i++) {
            number = time[i];
            string = "";
            while (number > 0) {
                if (number%2 == 1) {
                    string = "o" + string;
                } else {
                    string = "." + string;
                }
                number = number/2;
            }
            while (string.length() < 6) {
                string = "." + string;
            }
            stringTimes[i] = string;
        }
        hours = stringTimes[0]; minutes = stringTimes[1]; seconds = stringTimes[2];
    }

    /** Main method of class. Takes  a command line argument and turns it into a
      *  clock using the ClockSolver constructor.
      * @param args String array of command line arguments.                               **/

    public static void main (String[] args) {
        int[] time = new int[3];
        try {
            time[0] = Integer.parseInt( args[0].substring(0, 2) );
            time[1] = Integer.parseInt( args[0].substring(3, 5) );
            time[2] = Integer.parseInt( args[0].substring(6) );
        } catch (Exception e) {
            System.out.println("Incorrect format.");
            System.out.println("Input must be entered as this format HH:MM:SS.");
            return;
        }
        if (
            time[0] >= 24 || time[0] < 0 ||
            time[1] >= 60 || time[1] < 0 ||
            time[2] >= 60 || time[2] < 0
        ) {
            System.out.println("One or more of your integers is above their natrual limit(s).");
            return;
        }

        ClockSolver myClock = new ClockSolver(time);
        System.out.println("<><><><><>");
        System.out.println("| " + myClock.hours + " |");
        System.out.println("| " + myClock.minutes + " |");
        System.out.println("| " + myClock.seconds + " |");
        System.out.println("<><><><><>");
    }
}
