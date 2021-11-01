import java.util.*;

public class RotateArray {
   public static void main(String[] args) {
      int[] test = {1, 2, 3, 4, 5, 6, 7, 8};
      rotateRight(test);
      System.out.println(Arrays.toString(test));
   }
   
   public static void rotateRight(int[] arr) {
      if (arr.length > 1) {
         int last = arr[arr.length - 1];
         for (int index = arr.length - 2; index >= 0; index--) {
            arr[index + 1] = arr[index];
         }
         arr[0] = last;
      }
   }
   
   public static void rotateLeft(int[] arr) {
      if (arr.length > 1) {
         int first = arr[0];
         for (int index = 1; index < arr.length; index++) {
            arr[index - 1] = arr[index];
         }
         arr[arr.length - 1] = first;
      }
   }
   
   /*public static void rotateRight(int[]arr, int times) {
      if (arr.length > 1) {
         for (int count = 1; count <= times; count++) {
            int last = arr[arr.length - count];
            for (int index = arr.length - count - times; index >= times; index -= times) {
               arr[index + times] = arr[index];
            }
            arr[times - count] = last;
         }
      }
   }*/
}