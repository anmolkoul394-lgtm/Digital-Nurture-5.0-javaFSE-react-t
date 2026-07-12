// DoublyLinkedListDemo.java
// Demonstrates a Doubly Linked List: each node points to BOTH the next AND the previous node.
// This allows traversal in both directions.
// Supports: insert (at end), traverse (forward & backward), search, delete (by value).

class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    private DLLNode head;
    private DLLNode tail;

    // Insert a new node at the end - O(1) since we keep a tail pointer.
    public void insert(int data) {
        DLLNode newNode = new DLLNode(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Traverse forward (head -> tail).
    public void traverseForward() {
        StringBuilder sb = new StringBuilder("Forward:  ");
        DLLNode current = head;
        while (current != null) {
            sb.append(current.data).append(" <-> ");
            current = current.next;
        }
        sb.append("null");
        System.out.println(sb);
    }

    // Traverse backward (tail -> head) - only possible because of the 'prev' pointer.
    public void traverseBackward() {
        StringBuilder sb = new StringBuilder("Backward: ");
        DLLNode current = tail;
        while (current != null) {
            sb.append(current.data).append(" <-> ");
            current = current.prev;
        }
        sb.append("null");
        System.out.println(sb);
    }

    // Search for a value - O(n).
    public boolean search(int target) {
        DLLNode current = head;
        while (current != null) {
            if (current.data == target) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Delete the first node matching the given value.
    public void delete(int target) {
        DLLNode current = head;
        while (current != null) {
            if (current.data == target) {
                // Re-link the previous node's "next" (or move head)
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                // Re-link the next node's "prev" (or move tail)
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                return;
            }
            current = current.next;
        }
    }
}

public class DoublyLinkedListDemo {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);

        list.traverseForward();
        list.traverseBackward();

        System.out.println("Searching for 20: " + (list.search(20) ? "Found" : "Not Found"));

        System.out.println("Deleting 20...");
        list.delete(20);

        list.traverseForward();
    }
}
