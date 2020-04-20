/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * filename: BirthdaySolver<br />
 * purpose : Estimates the probability that, among n randomly-chosen people,
 *             there is at least one duplicated birthdate
 * <p>
 * @author : Timothy Cherpes
 * @author : re-hosted by B.J. Johnson
 * @since  : 2020-04-20
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.text.DecimalFormat;
import java.util.Random;

/**
 * Finds the probability that in a set of people there will be two who share the same birthday.
 * <p>
 * This implementation does NOT consider leap years, only standard years
 */
public class BirthdaySolver {
    private static final int DAYS_PER_YEAR = 365;
    private static final int DEFAULT_NUMBER_OF_EXPERIMENTS = 100000;
    private static final int NOTIFICATION_CUTOFF = 2999999;
    private static final boolean DEBUG_ON = false;

    /**
     * Informs the user of the correct way to run the program when they have made an entry error.
     * It also exits the program, assuming that the user error will cause an un-runnable condition.
    */
    public void printUsage() {
        System.out.println ("\n\nHello and welcome to Birthday Solver! This is a program that calculates the probability that a pair of people will share the same birthday out of any desired size group." +
                            "\nUSAGE MESSAGE:\n" +
                            "   Please make sure to format your input like the following.\n" +
                            "   java BirthdaySolver <numberOfPeople> [numberOfExperiments]\n" +
                            "     where: \n" +
                            "       <numberOfPeople> is an integer value that represents the size of the group of people you wish to calculate (Must be greater than 2)\n" +
                            "       [numberOfExperiments] is an integer value that represents the amount of trials you would like to run (This is optional. The program will default to 100,000 trials.))\n" +
                            "       \n"
                            );
        System.exit(0);
    }

    /**
     * Calculates the actual probability that from a certain number of people, at least two of them
     * share the same birthday.  Based on calculating the probability that they DO NOT share a
     * birthday, then subtracting that probability from 1.0 to get the other side of the coin.
     *
     * @param  numberOfPeople  integer number of people in the sample
     * @return double the probability value, range between zero and one
     * @see <a href="http://bjohnson.lmu.build/cmsi186web/homework07.html">Assignment Page</a>
     * @see <a href="https://betterexplained.com/articles/understanding-the-birthday-paradox/">Better Explained Page</a>
     * @see <a href="https://en.wikipedia.org/wiki/Birthday_problem">Wikipedia Page</a>
    */
    public double calculateActualProbability( int numberOfPeople ) {
        double dayOfTheYear = 364;
        double[] doubleArray = new double[numberOfPeople - 1];
        double prob = 0.0;
        double multiplyValue = 1.0;
        if (numberOfPeople > 365) {
            prob = 1.0 * 100;
        }
        else {
            for (int i = 0; i < numberOfPeople - 1; i++) {
                doubleArray[i] = dayOfTheYear / 365;
                dayOfTheYear--;
            }

            for (int i = 0; i < doubleArray.length; i++) {
                multiplyValue = multiplyValue * doubleArray[i];
            }
            prob = (1.0 - multiplyValue) * 100;
        }
        return prob ;
   }

  /**
   * This is the main method of the program.  It first verifies the arguments from
   *  the command line, then does a loop to calculate an approximate probability.
   *  After that, it calls the <code>calculateActualProbability</code> method and
   *  then displays both results for comparison.
   *
   * @param args two are used: [0] = number of people; [1] = number of experiments.
   */
   public static void main ( String [] args ) {
        DecimalFormat df = new DecimalFormat( "#.00" );
        BirthdaySolver b = new BirthdaySolver();
        int n = 0;
        double experiments = 0;

        if (args.length > 1) {
            try {
                n = Integer.parseInt(args[0]);
                experiments = Integer.parseInt(args[1]);
                int[] argsChecker = new int[2];
                argsChecker[0] = Integer.parseInt(args[0]);
                argsChecker[1] = Integer.parseInt(args[1]);
                if (Integer.parseInt(args[0]) < 2 || Integer.parseInt(args[1]) < 2) {
                    argsChecker[0] = 5 / 0;
                }
            }
            catch (ArithmeticException e) {
                b.printUsage();
            }
            catch (IllegalArgumentException e){
                b.printUsage();
            }
        }
        else if (args.length == 1) {
            try {
                n = Integer.parseInt(args[0]);
                experiments = DEFAULT_NUMBER_OF_EXPERIMENTS;
                int[] argsChecker = new int[1];
                argsChecker[0] = Integer.parseInt(args[0]);
                if (Integer.parseInt(args[0]) < 2) {
                    argsChecker[0] = 5 / 0;
                }
            }
            catch (ArithmeticException e) {
                b.printUsage();
            }
            catch (IllegalArgumentException e) {
                b.printUsage();
            }
        }

        if (experiments > NOTIFICATION_CUTOFF) {
            System.out.println("The number of experiment trials you have entered is quite large, please find a comfortable seat... as this may take some time!");
        }

        double counter = 0;

        for(int i = 0; i < experiments; i++) {
            int[] checklist = new int[DAYS_PER_YEAR];
            try {
                for (int j = 0; j < n; j++) {
                    Random r = new Random();
                    int randomIndex = r.nextInt(DAYS_PER_YEAR);
                    if (checklist[randomIndex] == 1) {
                        checklist[randomIndex] = 5 / 0;
                    }
                    else if (checklist[randomIndex] == 0) {
                        checklist[randomIndex] = 1;
                    }
                }
            }
            catch (Exception e) {
                if ( DEBUG_ON ) {System.out.println( e.toString() ); }
                    counter++;
            }
       }

       double actualProbability = b.calculateActualProbability(n);
       double experimentalProbability = (counter / experiments) * 100;

       System.out.println( "   Probability that two out of " + n + " people have the same birthday: " );
       System.out.println( "      Experimental value is: " +  df.format(experimentalProbability) + "%" );
       System.out.println( "            Actual value is: " + df.format(actualProbability) + "%\n\n");
   }
}
