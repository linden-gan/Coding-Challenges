import java.util.*;

public class RotateLinkedList {
   public static void main(String[] args) {
      
   }
   
   public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int size = 1;
        ListNode curr = head;
        while (curr.next != null) {
            size++;
            curr = curr.next;
        }
        k = k % size;
        if (k == 0) return head;
        ListNode kCurr = head;
        for (int count = 1; count < size - k; count++) {
            kCurr = kCurr.next;
        }
        curr.next = head;
        head = kCurr.next;
        kCurr.next = null;
        return head;
    }
}