// SinglyLinkedListDemo.java
// Demonstrates a Singly Linked List: each node points only to the NEXT node.
// Supports: insert (at end), traverse, search, delete (by value).

class SLLNode {
    int data;
    SLLNode next;

    SLLNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    private SLLNode head;

    // Insert a new node at the end of the list - O(n) since we walk to the tail.
    public void insert(int data) {
        SLLNode newNode = new SLLNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        SLLNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Traverse and print all elements - O(n).
    public void traverse() {
        StringBuilder sb = new StringBuilder("Linked List: ");
        SLLNode current = head;
        while (current != null) {
            sb.append(current.data).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        System.out.println(sb);
    }

    // Search for a value - O(n). Returns true if found.
    public boolean search(int target) {
        SLLNode current = head;
        while (current != null) {
            if (current.data == target) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Delete the first node matching the given value - O(n).
    public void delete(int target) {
        if (head == null) {
            return;
        }
        // Special case: deleting the head node
        if (head.data == target) {
            head = head.next;
            return;
        }
        SLLNode current = head;
        while (current.next != null && current.next.data != target) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next; // unlink the matching node
        }
    }
}

public class SinglyLinkedListDemo {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);

        list.traverse();

        System.out.println("Searching for 20: " + (list.search(20) ? "Found" : "Not Found"));

        System.out.println("Deleting 20...");
        list.delete(20);

        System.out.print("After deletion -> ");
        list.traverse();
    }
}
