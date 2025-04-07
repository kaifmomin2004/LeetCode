// You are given the heads of two sorted linked lists list1 and list2.
// Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
// Return the head of the merged linked list.

// Input: list1 = [1,2,4], list2 = [1,3,4]
// Output: [1,1,2,3,4,4]

public class lc0021 {
    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    // Your task: implement this method
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode n = new ListNode(0);
        ListNode h = n;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                h.next = list1;
                list1 = list1.next;
            }
            else {
                h.next = list2;
                list2 = list2.next;
            }
            h = h.next;
        }
        h.next = list1 != null ? list1 : list2;
        return n.next;
    }

    public static void main(String[] args) {
        // Create list1: 1 → 2 → 4
        ListNode list1 = new ListNode(2);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        // Create list2: 1 → 3 → 4
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        // Merge the lists
        ListNode merged = mergeTwoLists(list1, list2);

        // Print the result
        printList(merged);
    }

    // Helper function to print the list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
}