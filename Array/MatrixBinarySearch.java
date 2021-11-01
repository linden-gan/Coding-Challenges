import java.util.*;

public class MatrixBinarySearch {
   public static void main(String[] args) {
      int[] arr = {1, 2, 3, 4};
      System.out.println(findNumber2(arr, 7));
   }
   
   public static boolean searchMatrix(int[][] matrix, int target) { // use binary search to find a target in a sorted matrix
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        if (n == 0) return false; // special dummy matrices
        
        int a = 1;
        int b = m;
        while (b != a) { // determine row
            int mid = (b + a) / 2;
            if (matrix[mid][0] < target) {
                a = mid + 1;
            } else if (matrix[mid][0] == target) {
                return true;
            }  else {
                b = mid;
            }
        }
        int left = 0;
        int right = n;
        while (left != right) { // determine column
            int mid = (left + right) / 2;
            if (matrix[a - 1][mid] < target) {
                left = mid + 1;
            } else if (matrix[a - 1][mid] == target) {
                return true;
            } else {
                right = mid;
            }
        }
        return false;
    }
    
    public static boolean findNumber1(int[] arr, int target) {
       if (arr.length == 0) return false; // special case
       int left = 0;
       int right = arr.length - 1;
       if (arr[left] == target || arr[right] == target) return true; // special cases
       while (right - left > 1) {
          int mid = left + (right - left) / 2; // prevent overflow
          if (arr[mid] < target) {
             left = mid;
          } else if (arr[mid] == target) {
             return true;
          } else {
             right = mid;
          }
       }
       return false;
    }
    
    public static boolean findNumber2(int[] arr, int target) {
       if (arr.length == 0) return false; // special case
       int left = 0;
       int right = arr.length - 1;
       while (right > left) {
          int mid = left + (right - left) / 2; // prevent overflow
          if (arr[mid] < target) {
             left = mid + 1; // remember 1 / 2 == 0
          } else if (arr[mid] == target) {
             return true;
          } else {
             right = mid;
          }
       }
       return false;
    }
    
    public static int findBorder(int[] arr) { // arr: [0, 0, 0, 1, 1], return the index of the last 0
       if (arr.length == 0) return -1;
       int left = 0;
       int right = arr.length - 1;
       if (arr[left] == 1) return -1;
       if (arr[right] == 1) return right;
       while (left < right) {
          int mid = left + (right - left) / 2;
          if (arr[mid] == 0) {
             left = mid + 1;
          } else {
             right = mid;
          }
       }
       return right - 1;
    }
}