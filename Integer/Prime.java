import java.util.*;
import java.io.*;

public class Prime {
   public static void main(String[] args) throws FileNotFoundException { // There is already a list of <1000000 prime numbers
      System.out.println(getPrimes(343));
   }
   
   public static List<Integer> getPrimes(int input) throws FileNotFoundException {
      if (input < 0 || input > 1000000) throw new IllegalArgumentException();
      List<Integer> result = new LinkedList<>();
      if (input == 0 || input == 1) {
         result.add(input);
         return result;
      }
      // create a list of possible prime numbers
      List<Integer> candidates = new ArrayList<>();
      Scanner scan = new Scanner(new File("primeNumbers.txt"));
      int num = scan.nextInt();
      while (scan.hasNextInt() && num <= input) {
         candidates.add(num);
         num = scan.nextInt();
      }
      // begin testing
      while (input != 1) {
         int index = 0;
         int test = candidates.get(index);
         while (input % test != 0) {
            index++;
            test = candidates.get(index);
         }
         result.add(test);
         input /= test;
      }
      return result;
   }
   
   public static boolean isPrime(int input) {
      if (input <= 0) throw new IllegalArgumentException();
      for (int test = 2; test <= input / 2; test++) {
         if (input % test == 0) {
            return false;
         }
      }
      return true;
   }
   
   public static List<Integer> printFactors(int input) {
      if (input <= 0) throw new IllegalArgumentException();
      List<Integer> result = new LinkedList<>();
      for (int test = 1; test <= input / 2; test++) {
         if (input % test == 0) {
            result.add(test);
         }
      }
      result.add(input);
      return result;
   }
   
   public static int maxCommonFactor(int a, int b) {
      if (a <= 0 || b <= 0) throw new IllegalArgumentException();
      for (int test = Math.min(a, b); test > 1; test--) {
         if (a % test == 0 && b % test == 0) {
            return test;
         }
      }
      return 1;
   }
   public static int maxCommonFactor(int a, int b, int c) {
      if (a <= 0 || b <= 0 || c <= 0) throw new IllegalArgumentException();
      for (int test = Math.min(a, Math.min(b, c)); test > 1; test--) {
         if (a % test == 0 && b % test == 0 && c % test == 0) {
            return test;
         }
      }
      return 1;
   }
}