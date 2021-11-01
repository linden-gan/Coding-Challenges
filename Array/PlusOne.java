import java.util.*;

/**
 * Given an array [1, 5, 3, 0, 9] representing an integer 15309
 * Output a new array representing this integer plus 1.
*/
public class PlusOne {
   public static void main(String[] args) {
   
   }
   
   public int[] plusOne(int[] digits) {;
        int index = digits.length - 1;
        digits[index]++;
        while (digits[index] >= 10 && index > 0) { // continue to add one to digits
            digits[index] -= 10;
            digits[index - 1]++;
            index--;
        }
        if (digits[0] >= 10) { // if run out of digits
            int[] usurp = new int[digits.length + 1];
            usurp[0] = 1;
            usurp[1] = digits[0] - 10;
            for (int i = 2; i < usurp.length; i++) {
                usurp[i] = digits[i - 1];
            }
            return usurp;
        } else {
            return digits;
        }
    }
}