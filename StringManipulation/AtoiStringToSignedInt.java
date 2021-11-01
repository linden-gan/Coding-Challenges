public class AtoiStringToSignedInt {
   public int myAtoi(String s) {
        // must use long to avoid java's error
        long result = 0;
        // ignore any white space
        int cur = 0;
        while (cur < s.length() && s.charAt(cur) == ' ') {
            cur++;
        }
        
        // sanity check ----impoortant!----
        if (cur == s.length()) {
            return 0;
        }
        
        // determine sign
        boolean positive = true;
        if (s.charAt(cur) == '-') {
            positive = false;
            cur++;
        } else if (s.charAt(cur) == '+') {
            cur++;
        }
        
        
        // parse digits
        while (cur < s.length() && s.charAt(cur) >= '0' && s.charAt(cur) <= '9') {
            result *= 10;
            result += Integer.parseInt(s.charAt(cur) + "");
            int trie = clamp(result, positive);
            if (trie != 0) {
                return trie;
            }
            cur++;
        }
        return (int) (positive ? result : -1 * result);
    }
    
    public int clamp(long num, boolean positive) {
        if (positive && num > Math.pow(2, 31) - 1) {
            return (int) (Math.pow(2, 31) - 1);
        } else if (!positive && num > Math.pow(2, 31)) {
            return (int) (-1 * Math.pow(2, 31));
        } else {
            return 0;
        }
    }
}