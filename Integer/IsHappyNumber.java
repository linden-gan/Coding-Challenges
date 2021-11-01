import java.util.*;
/*****************
19 -> 1^2 + 9^2 = 82 => 8^2 + 2^2 = 68 -> 6^2 + 8^2 = 100 -> 1^2 + 0^2 + 0^2 = 1 (Happy Number)
If a number is not happy, then there will be an endless loop.
*****************/
public class IsHappyNumber {
   public static void main(String[] args) {
   
   }
   
   public boolean isHappy(int n) {
        Set<Integer> s = new HashSet<>();
        while (n != 1) {
            if (s.contains(n)) {
                return false;
            }
            s.add(n);
            n = produce(n);
        }
        return true;
    }
    
    private static int produce(int n) {
        int result = 0;
        while (n > 0) {
            int digit = n % 10;
            result += digit * digit;
            n /= 10;
        }
        return result;
    }
}