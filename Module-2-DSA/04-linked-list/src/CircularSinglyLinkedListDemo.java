// CircularSinglyLinkedListDemo.java
// Demonstrates a Circular Singly Linked List: like a singly linked list,
// but the LAST node's "next" points back to the HEAD, forming a circle (no null at the end).
// Supports: insert (at end), traverse, search, delete (by value).

class CSLLNode {
    int data;
    CSLLNode next;

    CSLLNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularSinglyLinkedList {
    private CSLLNode head;

    // Insert a new node at the end, then re-link the last node back to head.
    public void insert(int data) {
        CSLLNode newNode = new CSLLNode(data);
        if (head == null) {
            head = newNode;
            head.next = head; // points to itself - the circle of one node
            return;
        }
        CSLLNode current = head;
        while (current.next != head) { // walk until we reach the node pointing back to head
            current = current.next;
        }
        current.next = newNode;
        newNode.next = head; // close the circle
    }

    // Traverse exactly once around the circle and print all elements.
    public void traverse() {
        StringBuilder sb = new StringBuilder("Circular Linked List: ");
        if (head == null) {
            System.out.println(sb + "(empty)");
            return;
        }
        CSLLNode current = head;
        do {
            sb.append(current.data).append(" -> ");
            current = current.next;
        } while (current != head);
        sb.append("(back to head)");
        System.out.println(sb);
    }

    // Search for a value by walking once around the circle.
    public boolean search(int target) {
        if (head == null) {
            return false;
        }
        CSLLNode current = head;
        do {
            if (current.data == target) {
                return true;
            }
            current = current.next;
        } while (current != head);
        return false;
    }

    // Delete the first node matching the given value.
    public void delete(int target) {
        if (head == null) {
            return;
        }
        CSLLNode current = head;
        CSLLNode previous = null;

        // Special case: deleting the head node
        if (head.data == target) {
            if (head.next == head) { // only one node in the list
                head = null;
                return;
            }
            // Find the last node so we can re-link it to the new head
            CSLLNode last = head;
            while (last.next != head) {
                last = last.next;
            }
            head = head.next;
            last.next = head;
            return;
        }

        // Search for the node to delete
        do {
            previous = current;
            current = current.next;
            if (current.data == target) {
                previous.next = current.next;
                return;
            }
        } while (current != head);
    }
}

public class CircularSinglyLinkedListDemo {
    public static void main(String[] args) {
        CircularSinglyLinkedList list = new CircularSinglyLinkedList();
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
