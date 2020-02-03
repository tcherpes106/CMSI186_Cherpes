/** ---------------------------------------------------
* File name: PiSolver.java
* Purpose: Evaluate the value of Pi by "throwing" darts at a circle inside a square.
* Author: Timothy Cherpes
* Date:1/29/19
* Description:
* Notes:
--------------------------------------------------------*/

public class PiSolver {
  public static void main (String[] args){
    int num = 0;
    int total = 0;
    double pi_estimate = 0;


        //Makes sure args is a integer
        try {
            num = Integer.parseInt(args[0]);
        }

        catch (NumberFormatException nfe) {
            System.out.println("The argument must be an integer.");
            System.exit(1);
        }

        //Randomly plots a point and increases total if the point is inside the circle
        for (int i = 0; i < num; i++){

          double x = (Math.random()*((0-(-1))+1))+(-1);
          double y = (Math.random()*((0-(-1))+1))+(-1);

          double sum = ((x*x)+(y*y));
          sum = Math.sqrt(sum);

          if (sum<=1){
            total++;
          }
        }

        //Use the number of points inside the cirlce vs the total points to evaluate Pi
        pi_estimate = ((double)total/(double)num);
        pi_estimate = (pi_estimate*4.0);

        System.out.println(pi_estimate);
  }
}
