import java.util.*;

public class LongestPalindrome {
   public static void main(String[] args) {
      
   }   
   
   public static String longestPalindrome(String input) {
      if (input.length() <= 1) {
         return input;
      }
      String result = "";
      int chang = input.length();
      for (int first = 0; first < chang - result.length(); first++) {
         for (int last = chang - 1; last > first + result.length(); last--) { // enhance efficiency
            if (isPalindrome(input.substring(first, last)) && last - first > result.length()) {
               result = input.substring(first, last);
            }
         }
      }
      return result;
   }
   
   private static boolean isPalindrome(String input) {
      int chang = input.length();
      for (int index = 0; index < chang / 2; index++) {
         if (input.charAt(index) != input.charAt(chang - index - 1)) {
            return false;
         }
      }
      return true;
   }
}