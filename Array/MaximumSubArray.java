public class MaximumSubArray {
   public static void main(String[] args) {
   
   }
   
   /**
   * Find the consecutive subarray with maximum sum of its elements
   * Return this sum
   * Note that the whole array can have negative values
   * 
   * How to do this in one traverse?
   *
   * Like usual finding max-min problem, it's a good idea to have a maxSum to always remember the maximum
   * Imagine a cursor on the array: whenever moving to next index, it has two options:
   * Either add the number in this index to its sum, or discard its sum and add the number in this index as
   * the first value of a new sum.
   *
   * Here we have a decision tree, and we always want the max value of the tree's branches.
   */
   public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sumUpto = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sumUpto = Math.max(sumUpto + nums[i], nums[i]); // which is larger? previous sum + this number
                                                           // or this number alone as a new sum
            maxSum = Math.max(sumUpto, maxSum); // keep maximum
        }
        return maxSum;
    }
}