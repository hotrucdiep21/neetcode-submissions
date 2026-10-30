class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Insert cloned nodes right after original nodes
        Node curr = head;
        while (curr != null) {
            Node nextOriginal = curr.next;
            Node clone = new Node(curr.val);
            curr.next = clone;
            clone.next = nextOriginal;
            curr = nextOriginal;
        }

        // Step 2: Assign random pointers for the cloned nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Restore original list and extract the cloned list
        curr = head;
        Node dummyHead = new Node(0);
        Node copyCurr = dummyHead;

        while (curr != null) {
            Node nextOriginal = curr.next.next;
            
            // Extract the clone
            copyCurr.next = curr.next;
            copyCurr = copyCurr.next;
            
            // Restore the original list
            curr.next = nextOriginal;
            
            curr = nextOriginal;
        }

        return dummyHead.next;
    }
}