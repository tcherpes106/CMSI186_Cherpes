public class SkateRamp {
  private double percentage = 1.0;
  private boolean givenPercentage = false;

  public void printUsage() {
    System.out.println("\n  USAGE REPORT:\n" +
                          "   java SkateRamp <function> <coeff1> < coeff2> ... <lower> <upper> [percent]\n" +
                          "     where:\n" +
                          "       <function> is a mathematical function like 'poly' or 'sin'\n" +
                          "       <coef[n]> is a doefficient for the function's X terms\n" +
                          "       <lower> and <upper> are the lower and upper bounds of the function\n" +
                          "       [percent] is an optional percentage value for comparison" );
    System.exit(0);
  }



  public double calculateY( double[] coeffs, double midPoint ) {
      double yValue = 0.0;
      for( int i = 0; i < coeffs.length; i++ ) {
         yValue += coeffs[i] * Math.pow( midPoint, i );
      }
      return yValue;
   }

   private static void runMyTests {
     
   }

   public double integratePolynomial( double lb, double ub, double[] coefficients, int n ) {
     double midpt  = 0.0;
     double sum    = 0.0;
     double width  = ((ub - lb) / n);
     double yValue = 0.0;
     for( int j = 0; j < n; j++ ) {
        yValue = 0.0;
        midpt = lb + (width / 2.0) + (j * width);
        yValue = calculateY( coefficients, midpt );
        sum += yValue * width;
     }
     return sum;
  }


  public double integrateSin( double lb, double ub, double[] coefficients, int n ) {
    double midpt  = 0.0;
    double sum    = 0.0;
    double width  = ((ub - lb) / n);
    double yValue = 0.0;
    for( int j = 0; j < n; j++ ) {
       yValue = 0.0;
       midpt = lb + (width / 2.0) + (j * width);
       yValue = calculateY( coefficients, midpt );
       sum += yValue * width;
    }
    return sum;
 }



  public static void main (String [] args) {

    SkateRamp sr = new SkateRamp();

    if (args.length == 0) {
      sr.printUsage();
    }

    else {
      if (args[args.length -1].contains("%")) {
        System.out.println("Percent value detected");
        sr.percentage = Double.parseDouble(args[args.length -1].substring(0, args[args.length -1].length() -1 ));
        sr.givenPercentage = true;
        System.out.println("Percent Value has been assigned as: " + sr.percentage);
      }

      else {
        System.out.println("Percent value not detected");
        sr.percentage = 1.0;
        sr.givenPercentage = false;
        System.out.println("Percent Value has been assigned as: " + sr.percentage);
      }

      if (args[0].contains("poly")) {
        if (sr.givenPercentage = true){
          double upperBound = Double.parseDouble(args[args.length - 2]);
          double lowerBound = Double.parseDouble(args[args.length - 3]);
          double coefficients[] = Double.parseDouble(args.substring(1, args[args.length-4]));
        }

        else {
          double upperBound = Double.parseDouble(args[args.length - 1]);
          double lowerBound = Double.parseDouble(args[args.length - 2]);
          double coefficients[] = Double.parseDouble(args.substring(1, args[args.length-3]));

        }
        integratePolynomial(lowerBound, upperBound, coefficients, n );
      }

      else if (args[0].contains("sin")) {
        if (sr.givenPercentage = true){
          double upperBound = Double.parseDouble(args[args.length - 2]);
          double lowerBound = Double.parseDouble(args[args.length - 3]);
          double coefficients[] = Double.parseDouble(args.substring(1, args[args.length-4]));
        }

        else {
          double upperBound = Double.parseDouble(args[args.length - 1]);
          double lowerBound = Double.parseDouble(args[args.length - 2]);
          double coefficients[] = Double.parseDouble(args.substring(1, args[args.length-3]));

        }
        integrateSin(lowerBound, upperBound, coefficients, n );
      }

      else {
        sr.printUsage();
      }
    }
  }
}
