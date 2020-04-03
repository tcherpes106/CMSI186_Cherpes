import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SkateRamp{
  public static double currentVal=0;
  public static double previousVal=0;
  public static double DEFAULT_PERCENTAGE = .01;
  public static double lowerBound;
  public static double upperBound;
  private static int numOfRectangles =0;
  private static double rectangleWidth;
  private static double percentage;
  private static double currentPercentage = 0;
  private static int awayFromEnd =1;
  private static double[] arr;
  private static String equation;
  private static double xValue;
  private static boolean firstTimeGettingXvalue=true;
  public static boolean displayList = false;


  public static void main(String[] args) {
    String inputLine = "";
    System.out.println("\n Welcome to SkateRamp! \n");
    System.out.println("This program simulates a SkateRamp sum approximation");
    System.out.println("To see list of available functions run this program with List as the first argument");
    System.out.println("To run tests of available functions run this program with Test as the first argument\n");
    handleIntialArgs(args);
    if(!displayList)
    {
      calcSkateRamp(args);
    }
    }


    public static void calcSkateRamp(String[] args)
    {
      currentPercentage =0;
      numOfRectangles= 0;
      double pDiff =0;
      double vDiff =0;
      while(currentPercentage>percentage || numOfRectangles < 3)
      {
        firstTimeGettingXvalue =true;
        numOfRectangles++;
        vDiff = currentVal-previousVal;
        previousVal = currentVal;
        currentPercentage= vDiff/currentVal;
        currentVal = 0;
        rectangleWidth = findRectangleWidth();
        calculateArea(args);
        System.out.println("Approximation with "+numOfRectangles+" rectangles yields an area of "+currentVal);
      }
      System.out.println("The area of "+equation+" from "+lowerBound+ " to "+upperBound+" is "+currentVal);
      System.out.println("The equation was approximated using "+numOfRectangles+" rectangles");
    }


  public static void handleIntialArgs( String[] args) {
    percentage = DEFAULT_PERCENTAGE;
    if(args.length == 0){
      throw new IllegalArgumentException("Please enter arguments");
    }
    try{
        if(args[0].equals("list"))
        {
          showList();
          displayList = true;
        }
        else if(args[0].equals("test"))
        {
          runTests();
          displayList =true;
        }
        else{

    if(args.length <3)
    {
      throw new IllegalArgumentException("Please enter atleast three arguments");
    }
    setBounds(args);
    arr = new double [args.length-awayFromEnd];
    for(int i =1; i< args.length+1-awayFromEnd;i++)
    {
      try{
          arr[i-1] = Double.parseDouble(args[i]);
      }
      catch(NumberFormatException nfe)
      {
        throw new IllegalArgumentException("Make middle terms valid numbers");
      }
    }
    }
   }
   catch(NumberFormatException nfe){
    System.out.println("Please enter the first argument as a string");
    System.exit(5);
   }
  }


  public static void calculatePolynomial(){
      for (int i=0;i<numOfRectangles;i++ )
      {
         xValue = getMidpoint(rectangleWidth);
         for (int j=0;j<arr.length ;j++ )
         {
            if(j!=0)
            {
               currentVal += rectangleWidth*arr[j]*Math.pow(xValue,j);
            }
            else
            {
                currentVal += rectangleWidth* arr[j];
            }
         }
      }
    }


  public static void calculateSin(){
    for (int i=0;i<numOfRectangles;i++ )
    {
      xValue = getMidpoint(rectangleWidth);
      currentVal += rectangleWidth * Math.sin(xValue);
    }
  }


  public static void calculateCos(){
    for (int i=0;i<numOfRectangles;i++ )
    {
      xValue = getMidpoint(rectangleWidth);
      currentVal += rectangleWidth * Math.cos(xValue);
    }

    }


  public static void calculateTan(){
    for (int i=0;i<numOfRectangles;i++ )
    {
      xValue = getMidpoint(rectangleWidth);
      currentVal += rectangleWidth * Math.tan(xValue);
    }

    }


    public static void calculateASin(){
      for (int i=0;i<numOfRectangles;i++ )
      {
        xValue = getMidpoint(rectangleWidth);
        currentVal += rectangleWidth * Math.asin(xValue);
      }
    }


    public static void calculateACos(){
      for (int i=0;i<numOfRectangles;i++ )
      {
        xValue = getMidpoint(rectangleWidth);
        currentVal += rectangleWidth * Math.acos(xValue);
      }
      }


    public static void calculateATan(){
      for (int i=0;i<numOfRectangles;i++ )
      {
        xValue = getMidpoint(rectangleWidth);
        currentVal += rectangleWidth * Math.atan(xValue);
      }

      }


  public static void calculateLog10(){
    for (int i=0;i<numOfRectangles;i++ )
    {
      xValue = getMidpoint(rectangleWidth);
      currentVal += rectangleWidth * Math.log10(xValue);
    }

    }


    public static void calculateLn(){
      for (int i=0;i<numOfRectangles;i++ )
      {
        xValue = getMidpoint(rectangleWidth);
        currentVal += rectangleWidth * Math.log(xValue);
      }
      }

  public static void calculateExp(){
    for (int i=0;i<numOfRectangles;i++ )
    {
      xValue = getMidpoint(rectangleWidth);
      currentVal += rectangleWidth * Math.exp(xValue);
    }
    }


  public static void calculateSqrt(){
    for (int i=0;i<numOfRectangles;i++ )
    {
      xValue = getMidpoint(rectangleWidth);
      currentVal += rectangleWidth * Math.sqrt(xValue);
    }

    }


  public static void setBounds(String[] args)
  {
    awayFromEnd =1;
    String lastArg = args[args.length-awayFromEnd];
    if(lastArg.charAt(lastArg.length()-1)=='%')
    {
      lastArg = lastArg.substring(0,lastArg.length()-1);
      try
      {
        percentage = Double.parseDouble(lastArg);
      }
      catch(NumberFormatException nfe)
      {
        throw new IllegalArgumentException("Make the percentage a valid number");
      }
      System.out.println("Percentage = "+percentage);
      awayFromEnd ++;
    }
    try
    {
      upperBound =  Double.parseDouble(args[args.length-awayFromEnd]);
    }
    catch(NumberFormatException nfe)
    {
      System.out.println("upperbound= "+args[args.length-awayFromEnd]);
      throw new IllegalArgumentException("Make the upper bound a valid number");
    }
    awayFromEnd ++;
    try
    {
      lowerBound =  Double.parseDouble(args[args.length-awayFromEnd]);
    }
    catch(NumberFormatException nfe)
    {
      throw new IllegalArgumentException("Make the lower bound a valid number");
    }
    awayFromEnd ++;
    if(lowerBound>=upperBound)
    {
      throw new IllegalArgumentException("Please make the upper bound greater than the lower bound");
    }
  }


  private static void calculateArea(String[] args){
    try{
        if(args[0].equals("poly"))
        {
          for (int i=0;i<arr.length ;i++ ) {
            if(i==0)
            {
              equation = "y = "+ arr[0];
            }
            else if(i==1){
              equation += " + "+ arr[i] +"x";
            }
            else{
              equation += " + "+ arr[i] +"x^"+i;
            }

          }
          calculatePolynomial();
        }
        else if(args[0].equals("sin"))
        {
          equation = "y = sin x";
          calculateSin();
        }
        else if(args[0].equals("cos"))
        {
          equation = "y = cos x";
          calculateCos();
        }
        else if(args[0].equals("tan"))
        {
          equation = "y = tan x";
          calculateTan();
        }
        else if(args[0].equals("log10"))
        {
          equation = "y = log10 x";
          calculateLog10();
        }
        else if(args[0].equals("ln"))
        {
          equation = "y = ln x";
          calculateLn();
        }
        else if(args[0].equals("sqrt"))
        {
          equation = "y = x^(1/2)";
          calculateSqrt();
        }
        else if(args[0].equals("exp"))
        {
          equation = "y = e^x";
          calculateExp();
        }
        else if(args[0].equals("asin"))
        {
          equation = "y = arcsin x";
          calculateASin();
        }
        else if(args[0].equals("acos"))
        {
          equation = "y = arccos x";
          calculateACos();
        }
        else if(args[0].equals("atan"))
        {
          equation = "y = arctan x";
          calculateATan();
        }
        else{
          throw new IllegalArgumentException("Sorry, but "+args[0]+" is not a valid function for this program");
        }
      }
      catch(NumberFormatException nfe){
        System.out.println("Please enter the first argument as a string");
        System.exit(5);
      }
  }


  private static double findRectangleWidth(){
    double range = upperBound -lowerBound;
    return (range/numOfRectangles);
  }


  private static double getMidpoint(double rw){
    double answ = xValue;
    if(firstTimeGettingXvalue)
    {
      answ = lowerBound + rw/2;
      firstTimeGettingXvalue =false;
    }
    else{
      answ+= rw;
    }
    return answ;
  }


  public static void showList()
  {
    System.out.println("Available Functions--- \n");
    System.out.println("Poly  : integrates a polynomial function where args[1] … args[k]");
    System.out.println("        specify the coefficients of the x0 … xk terms of the polynomial");
    System.out.println("Sin   : integrates the sine function");
    System.out.println("Cos   : integrates the cosine function");
    System.out.println("Tan   : integrates the tangent function");
    System.out.println("Asin  : integrates the arc sine function");
    System.out.println("Acos  : integrates the arc cosine function");
    System.out.println("Atan  : integrates the arc tangent function");
    System.out.println("Ln    : integrates the (natural) logarithm function");
    System.out.println("Log10 : integrates the base 10 logarithm function");
    System.out.println("Exp   : integrates the function of Euler's number e raised to the power of x");
    System.out.println("Sqrt  : integrates the function of a rounded positive square root for x");
  }


  public static void runTests()
  {
    String [] testArgs;
    System.out.println("Running all tests--- \n");
    System.out.println("Poly Tests  : ");
        System.out.println( "\n    Taking integral of y=1 from x=0 to x=1: " );
        testArgs =new String[]{"poly","1","0","1"};
        try{ System.out.println( "      expecting: 1\n " ); }
        catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); } handleIntialArgs(testArgs);calcSkateRamp(testArgs);
        System.out.println( "\n    Taking integral of y=1 from x=0 to x=5: " );
        testArgs =new String[]{"poly","1","0", "2"};
        try{ System.out.println( "      expecting: 5\n " ); }
        catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); } handleIntialArgs(testArgs);calcSkateRamp(testArgs);
        System.out.println( "\n    Taking integral of y=3 from x=1 to x=4: " );
        testArgs =new String[]{"poly","3","1","4"};
        try{ System.out.println( "      expecting: 9\n " ); }
        catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); } handleIntialArgs(testArgs);calcSkateRamp(testArgs);
        System.out.println( "\n    Taking integral of y=X from x=0 to x=1: " );
        testArgs =new String[]{"poly","0","1","0","1"};
        try{ System.out.println( "      expecting: .5\n " ); }
        catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); } handleIntialArgs(testArgs); calcSkateRamp(testArgs);
        System.out.println( "\n    Taking integral of y=2X from x=0 to x=3: " );
        testArgs =new String[]{"poly","0","2","0","3"};
        try{ System.out.println( "      expecting: 9\n " ); }
        catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); } handleIntialArgs(testArgs);calcSkateRamp(testArgs);
        System.out.println( "\n    Taking integral of y=3X+4 from x=2 to x=7: " );
        testArgs =new String[]{"poly","4","3","2","7"};
        try{ System.out.println( "      expecting: 87.5\n " ); }
        catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); } handleIntialArgs(testArgs);calcSkateRamp(testArgs);
        System.out.println( "\n    Taking integral of y=x^3 from x=0 to x=6: " );
        testArgs =new String[]{"poly","0","0","1","0","6"};
        try{ System.out.println( "      expecting: 324\n " ); }
        catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); } handleIntialArgs(testArgs);calcSkateRamp(testArgs);
        System.out.println( "\n    Taking integral of y=4x^3 -2x^2+7 from x=-2 to x=1: " );
        testArgs =new String[]{"poly","7","-2","4","-2","1"};
        try{ System.out.println( "      expecting: 9453.333\n " ); }
        catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); } handleIntialArgs(testArgs); calcSkateRamp(testArgs);
        System.out.println( "\n    Taking integral of y=x^4+x^3+x^2+x+1 from x=0 to x=10: " );
        testArgs =new String[]{"poly","1","1","1","1","1","0","10"};
        try{ System.out.println( "      expecting: 22893.333\n " ); }
        catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); } handleIntialArgs(testArgs);calcSkateRamp(testArgs);
        System.out.println( "\n    Taking integral of y=3x^2 from x=0 to x=50: " );
        testArgs =new String[]{"poly","0","0","3","0","50"};
        try{ System.out.println( "      expecting: 125000\n " ); }
        catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); } handleIntialArgs(testArgs);calcSkateRamp(testArgs);
        System.out.println( "\n    Taking integral of y=-7.3x^7+4x^6-x^5+2x^2-19x+20.2 from x=3.5 to x=18.7 " );
        testArgs =new String[]{"poly","20.2","-19","2","0","0","-1","4","7.3","3.5","18.7"};
        try{ System.out.println( "      expecting: -1.319e10\n " ); }
        catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); } handleIntialArgs(testArgs);calcSkateRamp(testArgs);


    System.out.println("\nSin Tests   : ");
        System.out.println( "\n    Taking integral of y=sin(X) from x=0 to x=1: " );
        testArgs =new String[]{"sin","0","1"};
        try{ System.out.println( "      expecting: .45969\n " ); }
        catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); } handleIntialArgs(testArgs);calcSkateRamp(testArgs);
        System.out.println( "\n    Taking integral of y=sin(X) from x=-1 to x=0: " );
        testArgs =new String[]{"sin","-1","0"};
        try{ System.out.println( "      expecting: -.45969\n " ); }
        catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); } handleIntialArgs(testArgs);calcSkateRamp(testArgs);
        System.out.println( "\n    Taking integral of y=sin(X) from x=-1 to x=1: " );
        testArgs =new String[]{"sin","-1","1"};
        try{ System.out.println( "      expecting: 0\n " ); }
        catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); } handleIntialArgs(testArgs);calcSkateRamp(testArgs);
        System.out.println( "\n    Taking integral of y=sin(X) from x=0 to x=3.14: " );
        testArgs =new String[]{"sin","0","3.14"};
        try{ System.out.println( "      expecting: 2\n " ); }
        catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); } handleIntialArgs(testArgs); calcSkateRamp(testArgs);
        System.out.println( "\n    Taking integral of y=sin(X) from x=-3.14 to x=0: " );
        testArgs =new String[]{"sin","-3.14","0"};
        try{ System.out.println( "      expecting: -2\n " ); }
        catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); } handleIntialArgs(testArgs);calcSkateRamp(testArgs);
        System.out.println( "\n    Taking integral of y=sin(X) from x=0 to x=6.28: " );
        testArgs =new String[]{"sin","0","6.28"};
        try{ System.out.println( "      expecting: 0\n " ); }
        catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); } handleIntialArgs(testArgs);calcSkateRamp(testArgs);
        System.out.println( "\n    Taking integral of y=sin(X) from x=3.14 to x=6.28: " );
        testArgs =new String[]{"sin","3.14","6.28"};
        try{ System.out.println( "      expecting: -2\n " ); }
        catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); } handleIntialArgs(testArgs);calcSkateRamp(testArgs);
        System.out.println( "\n    Taking integral of y=sin(X) from x=3.14 to x=6.28: " );
        testArgs =new String[]{"sin","-6.28","3.14"};
        try{ System.out.println( "      expecting: 2\n " ); }
        catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); } handleIntialArgs(testArgs); calcSkateRamp(testArgs);
        testArgs =new String[]{"sin","-6.28","6.28"};
        try{ System.out.println( "      expecting: 0\n " ); }
        catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); } handleIntialArgs(testArgs);calcSkateRamp(testArgs);
        System.out.println( "\n    Taking integral of y=sin(X) from x=-1 to x=0: " );
        testArgs =new String[]{"sin","-1","2"};
        try{ System.out.println( "      expecting: .956\n " ); }
        catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); } handleIntialArgs(testArgs);calcSkateRamp(testArgs);
        System.out.println( "\n    Taking integral of y=sin(X) from x=-1 to x=2: " );
        testArgs =new String[]{"sin","0",".5"};
        try{ System.out.println( "      expecting: .122\n " ); }
        catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); } handleIntialArgs(testArgs);calcSkateRamp(testArgs);
        System.out.println( "\n    Taking integral of y=sin(X) from x=0 to x=.5: " );
        testArgs =new String[]{"sin","0",".1"};
        try{ System.out.println( "      expecting: .004\n " ); }
        catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); } handleIntialArgs(testArgs); calcSkateRamp(testArgs);
        System.out.println( "\n    Taking integral of y=sin(X) from x=0 to x=.1: " );
        testArgs =new String[]{"sin","0",".01"};
        try{ System.out.println( "      expecting: 0.00004\n " ); }
        catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); } handleIntialArgs(testArgs); calcSkateRamp(testArgs);
  }

}
