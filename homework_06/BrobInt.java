import java.util.Arrays;

public class BrobInt {
    public static final BrobInt ZERO     = new BrobInt(  "0" );      /// Constant for "zero"
    public static final BrobInt ONE      = new BrobInt(  "1" );      /// Constant for "one"
    public static final BrobInt TWO      = new BrobInt(  "2" );      /// Constant for "two"
    public static final BrobInt THREE    = new BrobInt(  "3" );      /// Constant for "three"
    public static final BrobInt FOUR     = new BrobInt(  "4" );      /// Constant for "four"
    public static final BrobInt FIVE     = new BrobInt(  "5" );      /// Constant for "five"
    public static final BrobInt SIX      = new BrobInt(  "6" );      /// Constant for "six"
    public static final BrobInt SEVEN    = new BrobInt(  "7" );      /// Constant for "seven"
    public static final BrobInt EIGHT    = new BrobInt(  "8" );      /// Constant for "eight"
    public static final BrobInt NINE     = new BrobInt(  "9" );      /// Constant for "nine"
    public static final BrobInt TEN      = new BrobInt( "10" );      /// Constant for "ten"

//    public static final BrobInt MAX_INT  = new BrobInt( new Integer( Integer.MAX_VALUE ).toString() );
//    public static final BrobInt MIN_INT  = new BrobInt( new Integer( Integer.MIN_VALUE ).toString() );
//    public static final BrobInt MAX_LONG = new BrobInt( new Long( Long.MAX_VALUE ).toString() );
//    public static final BrobInt MIN_LONG = new BrobInt( new Long( Long.MIN_VALUE ).toString() );
    public static final BrobInt MAX_INT  = new BrobInt( Integer.valueOf( Integer.MAX_VALUE ).toString() );
    public static final BrobInt MIN_INT  = new BrobInt( Integer.valueOf( Integer.MIN_VALUE ).toString() );
    public static final BrobInt MAX_LONG = new BrobInt( Long.valueOf( Long.MAX_VALUE ).toString() );
    public static final BrobInt MIN_LONG = new BrobInt( Long.valueOf( Long.MIN_VALUE ).toString() );

    private String internalValue = "";        // internal String representation of this BrobInt
    private byte   sign          = 0;         // "0" is positive, "1" is negative
    private String reversed      = "";        // the backwards version of the internal String representation
    private byte[] byteVersion   = null;      // byte array for storing the string values; uses the reversed string

   public BrobInt(String value) {
        internalValue = value;
        if (value.charAt(0) == '-') {
            sign = 1;
            value = value.replace("-", "");
        } else {
            sign = 0;
            value = value.replace("+", "");
        }
        int count = 0;
        int length = value.length();
        byteVersion = new byte[length];
        for (int i= value.length()-1; i >= 0; i--) {
            byteVersion[count] = (byte)(value.charAt(i) - 48);
            reversed += value.charAt(i);
            count++;
        }
        validateDigits();
   }

   public boolean validateDigits() throws IllegalArgumentException{
       for (byte b : byteVersion) {
           if(b > 9 || b < 0){
               System.out.println(b);
               throw new IllegalArgumentException( "\n        The entered value is not a valid decimal digit." );
           }
       }
       return true;
   }

   public BrobInt reverser() {
       if (this.sign == 1) {
           return new BrobInt("-" + this.reversed);
       } else {
           return new BrobInt(this.reversed);
       }
    }

   public static BrobInt reverser( BrobInt gint ) {
       if (gint.sign == 1) {
           return new BrobInt("-" + gint.reversed);
       } else {
           return new BrobInt(gint.reversed);
       }
   }


   public BrobInt add( BrobInt gint ) {
       String result = "";
       BrobInt larger = (Math.max(this.byteVersion.length, gint.byteVersion.length) == this.byteVersion.length) ? this.copy() : gint.copy();
       BrobInt smaller = (Math.max(this.byteVersion.length, gint.byteVersion.length) == this.byteVersion.length) ? gint.copy() : this.copy();
       byte[] sum = new byte[larger.byteVersion.length + 1];
       byte carry = 0;
       if (gint.sign == this.sign) {
           for (int i=0; i < larger.byteVersion.length; i++){
               if( i < smaller.byteVersion.length) {
                   sum[i] = (byte)((larger.byteVersion[i] + smaller.byteVersion[i] + carry) % 10);
                   carry = (larger.byteVersion[i] + smaller.byteVersion[i] + carry > 9) ? (byte)1 : (byte)0;
               } else {
                   sum[i] = (byte)((larger.byteVersion[i] + carry) % 10);
                   carry = (larger.byteVersion[i] + carry > 9) ? (byte)1 : (byte)0;

               }
           }
           if (carry > 0) {
               sum[sum.length - 1] = carry;
           }

           for (int i=sum.length-1; i >= 0; i--) {
               result += sum[i];
           }
           result = result.replaceFirst("^0+(?!$)", "");
           if (gint.sign == 1) {
               result = "-" + result;
           }

       } else {
           return this.subtract(gint);
       }

       return new BrobInt(result);
   }

   public int isLarger(BrobInt gint) {
       if (this.byteVersion.length > gint.byteVersion.length) {
           return 1;
       }
       if (gint.byteVersion.length > this.byteVersion.length) {
           return -1;
       }
       for(int i = this.byteVersion.length-1; i >= 0; i--) {
           if(this.byteVersion[i] > gint.byteVersion[i]) {
               return 1;
           }
           if(gint.byteVersion[i] > this.byteVersion[i]) {
               return -1;
           }
       }
       return 0;

   }

