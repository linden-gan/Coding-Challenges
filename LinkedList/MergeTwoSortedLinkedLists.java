import java.util.*;

public class MergeTwoSortedLinkedLists {
   public static void main(String[] args) {
     
   }
   
   public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       if (l1 == null) {
           return l2;
       } else if (l2 == null) {
           return l1;
       } else {
           if (l1.val <= l2.val) {
               l1.next = mergeTwoLists(l1.next, l2); // x = change(x);
               return l1;
           } else {
               l2.next = mergeTwoLists(l1, l2.next);
               return l2;
            }
        }
    }
}
