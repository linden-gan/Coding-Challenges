import java.util.*;

public class CountWords {
   public static void main(String[] args) {
      System.out.println(countWords("7  ddddd f e 0               f  "));
   }
   
   static int countWords(String s) {
      int result = 0;
      boolean real = true;
      for (int index = 0; index < s.length(); index++) {
         if (s.charAt(index) != ' ' && real) {
            real = false;
            result++;
         } else if (s.charAt(index) == ' ') {
            real = true;
         }
      }
      return result;
   }
   
   static int countWords2(String s) {
      int result = 0;
      for (int index = 1; index < s.length(); index++) {
         if (s.charAt(index) != ' ' && s.charAt(index - 1) == ' ') {
            result++;
         }
      }
      return result;
   }
}