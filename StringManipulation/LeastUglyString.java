import java.util.*;

/**
 * A string is composed exclusively by 'A', 'B', and '?'.
 * Ugliness is defined by the number of repeated, adjacent pairs of alphabet, like AA and BB
 * Now, ? can be replace by either A or B.
 * Given a string like A?A???BBA?ABAA?BA??, what's its minimum possible ugliness?
 *
 * AAA -> ugliness = 2
 * AB???A -> minimum ugliness = 1
*/
public class LeastUglyString {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println(method(console.nextLine()));
    }
    
    // Partially correct solution (80%)
    // I think the crucial part is ?: if it's pattern is A??A or A???B,
    // then there is at least 1 ugly pair. If it's pattern is A?A or A??B,
    // then it can be optimized to ABA or ABAB, which has no ugliness.
    // For A and B part, we can just use regular method to examine repeated pairs.
    public static int method(String str) {
        if (str.length() <= 1) return 0;
        int i = 0;
        int j = 1; // examine the string in unit of 2
        int ugly = 0;
        int streak = 0; // track the number of ?
        char left = ' ';
        char right = ' ';
        while (j < str.length()) {
            if ((str.charAt(i) == 'A' && str.charAt(j) == 'A') || 
               (str.charAt(i) == 'B' && str.charAt(j) == 'B')) { // regular examination
                ugly++;
            } else if ((str.charAt(i) != '?') && str.charAt(j) == '?') {
                streak++;
                left = str.charAt(i);
            } else if ((str.charAt(i) == '?') && str.charAt(j) != '?') {
                right = str.charAt(j);
                if ((left == right && streak % 2 == 0) || (left != right && streak % 2 == 1)) {
                    ugly++;
                }
                streak = 0;
            } else if (str.charAt(i) == '?' && str.charAt(j) == '?') {
                streak++;
            }
            i++;
            j++;
           
        }
        return ugly;
    }
}