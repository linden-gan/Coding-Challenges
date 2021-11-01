import java.util.*;

// head -> 1 -> 2 -> 3 -> 4 -> 5 -> null
// head -> 5 -> 4 -> 3 -> 2 -> 1 -> null
public class ReverseLinkedList {
   public static void main(String[] args) {
   
   }
   
   public ListNode reverseList(ListNode head) {
        Stack<ListNode> s = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            s.push(curr);
            curr = curr.next;
        }
        head = add(s, head);
        return head;
    }
    
    private ListNode add(Stack<ListNode> s, ListNode node) { // use a stack to reverse
        if (s.isEmpty()) {
            return null;
        } else {
            node = s.pop();
            node.next = add(s, node.next);
            return node;
        }
    }
}