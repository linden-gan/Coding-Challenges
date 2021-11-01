import java.util.*;

public class PascalsTriangle {
   public static void main(String[] args) {
      System.out.println(generate(10));
   }
   
   public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            result.add(new ArrayList<>());
            List<Integer> topic = result.get(i);
            List<Integer> before = null; // placeholder
            if (i > 1) before = result.get(i - 1); // prevent -1 IndexOutOfBoundException
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    topic.add(1);
                } else {
                    topic.add(before.get(j - 1) + before.get(j));
                }
            }
        }
        return result;
    }
}