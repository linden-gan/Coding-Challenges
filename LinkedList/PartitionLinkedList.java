/**
 * Partition a linked list so that node smaller than x come first 
 * while node equal or larger than x come after. No deep copy allowed
 */
class PartitionLinkedList {
   public ListNode partition(ListNode head, int x) {
        ListNode cur = head;
        ListNode small = new ListNode(0); // using sentinel node is a smart way to avoid edge cases
        ListNode large = new ListNode(0);
        ListNode smallCur = small; // points to the last node in small/large list
        ListNode largeCur = large;
        while (cur != null) {
            if (cur.val < x) {
                smallCur.next = cur; // lastNode.next = cur
                smallCur = smallCur.next; // move smallCur next
            } else {
                largeCur.next = cur;
                largeCur = largeCur.next;
            }
            cur = cur.next; // move cur next
        }
        smallCur.next = large.next; // small list's lastNode.next = first node of large list, ignoring sentinel
        largeCur.next = null; // set to null to avoid cycle. IMPORTANT
        head = small.next; // ignore sentinel again
        return head;
   }
}