package Integer;

public class GCD {
   public static void main(String[] args) {
      System.out.println(gcd(44, 100));
   }
   
   public static int gcd(int big, int little) {
      if (little == 0) {
         return big;
      } else {
         return gcd(little, big % little);
      }
   }
}