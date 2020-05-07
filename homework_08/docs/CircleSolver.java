import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  CircleSolver.java
 *  Purpose       :  Calculates the positions of 2 circles in relationship to each other
 *  Author        :  Timothy Cherpes
 *  Date          :  2020-05-04
 *  Description   :  this class provides what is needed to see where in relationship 2 given cirlces are
 *                   in relationship to each other, ie: not touching, touching, etc.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class CircleSolver {

    // Instance fields
    public String[] circles;
    public int[]    firstCircle;
    public int[]    secondCircle;
    public int      bigCircle = 0;
    double centerCalculation = 0.0;
    int    radiusCalculation = 0;
    int    radiusSum = 0;

    /** Constructor for  class. Reads a given file and sets up variables for calculaiton.
      * @param nameOfFile String value of the name of the given file.
      * @throws IOException
      * @throws exception when radius is negative.                                        **/

    public CircleSolver(String nameOfFile) throws IOException{
        this.circles = new String[2];
        int index = 0;

        // Reads the given file
        File newfile = new File(nameOfFile);
        BufferedReader br = new BufferedReader( new FileReader(newfile) );

        String currentLine = br.readLine();
        while(index < 2) {
            circles[index] = currentLine;
            index++;
            currentLine = br.readLine();

        } br.close();

        firstCircle = new int[3];
        for (int i = 0; i < 3; i++) {
            firstCircle[i] = Integer.parseInt(  ( circles[0].split(" ") )[i]  );
        }

        secondCircle = new int[3];
        for (int j = 0; j < 3; j++) {
            secondCircle[j] = Integer.parseInt(  ( circles[1].split(" ") )[j]  );
        }

        if (this.secondCircle[2] > this.firstCircle[2])      {this.bigCircle = 2;}
        else if (this.firstCircle[2] > this.secondCircle[2]) {this.bigCircle = 1;}

        if (this.firstCircle[2] < 0 || this.secondCircle[2] < 0) {throw new IllegalArgumentException("Negative radius");}

    }

    /** This method does all other calculations for the relationship of the circles
      * @return String value of the relationship between the circles. **/


    public String checkCircle() {

        centerCalculation = Math.sqrt( Math.pow(firstCircle[0]-secondCircle[0],2) + Math.pow(firstCircle[1]-secondCircle[1],2) );
        radiusCalculation = Math.abs( firstCircle[2] - secondCircle[2]);
        radiusSum  = Math.abs( firstCircle[2] + secondCircle[2]);

        if (centerCalculation == 0 && this.bigCircle == 0) {
            return "same";
        } else if (centerCalculation == radiusSum) {
            return "sep/touch";
        } else if (centerCalculation == radiusCalculation) {
            return "2in1touch";
        } else if (centerCalculation < radiusSum) {
            if (centerCalculation < radiusCalculation) {
                return "inside";
            } return "2";
        } return "NA";

    }

    public static void main (String[] args) {
        CircleSolver myCircle = null;

        try {
            myCircle = new CircleSolver(args[0]);
        } catch (IOException ioe) {
            System.out.println("Inncorrect file name.");
            return;
        } catch (NumberFormatException nfe) {
            System.out.println("Inncorret input.");
            return;
        } catch (NullPointerException npe) {
            System.out.println("2 circles are needed for this program.");
            return;
        } catch (IllegalArgumentException iae) {
            System.out.println("Inncorrect input. ");
            return;
        }

        // First report
        System.out.println(
            "Circle 1 is located at (" + Integer.toString(myCircle.firstCircle[0]) + ", " + myCircle.firstCircle[1] +
            ") and has a radius of " + Integer.toString(myCircle.firstCircle[2]) +"."
        ); System.out.println(
            "Circle 2 is located at (" + Integer.toString(myCircle.secondCircle[0]) + ", " + myCircle.secondCircle[1] +
            ") and has a radius of " + Integer.toString(myCircle.secondCircle[2]) +"."
        );

        // Computing real relationship between the circles
        String relationship = myCircle.checkCircle();
        if (relationship.equals("same")) {
            System.out.println("Given circles are identical.");
        } else if (relationship.equals("2")) {
            System.out.println("Given circles intersect each other in 2 places.");
        } else if (relationship.equals("NA")) {
            System.out.println("Given circles are completely separate.");
        } else if (relationship.equals("sep/touch")) {
            System.out.println("Given circles are separate, but their boundaries touch.");
        } else {
            if (myCircle.bigCircle == 1) {
                if (relationship.equals("inside")) {
                    System.out.println("Circle 2 is inside of circle 1");
                } else if (relationship.equals("2in1touch")) {
                    System.out.println("Circle 2 is inside circle 1, but their boundaries touch.");
                }
            } else if (myCircle.bigCircle == 2) {
                if (relationship.equals("inside")) {
                    System.out.println("Circle 1 is inside of circle 2.");
                } else if (relationship.equals("2in1touch")) {
                    System.out.println("Circle 1 is inside circle 2, but their boundaries touch.");
                }
            }
        }
    }
}
