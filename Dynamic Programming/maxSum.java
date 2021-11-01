/**
 * Given a list of integers, find the maximum possible sum which is less or equal to limit
*/
public class maxSum {
   public int maxSum(List<Integer> list, int limit) {
       if (list.isEmpty()) return 0;
       return maxSum(list, 0, 0, limit);
   }
   
   // Use index as decision tree (sum plus list[index] or not)
   private int maxSum(List<Integer> list, int index, int sum, int limit) {
       if (index >= list.size() && sum <= limit) { // classical base case
           return sum;
       } else if (index < list.size() && sum <= limit) {
           return Math.max(maxSum(list, index + 1, sum + list.get(index), limit), 
                           maxSum(list, index + 1, sum, limit));
       }
       return 0; // if bad case, return 0
   }
}