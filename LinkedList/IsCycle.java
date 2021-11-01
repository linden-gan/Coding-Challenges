import java.util.*;

public class IsCycle {
   public static void main(String[] args) {
   
   }
   
   public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next; // if has cycle, fast will catch slow
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}