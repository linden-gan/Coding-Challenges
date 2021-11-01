import java.util.*;

public class MergeTwoSortedArrays {
   public static void main(String[] args) {
      int[] a1 = {2, 3, 4, 5, 6, 7, 8};
      int[] a2 = {-2, 0, 99};
      System.out.println(Arrays.toString(merge(a1, a2)));
   }
   
   public static int[] merge(int[] a1, int[] a2) {
      if (a1.length == 0) return a2;
      if (a2.length == 0) return a1;
      int[] result = new int[a1.length + a2.length];
      int i1 = 0;
      int i2 = 0;
      // the if else branch is the crucial part
      for (int index = 0; index < result.length; index++) {
         if (i2 >= a2.length || (i1 < a1.length && a1[i1] <= a2[i2])) { /////////
            result[index] = a1[i1];
            i1++;
         } else {
            result[index] = a2[i2];
            i2++;
         }
      }
      return result;
   }
}