import java.util.*;

class LongestNonRepeat {
    public int lengthOfLongestSubstring(String s) {
        int leng = s.length();
        if (leng <= 1) {
            return leng;
        }
        int result = 1;
        Set<Character> set = new HashSet<>();
        for (int index = 0; index < leng - result; index++) {
            for (int sub = leng; sub > index + result; sub--) {
                if (nonrepeat(s.substring(index, sub), set)) {
                    result = sub - index;
                }
                if (result >= 94) { // when sub-string's length is larger than 94, it must repeat.
                    return result;  // Try to think a better way.
                }
            }
        }
        return result;
    }
    
    private static boolean nonrepeat(String s, Set<Character> set) {
        set.clear();
        for (int index = 0; index < s.length(); index++) {
            if (set.contains(s.charAt(index))) {
                return false;
            } else {
                set.add(s.charAt(index));
            }
        }
        return true;
    }
}