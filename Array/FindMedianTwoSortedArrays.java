class FindMedianTwoSortedArrays {

   /**
    * Find the median value of two sorted arrays in one traverse
    * Consider cases of both odd and even number of elements
    */
   public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int middle = total / 2; // 8 / 2 -> 4, 9 / 2 -> 4
        int i1 = 0;
        int i2 = 0;
        int curr = 0;
        while (middle != 0) {
            middle--;
            if (i2 >= nums2.length || (i1 < nums1.length && nums1[i1] <= nums2[i2])) { ////////////
                curr = nums1[i1];
                i1++;
            } else {
                curr = nums2[i2];
                i2++;
            }
        }
        
        int oneMore = (i2 >= nums2.length || (i1 < nums1.length && nums1[i1] <= nums2[i2])) ?
                       nums1[i1] : nums2[i2]; // next value one more time
        if (total % 2 == 1) {
            return oneMore;
        } else {
            return (oneMore + curr) / 2.0;
        }
    }
}