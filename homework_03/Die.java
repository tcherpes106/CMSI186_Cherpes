import java.util.Random;
public class Die {

   private int sides;
   private int pips;
   private final int MINIMUM_SIDES = 4;
   private Random randomValue = new Random();

   public Die(int nSides){
     sides = nSides;
     pips = randomValue.nextInt(sides) + 1;
   }

// this should return an int, not void
   public int roll() {
     pips = randomValue.nextInt(sides) + 1;
     return pips;     // need a return to return an int
   }


   public int getValue(){
      return pips;
   }


   public String toString(){
      return "[" + (pips) + "]";
   }


   public static String toString( Die d ){
      return d.toString();
   }


   public static void main( String[] args ){
      Die die1 = new Die(17);
      die1.roll();
      System.out.println("The value is: " + die1.getValue());
      die1.roll();
      System.out.println("The value is: " + Die.toString(die1));
   }
}
