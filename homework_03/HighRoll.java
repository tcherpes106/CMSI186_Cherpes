import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HighRoll{

   public static void main( String args[] ) {
      System.out.println( "\n   Welcome to the High Roll Game!!! \n" );

     // This line uses the two classes to assemble an "input stream" for the user to type
     // text into the program
      BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );
      System.out.println("Please enter the number of die and the number of sides each die has:");
      String inputLine = null;

      



      while( true ) {
        System.out.println("********************************************************** \n");
        System.out.println("1. ROLL ALL THE DICE");
        System.out.println("2. ROLL A SINGLE DIE");
        System.out.println("3. CALCULATE THE SCORE FOR THIS SET");
        System.out.println("4. SAVE THIS SCORE AS HIGH SCORE");
        System.out.println("5. DISPLAY THE HIGH SCORE");
        System.out.println("6. ENTER 'Q TO QUIT THE PROGRAM' \n");
        System.out.print( "Please type the number of the option you want to execute: >> " );


         try {
            inputLine = input.readLine();
            if( 0 == inputLine.length() ) {
               System.out.println("   Please enter some text!");
               continue;
            }
            System.out.println( "   You typed: " + inputLine + "\n");
            if( 'q' == inputLine.charAt(0) || '6' == inputLine.charAt(0) ) {
               break;
            }
            else if( '1' == inputLine.charAt(0) ) {

            }
            else if( '2' == inputLine.charAt(0) ) {
              System.out.println("Which die would you like to roll?: >> ");

            }
            else if( '3' == inputLine.charAt(0) ) {

            }
            else if( '4' == inputLine.charAt(0) ) {

            }
            else if( '5' == inputLine.charAt(0) ) {

            }
            else {
              System.out.println("Please enter a valid option.");
            }
          }
         catch( IOException ioe ) {
            System.out.println( "Caught IOException" );
         }
      }
   }
}