   public BrobInt subtract( BrobInt gint ) {
       String result = "";
       BrobInt s1 = this.copy();
       BrobInt s2 = gint.copy();
       int large = this.isLarger(gint);
       BrobInt larger;
       BrobInt smaller;

       if(large >= 0) {
           larger = this.copy();
           smaller = gint.copy();
       } else {
           larger = gint.copy();
           smaller = this.copy();

           if (larger.sign == 0) {
               larger.sign = 1;
           } else {
               larger.sign = 0;
           }
       }
       byte[] difference = new byte[larger.byteVersion.length + 1];
       int check = 0;

       if ((s2.sign == 1) && (s1.sign == 0)){
           s2.sign = 0;
           return s1.add(s2);
       }

       if ((s2.sign == 0) && (s1.sign == 1)) {
           s2.sign = 1;
           return s1.add(s2);
       }

           for(int i=0; i < larger.byteVersion.length; i++){
               if( i < smaller.byteVersion.length) {
                   check = larger.byteVersion[i] - smaller.byteVersion[i];
                   if (check < 0 ){
                       larger.byteVersion[i+1] -=  1;
                       difference[i] = (byte)((check + 10 ));
                   } else {
                       difference[i] = (byte)(check);
                   }
               } else {
                   if (larger.byteVersion[i] == -1 && i+1 != larger.byteVersion.length) {
                       larger.byteVersion[i+1] -= 1;
                       difference[i] = (byte)(9);
                   } else {
                       difference[i] = larger.byteVersion[i];
                   }
               }

           }
           for (int j=difference.length-1; j >= 0; j --) {
               result += difference[j];
           }
           result = result.replaceFirst("^0+(?!$)", "");
           if (larger.sign == 1) {
               result = "-" + result;
           }
           return new BrobInt(result);
       }

   public BrobInt multiply( BrobInt gint ) {
       String result = "";
       byte[] smaller;
       byte[] larger;
       byte carry = 0;
       if(this.byteVersion.length > gint.byteVersion.length){
           larger = new byte[this.byteVersion.length];
           smaller = new byte[gint.byteVersion.length];
           for (int i=0; i < this.byteVersion.length; i++) {
               larger[i] = this.byteVersion[i];
           }
           for (int i=0; i < gint.byteVersion.length; i++) {
               smaller[i] = gint.byteVersion[i];
           }
       } else {
           larger = new byte[gint.byteVersion.length];
           smaller = new byte[this.byteVersion.length];
           for (int i=0; i < gint.byteVersion.length; i++) {
               larger[i] = gint.byteVersion[i];
           }
           for (int i=0; i < this.byteVersion.length; i++) {
               smaller[i] = this.byteVersion[i];
           }
       }

       byte[] product = new byte[smaller.length + larger.length + 1];
       for (int i=0; i < product.length; i ++) {
           product[i] = 0;
       }
       for (int i=0; i < smaller.length; i++){
           int k = i;
           for (int j = 0; j < larger.length; j++){
               product[k] = (byte)((larger[j] * smaller[i]) + product[k]);
               if(product[k] > 9){
                   carry = (byte)(product[k] / 10);
                   product[k] = (byte)(product[k] % 10);
               } else {
                   carry = 0;
               }
               product[k+1] += carry;
               k++;
           }
       }
       for (int i=product.length-1; i >= 0; i--) {
           result += product[i];
       }
       result = result.replaceFirst("^0+(?!$)", "");
       if (gint.sign != this.sign) {
           result = "-" + result;
       }
       return new BrobInt(result);
   }

   public BrobInt divide( BrobInt gint ) {
/*
        if (gint.isLarger(this) == 0) {
            return ONE;
        }
        if (gint.isLarger(this) == 1) {
            return ZER0;
        }
             byte[] divisor = new byte[gint.byteVersion.length];
             byte[] dividend = new byte[this.byteVersion.length];
             byte[] d3 = new byte[divisor.length];
             byte[] quotient = new byte[];
             for (int i =0; i < dividend.length; i++){
                 d3[0] = dividend[i];
                 d3[1] = dividend[i+1];
             }
*/

    throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );

   }

   public BrobInt remainder( BrobInt gint ) {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

   public int compareTo( BrobInt gint ) {
      return (internalValue.compareTo( gint.toString() ));
   }


   public boolean equals( BrobInt gint ) {
      return (internalValue.equals( gint.toString() ));
   }

   public static BrobInt valueOf( long value ) throws NumberFormatException {
      BrobInt gi = null;
      try {
//         gi = new BrobInt( new Long( value ).toString() );
         gi = new BrobInt( Long.valueOf( value ).toString() );
      }
      catch( NumberFormatException nfe ) {
         System.out.println( "\n  Sorry, the value must be numeric of type long." );
      }
      return gi;
   }

   public String toString() {
      String byteVersionOutput = "";
      for( int i = 0; i < byteVersion.length; i++ ) {
         byteVersionOutput = byteVersionOutput.concat( Byte.toString( byteVersion[i] ) );
      }
      byteVersionOutput = new String( new StringBuffer( byteVersionOutput ).reverse() );
      return internalValue;
   }

   public void toArray( byte[] d ) {
      System.out.println( Arrays.toString( d ) );
   }

   public static void main(String[] args) {
      System.out.println( "\n  Hello, world, from the BrobInt program!!\n" );
      System.out.println( "\n   You should run your tests from the BrobIntTester...\n" );
   }

   public BrobInt copy() {
       return new BrobInt(this.toString());
   }
}
