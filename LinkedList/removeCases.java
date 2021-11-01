import java.util.*;
/*********************
Write a method removeAll that removes all occurrences of a particular value. For example, if a variable list contains the following values:

[to, be, or, not, to, be]

The call of list.removeAll("be"); would remove all occurrences of the value "be" from the list, yielding the following values:

[to, or, not, to]
*********************/
public class removeCases {
   public static void main(String[] args) {
   
   }
   
   public void removeAll(Object o) {
       if (front != null) {
           front = removeAll(o, front);
       }
   }  

   private ListNode removeAll(Object o, ListNode curr) {
       if (curr == null) return null;
       curr.next = removeAll(o, curr.next);
       if (curr.data.equals(o)) {
           return curr.next;
       } else {
           return curr;
       }
   }
}