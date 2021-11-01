public class ListPartitionable {
   public static boolean partitionable(List<Integer> nums) {
      return partitionable(nums, 0, 0, 0);
   }

   public static boolean partitionable(List<Integer> nums, int index, int partA, int partB) {
       if (index == nums.size()) {
           return partA == partB;
       } else {
           return partitionable(nums, index + 1, partA + nums.get(index), partB) || 
               partitionable(nums, index + 1, partA, partB + nums.get(index));
       }
   }
}