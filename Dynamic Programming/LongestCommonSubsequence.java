/**
 * Find the longest common subsequence of two strings.
 * A common subsequence is defined as a sequence of characters 
 * that appear in both strings in the same relative order. They don't have to occur consecutively.
 * (BGCEHAF, ABCDEFGHI) -> BCEF | BCEH
 */
public class LongestCommonSubsequence {
   public static void main(String[] args) {
      String a = "BGCEHAFZ";
      String b = "ABCDEFGHIYZ";
      System.out.println(longestCommonSubsequence(a, b));
   }

   public static String longestCommonSubsequence(String a, String b) {
       if (a.equals("") || b.equals("")) { // base case: end
           return "";
       } else if (a.charAt(0) == b.charAt(0)) { // h:[remaining], h:[remaining]
           // recurse to [remaining], [remaining] and add h
           return a.charAt(0) + longestCommonSubsequence(a.substring(1), b.substring(1));
       } else { // a:[remaining], b:[remaining]
           String left = longestCommonSubsequence(a.substring(1), b); // recurse to [remaining], b:[remaining]
           String right = longestCommonSubsequence(a, b.substring(1)); // recurse to a:[remaining], [remaining]
           return left.length() > right.length() ? left : right;
       }
   }
}