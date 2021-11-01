import java.util.*;

public class LastWordLength {
   public static void main(String[] args) {
   
   }
   
   public static int lengthOfLastWord(String s) {
        if (s.equals("")) return 0;
        int right = s.length() - 1;
        while (right >= 0 && s.charAt(right) == ' ') {
            right--;
        }
        int left = right;
        while (left >= 0 && s.charAt(left) != ' ') {
            left--;
        }
        return right - left;
    }
}