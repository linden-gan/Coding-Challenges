import java.util.*;

public class FindMostFrequent {
   public static void main(String[] args) {
      int[] arr = {1, 1, 2, 2, 3, 10000, 10000, 10000};
      System.out.println(findMostFrequent(arr));
   }
   
   public static List<Integer> findMostFrequent(int[] input) {
      if (input.length == 0) return null;
      List<Integer> list = new ArrayList<Integer>(); // in case there are multiple max values
      Map<Integer, Integer> map = new HashMap<>();
      for (int num : input) {
         if (!map.containsKey(num)) {
            map.put(num, 0);
         }
         map.put(num, map.get(num) + 1);
      }
      int maxTime = 0;
      for (int element : map.keySet()) {
         if (map.get(element) > maxTime) {
            list.clear();
            list.add(element);
            maxTime = map.get(element);
         } else if (map.get(element) == maxTime) {
            list.add(element);
         }
      }
      return list;
   }
}